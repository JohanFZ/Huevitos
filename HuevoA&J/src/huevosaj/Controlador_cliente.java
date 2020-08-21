/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevosaj;

import static huevosaj.Controlador_Registro.contacto1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author michi
 */
public class Controlador_cliente implements ActionListener, MouseListener,KeyListener {

    Vista_clientes vis1;
    BD_huevos mom;

    Controlador_cliente(Vista_clientes v1, BD_huevos m) {
        mom = m;
        vis1 = v1;

        vis1.BCrear.addActionListener(this);
       this.vis1.tablac.addMouseListener(this);
       vis1.ActualizarB.addActionListener(this);
       vis1.BEliminar.addActionListener(this);
       vis1.ListaB.addActionListener(this);
     
    }

    public void llenartablaclientes(JTable tablac) {
        DefaultTableModel model = new DefaultTableModel();
        tablac.setModel(model);
          model.addColumn("Id cliente");
        model.addColumn("Primer Nombre");
        model.addColumn("Segundo Nombre");
        model.addColumn("Primer Apelido");
        model.addColumn("Segundo  Apellido");
        model.addColumn("Direccion");
        model.addColumn("Telefono ");
        model.addColumn("Correo ");
        Object[] columna = new Object[8];

        int numeroregis = mom.listarcliente().size();
 
        for (int i = 0; i < numeroregis; i++) {

            columna[0] = mom.listarcliente().get(i).getId_cliente();
            columna[1] = mom.listarcliente().get(i).getPrimernombre();
            columna[2] = mom.listarcliente().get(i).getSegundonombre();
            columna[3] = mom.listarcliente().get(i).getPrimerapellido();
            columna[4] = mom.listarcliente().get(i).getSegundoapellido();
            columna[5] = mom.listarcliente().get(i).getDireccion();
            columna[6] = mom.listarcliente().get(i).getTelefono();
            columna[7] = mom.listarcliente().get(i).getCorreo();
            model.addRow(columna);

        }
    }

    public void limpiarPro() {
        vis1.TPNombre.setText("");
        vis1.TSNombre.setText("");
        vis1.TPApellido.setText("");
        vis1.TSApellido.setText("");
        vis1.TCorreo.setText("");
        vis1.TTelefono.setText("");
        vis1.TDireccion.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            contacto1 = huevosaj.BD_huevos.getConexion();
         
           System.out.println("llenar");
        if (ae.getSource() == vis1.BCrear) {
            vis1.PNombre.setVisible(true);
            vis1.SNombre.setVisible(true);
            vis1.PApellido.setVisible(true);
            vis1.SApellido.setVisible(true);
            vis1.Correo.setVisible(true);
            vis1.Telefono.setVisible(true);
            vis1.Direccion.setVisible(true);
            vis1.TPNombre.setVisible(true);
            vis1.TSNombre.setVisible(true);
            vis1.TPApellido.setVisible(true);
            vis1.TSApellido.setVisible(true);
            vis1.TCorreo.setVisible(true);
            vis1.TTelefono.setVisible(true);
            vis1.TDireccion.setVisible(true);
            vis1.JS1.setVisible(true);
            vis1.JS2.setVisible(true);
            vis1.JS3.setVisible(true);
            vis1.JS4.setVisible(true);
            vis1.JS5.setVisible(true);
            vis1.JS6.setVisible(true);
            vis1.JS7.setVisible(true);
            vis1.CrearP.setVisible(true);
            vis1.Logo.setVisible(false);
           

        }
        if (ae.getSource() == vis1.ActualizarB) {
            contacto1 = huevosaj.BD_huevos.getConexion();
            llenartablaclientes(vis1.tablac);
           System.out.println("llenar");
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
