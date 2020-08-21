/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevosaj;

import static huevosaj.Controlador_Registro.contacto1;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.Connection;

/**
 *
 * @author Spacecode A&J
 */
public class Controlador_Login implements ActionListener {

    Vista_login Vis;
    BD_huevos mom;

    int timer = 0;

    Controlador_Login(Vista_login v, BD_huevos m ) {
        mom = m;
        Vis = v;
        

        

        this.Vis.JBingresar.addActionListener(this);
        this.Vis.JBminimizar.addActionListener(this);
        this.Vis.JBcerrar.addActionListener(this);
        Vis.JBregistrate.addActionListener(this);

    }

    static Connection contacto1 = null;

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.Vis.JBingresar) {
            contacto1 = huevosaj.BD_huevos.getConexion();
            if (this.Vis.JTusuario.getText().equals("") || this.Vis.JPcoontraseña.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Campo vacio", "Campos vacios", JOptionPane.ERROR_MESSAGE);
            } else {
                int est = this.mom.Val_Usu_log(this.Vis.JTusuario.getText(), this.Vis.JPcoontraseña.getText());

                if (est == 1) {
                    System.out.println("Sesión iniciada");

                 

                    Vista_menu M = new Vista_menu();
                    BD_huevos n = new BD_huevos();
                      Controlador_menu CM = new Controlador_menu(M,n);

                    this.Vis.setVisible(false);

                } else if (timer == 3) {
                    JOptionPane.showMessageDialog(null, "Ha exedido el numero de intentos. Vuelva mas tarde", "Informacin invalidda", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario o la contrario son incorrectos, Intentalo nuevamente .\n Quedan " + (3 - timer) + "   Intentos", "Informacin invalidda", JOptionPane.ERROR_MESSAGE);
                    timer = timer + 1;
                }
            }
            mom.desconectar();
        }
        if (ae.getSource() == Vis.JBcerrar) {
            System.exit(0);
        }
        if (ae.getSource() == Vis.JBminimizar) {
            Vis.setExtendedState(ICONIFIED);
        }
        if (ae.getSource() == Vis.JBregistrate) {
            Vista_Registro v1 = new Vista_Registro ();
            BD_huevos m =new  BD_huevos ();
            Controlador_Registro  n = new  Controlador_Registro  (v1,m);
            Vis.setVisible(false);
        }
        
        }
    }

