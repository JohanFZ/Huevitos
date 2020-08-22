/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevosaj;

import static huevosaj.Controlador_Registro.contacto1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author michi
 */
public class Controlador_menu implements ActionListener {

    Vista_menu vs;
    BD_huevos mom;
   

    Controlador_menu(Vista_menu v, BD_huevos m) {
        mom = m;
        vs = v;
      

        this.vs.JBclientes.addActionListener(this);
        this.vs.JBproveedores.addActionListener(this);
        this.vs.JBcompras.addActionListener(this);
        this.vs.JBventas.addActionListener(this);
        this.vs.JBinformec.addActionListener(this);
        this.vs.JBinformev.addActionListener(this);
        this.vs.JBproductos.addActionListener(this);
        this.vs.JBinventario.addActionListener(this);

       
    

    }

    

    static Connection contacto1 = null;

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vs.JBproveedores) {
            
            Vista_Proveedor v1 = new Vista_Proveedor();
            BD_huevos m = new BD_huevos();
            Controlador_Proveedor n = new Controlador_Proveedor(v1, m);
            
            vs.setVisible(false);

        }
        if (ae.getSource() == vs.JBclientes) {          
            Vista_clientes v1 = new Vista_clientes();
            BD_huevos m = new BD_huevos();
            Controlador_cliente n = new Controlador_cliente(v1, m);

            vs.setVisible(false);
        }
    }

    

}
