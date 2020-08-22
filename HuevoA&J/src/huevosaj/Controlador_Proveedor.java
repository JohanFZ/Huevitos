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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author JohanF
 */
public class Controlador_Proveedor implements ActionListener, MouseListener, KeyListener {

    Vista_Proveedor vis1;
    BD_huevos mom;

    Controlador_Proveedor(Vista_Proveedor v1, BD_huevos m) {
        mom = m;
        vis1 = v1;

        vis1.ActualizarP.addActionListener(this);
        vis1.ActualizarB.addActionListener(this);
        vis1.BCrear.addActionListener(this);
        vis1.CrearP.addActionListener(this);
        vis1.BEliminar.addActionListener(this);
        vis1.tabla.addMouseListener(this);
        vis1.Mostrar.addActionListener(this);
        vis1.CerrarB.addActionListener(this);
        vis1.MinimizarB.addActionListener(this);
        vis1.volver.addActionListener(this);
        vis1.Nombres.setModel(mom.Combo_nombreProveedor());
        vis1.Telefonos.setModel(mom.Combo_telefonoProveedor());
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vis1.ActualizarP) {
            contacto1 = huevosaj.BD_huevos.getConexion();
            int i = mom.Act_Pro(Integer.parseInt(vis1.TId_proveeedor.getText()), vis1.TPNombre.getText(), vis1.TSNombre.getText(),
                    vis1.TPApellido.getText(), vis1.TSApellido.getText(), vis1.TDireccion.getText(), vis1.TTelefono.getText(), vis1.TCorreo.getText());
            
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Proveedor Actualizado");
                DefaultTableModel model = new DefaultTableModel();
                model = mom.Lista_prov();
                vis1.tabla.setModel(model);
                TableColumnModel columnModel = vis1.tabla.getColumnModel();

                columnModel.getColumn(0).setPreferredWidth(20);
                columnModel.getColumn(1).setPreferredWidth(50);
                columnModel.getColumn(2).setPreferredWidth(50);
                columnModel.getColumn(3).setPreferredWidth(50);
                columnModel.getColumn(4).setPreferredWidth(50);
                columnModel.getColumn(5).setPreferredWidth(70);
                columnModel.getColumn(6).setPreferredWidth(60);
                columnModel.getColumn(7).setPreferredWidth(150);
                mom.desconectar();
            } else {
                JOptionPane.showMessageDialog(null, "Proveedor No Actulizado");
            }

        }
        if (e.getSource() == vis1.ActualizarB) {

            int k = vis1.tabla.getSelectedRow();
            int c = vis1.tabla.getSelectedRowCount();
            if (k >= 0 && c == 1) {
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
                vis1.CrearP.setVisible(false);
                vis1.ActualizarP.setVisible(true);
                vis1.Logo.setVisible(false);
                vis1.TId_proveeedor.setText(String.valueOf(vis1.tabla.getValueAt(k, 0)));
                vis1.TId_proveeedor.setEditable(false);
                contacto1 = huevosaj.BD_huevos.getConexion();
                int combo = 0;
                int i = Integer.parseInt(vis1.TId_proveeedor.getText());
                String encontro[] = mom.ModifiPro(Integer.parseInt(vis1.TId_proveeedor.getText()), combo);//trae los datos leidos de la base de datos y los guarad en un arreglo de tipo string
                vis1.TPNombre.setText(encontro[0]);
                vis1.TSNombre.setText(encontro[1]);
                vis1.TPApellido.setText(encontro[2]);//pone lo que hay en la posicion 0 del arreglo en el textfield
                vis1.TSApellido.setText(encontro[3]);
                vis1.TDireccion.setText(encontro[4]);
                vis1.TTelefono.setText(encontro[5]);
                vis1.TCorreo.setText(encontro[6]);

                DefaultTableModel model = new DefaultTableModel();
                model = mom.Lista_prov();
                vis1.tabla.setModel(model);
                TableColumnModel columnModel = vis1.tabla.getColumnModel();

                columnModel.getColumn(0).setPreferredWidth(20);
                columnModel.getColumn(1).setPreferredWidth(50);
                columnModel.getColumn(2).setPreferredWidth(50);
                columnModel.getColumn(3).setPreferredWidth(50);
                columnModel.getColumn(4).setPreferredWidth(50);
                columnModel.getColumn(5).setPreferredWidth(70);
                columnModel.getColumn(6).setPreferredWidth(60);
                columnModel.getColumn(7).setPreferredWidth(150);
                mom.desconectar();
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Error", 0);
            }
        }
        if (e.getSource() == vis1.BEliminar) {
            int k = vis1.tabla.getSelectedRow();
            int c = vis1.tabla.getSelectedRowCount();
            if (k >= 0 && c == 1) {
                vis1.TId_proveeedor.setText(String.valueOf(vis1.tabla.getValueAt(k, 0)));
                vis1.TId_proveeedor.setEditable(false);
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este Proveedor?", "Alerta!", JOptionPane.YES_NO_OPTION);
                contacto1 = huevosaj.BD_huevos.getConexion();
                if (resp == 0) {
                    this.mom.Borrarproveedor(Integer.parseInt(this.vis1.TId_proveeedor.getText()));
                    JOptionPane.showMessageDialog(null, "Proveedor Eliminado");
                    DefaultTableModel model = new DefaultTableModel();
                    model = mom.Lista_prov();
                    vis1.tabla.setModel(model);
                    TableColumnModel columnModel = vis1.tabla.getColumnModel();

                    columnModel.getColumn(0).setPreferredWidth(20);
                    columnModel.getColumn(1).setPreferredWidth(50);
                    columnModel.getColumn(2).setPreferredWidth(50);
                    columnModel.getColumn(3).setPreferredWidth(50);
                    columnModel.getColumn(4).setPreferredWidth(50);
                    columnModel.getColumn(5).setPreferredWidth(70);
                    columnModel.getColumn(6).setPreferredWidth(60);
                    columnModel.getColumn(7).setPreferredWidth(150);
                    mom.desconectar();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe aceptar la eliminación");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Error", 0);
            }
        }
        if (e.getSource() == vis1.BCrear) {
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
            vis1.ActualizarP.setVisible(false);
            vis1.Logo.setVisible(false);
        }
        if (e.getSource() == vis1.CrearP) {
            contacto1 = huevosaj.BD_huevos.getConexion();
            int co = this.mom.Val_Pro_Correo(this.vis1.TCorreo.getText());
            if (vis1.TPNombre.getText().isEmpty() || vis1.TSNombre.getText().isEmpty() || vis1.TPApellido.getText().isEmpty() || vis1.TSApellido.getText().isEmpty() || vis1.TCorreo.getText().isEmpty() || vis1.TTelefono.getText().isEmpty() || vis1.TDireccion.getText().isEmpty()) { // si estos coampos no estan llenos
                JOptionPane.showMessageDialog(null, "campos vacios");
            } else {
                if (co == 1) {
                    JOptionPane.showMessageDialog(null, "Este Proveedor ya esta Registrado");
                } else {
                    if (!vis1.TCorreo.getText().contains("@") || !vis1.TCorreo.getText().contains(".")) {
                        JOptionPane.showMessageDialog(null, "Correo Invalido");
                    } else {
                        int v = this.mom.Agre_Pro(vis1.TPNombre.getText(), vis1.TSNombre.getText(), vis1.TPApellido.getText(), vis1.TSApellido.getText(), vis1.TCorreo.getText(), vis1.TTelefono.getText(), vis1.TDireccion.getText());
                        limpiarPro();
                        if (v == 0) {
                            JOptionPane.showMessageDialog(null, "No Guardado", "Informacion", 0);
                        } else {
                            JOptionPane.showMessageDialog(null, "Proveedor Registrado", "informacion", 1);
                            contacto1 = huevosaj.BD_huevos.getConexion();
                            DefaultTableModel model = new DefaultTableModel();
                            model = mom.Lista_prov();
                            vis1.tabla.setModel(model);
                            TableColumnModel columnModel = vis1.tabla.getColumnModel();

                            columnModel.getColumn(0).setPreferredWidth(20);
                            columnModel.getColumn(1).setPreferredWidth(50);
                            columnModel.getColumn(2).setPreferredWidth(50);
                            columnModel.getColumn(3).setPreferredWidth(50);
                            columnModel.getColumn(4).setPreferredWidth(50);
                            columnModel.getColumn(5).setPreferredWidth(70);
                            columnModel.getColumn(6).setPreferredWidth(60);
                            columnModel.getColumn(7).setPreferredWidth(150);
                            mom.desconectar();
                        }
                    }

                }

            }
            mom.desconectar();

        }
        if (e.getSource() == vis1.Mostrar) {
            contacto1 = huevosaj.BD_huevos.getConexion();
            DefaultTableModel model = new DefaultTableModel();
            model = mom.Lista_prov();
            vis1.tabla.setModel(model);
            TableColumnModel columnModel = vis1.tabla.getColumnModel();

            columnModel.getColumn(0).setPreferredWidth(20);
            columnModel.getColumn(1).setPreferredWidth(50);
            columnModel.getColumn(2).setPreferredWidth(50);
            columnModel.getColumn(3).setPreferredWidth(50);
            columnModel.getColumn(4).setPreferredWidth(50);
            columnModel.getColumn(5).setPreferredWidth(70);
            columnModel.getColumn(6).setPreferredWidth(60);
            columnModel.getColumn(7).setPreferredWidth(150);
            mom.desconectar();
        }
        if (e.getSource() == vis1.CerrarB) {
            System.exit(0);
        }
        if (e.getSource() == vis1.MinimizarB) {
            vis1.setExtendedState(ICONIFIED);
        }
        if (e.getSource() == vis1.volver) {
            Vista_menu v = new Vista_menu();
            BD_huevos h = new BD_huevos();
            Controlador_menu M = new Controlador_menu(v, h);
            vis1.setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
