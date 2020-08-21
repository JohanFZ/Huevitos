/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevosaj;

/**
 *
 * @author JohanF
 */
import static huevosaj.Controlador_Registro.contacto1;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class Controlador_Registro implements ActionListener  {
    
    Vista_Registro vis1;
    BD_huevos mom;
    
        Controlador_Registro(Vista_Registro v1, BD_huevos m) {
        mom = m;
        vis1 = v1;
        
        vis1.Registro.addActionListener(this);
        vis1.Inicio.addActionListener(this);
        vis1.CerrarB.addActionListener(this);
        vis1.MinimizarB.addActionListener(this);
    }
        
    public void limpiarUsu() {
        vis1.PrimerNombre.setText(null);
        vis1.SegundoNombre.setText(null);
        vis1.PrimerApellido.setText(null);
        vis1.SegundoApellido.setText(null);
        vis1.Email.setText(null);
        vis1.Usuario.setText(null);
        vis1.Contra.setText(null);
    }
    static Connection contacto1 = null;

    @Override
    public void actionPerformed(ActionEvent e) {
if (e.getSource() == vis1.Registro) {
            contacto1 = huevosaj.BD_huevos.getConexion();
            int et = this.mom.Val_Usu_CO(this.vis1.Usuario.getText());
            int co = this.mom.Val_Usu_Correo(this.vis1.Email.getText());
            if (vis1.PrimerNombre.getText().isEmpty() || vis1.SegundoNombre.getText().isEmpty() || vis1.PrimerApellido.getText().isEmpty() || vis1.SegundoApellido.getText().isEmpty() || vis1.Email.getText().isEmpty() || vis1.Usuario.getText().isEmpty() ||vis1.Contra.getText().isEmpty() ) { // si estos coampos no estan llenos
                JOptionPane.showMessageDialog(null, "campos vacios");
            } else {
                if (et == 1) {
                    JOptionPane.showMessageDialog(null, "Este Usuario ya esta Registrado");
                } else {
                    if (co == 1) {
                        JOptionPane.showMessageDialog(null, "Este Correo ya esta Registrado");
                    } else {
                        if ((vis1.Usuario.getText().length() <= 3) || (vis1.Usuario.getText().length() >= 10)) {// longitud de la contraseña
                            JOptionPane.showMessageDialog(null, "El nombre de su usuario no es valido");
                        } else {
                            if ((vis1.Contra.getText().length() <= 5) || (vis1.Contra.getText().length() >= 10)) {
                                JOptionPane.showMessageDialog(null, "Su Contraseña no es valida");
                            } else {

                                if (!vis1.Email.getText().contains("@") || !vis1.Email.getText().contains(".")) {
                                    JOptionPane.showMessageDialog(null, "Correo invalido");
                                } else {
                                                int v = this.mom.Agre_Usu(vis1.PrimerNombre.getText(), vis1.SegundoNombre.getText(), vis1.PrimerApellido.getText(), vis1.SegundoNombre.getText(), vis1.Email.getText(), vis1.Usuario.getText(), vis1.Contra.getText());
                                                limpiarUsu();
                                                if (v == 0) {
                                                    JOptionPane.showMessageDialog(null, "no Guardado", "informacion", 0);
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "Usuario Registrado", "informacion", 1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            mom.desconectar();
            }
        if (e.getSource() == vis1.CerrarB) {
            System.exit(0);
        }
        if (e.getSource() == vis1.MinimizarB) {
            vis1.setExtendedState(ICONIFIED);
        }
        if (e.getSource() == vis1.Inicio) {
            Vista_login v = new Vista_login();
            BD_huevos m =new  BD_huevos ();
            Controlador_Login n = new  Controlador_Login (v,m);
            vis1.setVisible(false);
        }
    }
}
