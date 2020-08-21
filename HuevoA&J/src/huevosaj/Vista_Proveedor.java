/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevosaj;

import static huevosaj.Controlador_menu.contacto1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Space Code A&J
 */
public class Vista_Proveedor extends JFrame {
    
    JPanel Panel1, Panel2;
    JLabel Titulo,PNombre,SNombre,PApellido,SApellido,Direccion,Telefono,Correo,Logo;
    JTextField TPNombre,TSNombre,TPApellido,TSApellido,TDireccion,TTelefono,TCorreo,TId_proveeedor;
    Font fuente1 = new Font("Microsoft JhengHei Light", Font.PLAIN, 50);
    Font fuente2 = new Font("Microsoft JhengHei Light", Font.PLAIN, 18);
    Font fuente3 = new Font("Microsoft JhengHei Light", Font.PLAIN, 15);
    Color color1 = new Color(110, 197, 184);
    Color color2 = new Color(220, 91, 5);
    Border thickBorder = new LineBorder(Color.white, 2);
    JButton CerrarB, MinimizarB,BCrear,BEliminar, CrearP, volver, ActualizarB, ListaB, Mostrar;
    ImageIcon Cerrar,Minimizar,ICrear,IEliminar,VolverI,ActualizarI,ListaI, imagen,MostrarI;
    JSeparator JS1,JS2,JS3,JS4,JS5,JS6,JS7,JS8;
    JTable tabla;
    JScrollPane panel;
    String Titulos[]={"Nombre","Apellido","Edad"};
            
    Vista_Proveedor(){
        setTitle("Menu");
        setSize(1250, 720);
        setLayout(null);
        
        JPanel Panel1 = new JPanel();
        Panel1.setLayout(null);
        Panel1.setBackground(Color.WHITE);
        Panel1.setBounds(800, 0, 550, 720);
        
        JPanel Panel2 = new JPanel();
        Panel2.setLayout(null);
        Panel2.setBackground(color1);
        Panel2.setBounds(0, 0, 800, 720);
        
        JLabel Titulo = new JLabel("PROVEEDORES");
        Titulo.setFont(fuente1);
        Titulo.setForeground(color2);
        Titulo.setBounds(50, 50, 350, 45);
        
        MinimizarB = new JButton(Minimizar);
        MinimizarB.setContentAreaFilled(false);
        MinimizarB.setBorderPainted(false);
        MinimizarB.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Minimizar = new ImageIcon("minimizarn.png");
        ImageIcon d = new ImageIcon(Minimizar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        MinimizarB.setIcon(d);
        
                
        Mostrar = new JButton("MOSTRAR TODO");
        Mostrar.setToolTipText("ESTA OPCIÓN LISTA LOS PROVEEDORES");
        Mostrar.setForeground(color2);
        Mostrar.setBackground(Color.white);
        Mostrar.setFont(fuente2);
        
        Mostrar.setBounds(300, 650, 180, 45);
        Panel2.add(Mostrar);
        
        
        CerrarB = new JButton(Cerrar);
        CerrarB.setContentAreaFilled(false);
        CerrarB.setBorderPainted(false);
        CerrarB.setToolTipText("ESTA OPCION CIERRA EL PROGRAMA");
        Cerrar = new ImageIcon("cerrarn.png");
        ImageIcon e = new ImageIcon(Cerrar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        CerrarB.setIcon(e);
        
        CerrarB.setBounds(400, 10, 35, 35);
        MinimizarB.setBounds(365, 10, 35, 35);
        
        BCrear = new JButton(Cerrar);
        BCrear.setContentAreaFilled(false);
        BCrear.setBorderPainted(false);
        ICrear = new ImageIcon("user.png");
        BCrear.setToolTipText("ESTA OPCIÓN PERMITE CREAR UN PROVEEDOR");
        ImageIcon p = new ImageIcon(ICrear.getImage().getScaledInstance(80,80, java.awt.Image.SCALE_DEFAULT));
        BCrear.setIcon(p);
        
        BCrear.setBounds(110, 30, 80, 80);
        
        BEliminar = new JButton(Cerrar);
        BEliminar.setContentAreaFilled(false);
        BEliminar.setBorderPainted(false);
        IEliminar = new ImageIcon("eliminar.png");
        BEliminar.setToolTipText("ESTA OPCIÓN PERMITE ELIMINAR UN PROVEEDOR");
        ImageIcon pf = new ImageIcon(IEliminar.getImage().getScaledInstance(80,80, java.awt.Image.SCALE_DEFAULT));
        BEliminar.setIcon(pf);
        
        BEliminar.setBounds(270, 25, 80, 80);
        
        ActualizarB = new JButton(Cerrar);
        ActualizarB.setContentAreaFilled(false);
        ActualizarB.setBorderPainted(false);
        ActualizarI = new ImageIcon("actualizar.png");
        ActualizarB.setToolTipText("ESTA OPCIÓN PERMITE ACTUALIZAR UN PROVEEDOR");
        ImageIcon pfe = new ImageIcon(ActualizarI.getImage().getScaledInstance(80,80, java.awt.Image.SCALE_DEFAULT));
        ActualizarB.setIcon(pfe);
        
        ActualizarB.setBounds(430, 25, 80, 80);
        
        ListaB = new JButton(Cerrar);
        ListaB.setContentAreaFilled(false);
        ListaB.setBorderPainted(false);
        ListaI = new ImageIcon("lista.png");
        ListaB.setToolTipText("ESTA OPCIÓN PERMITE LISTAR TODOS LOS PROVEEDORES");
        ImageIcon pfee = new ImageIcon(ListaI.getImage().getScaledInstance(80,80, java.awt.Image.SCALE_DEFAULT));
        ListaB.setIcon(pfee);
        
        ListaB.setBounds(590, 25, 80, 80);
        
        PNombre = new JLabel("Primer Nombre :");
        PNombre.setBounds(50, 140, 170, 50);
        PNombre.setFont(fuente2);
        PNombre.setForeground(color2);
        
        SNombre = new JLabel("Segundo Nombre :");
        SNombre.setBounds(50, 200, 170, 50);
        SNombre.setFont(fuente2);
        SNombre.setForeground(color2);
        
        PApellido = new JLabel("Primer Apellido :");
        PApellido.setBounds(50, 260, 170, 50);
        PApellido.setFont(fuente2);
        PApellido.setForeground(color2);
        
        SApellido = new JLabel("Segundo Apellido :");
        SApellido.setBounds(50, 320, 170, 50);
        SApellido.setFont(fuente2);
        SApellido.setForeground(color2);
        
        Direccion = new JLabel("Dirección :");
        Direccion.setBounds(50, 380, 170, 50);
        Direccion.setFont(fuente2);
        Direccion.setForeground(color2);
        
        Telefono = new JLabel("Nº Celular :");
        Telefono.setBounds(50, 440, 170, 50);
        Telefono.setFont(fuente2);
        Telefono.setForeground(color2);
        
        Correo = new JLabel("Correo :");
        Correo.setBounds(50, 500, 170, 50);
        Correo.setFont(fuente2);
        Correo.setForeground(color2);
        
        TPNombre = new JTextField("");
        TPNombre.setBounds(200, 148, 190, 27);
        TPNombre.setFont(fuente2);
        TPNombre.setForeground(color2);
        TPNombre.setBorder(thickBorder);
        
        TSNombre = new JTextField("");
        TSNombre.setBounds(220, 208, 190, 27);
        TSNombre.setFont(fuente2);
        TSNombre.setForeground(color2);
        TSNombre.setBorder(thickBorder);
        
        TPApellido = new JTextField("");
        TPApellido.setBounds(200, 268, 190, 27);
        TPApellido.setFont(fuente2);
        TPApellido.setForeground(color2);
        TPApellido.setBorder(thickBorder);
        
        TSApellido = new JTextField("");
        TSApellido.setBounds(220, 328, 190, 27);
        TSApellido.setFont(fuente2);
        TSApellido.setForeground(color2);
        TSApellido.setBorder(thickBorder);
        
        TDireccion = new JTextField("");
        TDireccion.setBounds(150, 388, 190, 27);
        TDireccion.setFont(fuente2);
        TDireccion.setForeground(color2);
        TDireccion.setBorder(thickBorder);
        
        TTelefono = new JTextField("");
        TTelefono.setBounds(160, 448, 190, 27);
        TTelefono.setFont(fuente2);
        TTelefono.setForeground(color2);
        TTelefono.setBorder(thickBorder);
        
        TCorreo = new JTextField("");
        TCorreo.setBounds(130, 508, 240, 27);
        TCorreo.setFont(fuente2);
        TCorreo.setForeground(color2);
        TCorreo.setBorder(thickBorder);
        
        TId_proveeedor = new JTextField("");
        TId_proveeedor.setBounds(130, 600, 240, 27);
        TId_proveeedor.setFont(fuente2);
        TId_proveeedor.setForeground(color2);
        TId_proveeedor.setBorder(thickBorder);
        
        Panel2.add(TId_proveeedor);
        TId_proveeedor.setVisible(false);
        
        CrearP = new JButton("Crear Proveedor");
        CrearP.setBounds(140, 590, 170, 50);
        CrearP.setBackground(color1);
        CrearP.setForeground(color2);
        CrearP.setFont(fuente2);
        
        volver = new JButton(Minimizar);
        volver.setContentAreaFilled(false);
        volver.setBorderPainted(false);
        volver.setToolTipText("ESTA OPCION NOS REGRESA AL MENÚ");
        VolverI = new ImageIcon("volver.png");
        ImageIcon de = new ImageIcon(VolverI.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        volver.setIcon(de);
        
        volver.setBounds(400, 670, 35, 35);
        
        JS1 = new JSeparator(JSeparator.HORIZONTAL);
        JS1.setForeground(color2);
        JS1.setBounds(200, 175, 190, 30);
        Panel1.add(JS1);
        
        JS2 = new JSeparator(JSeparator.HORIZONTAL);
        JS2.setForeground(color2);
        JS2.setBounds(220, 235, 170, 30);
        Panel1.add(JS2);
        
        JS3 = new JSeparator(JSeparator.HORIZONTAL);
        JS3.setForeground(color2);
        JS3.setBounds(200, 295, 190, 30);
        Panel1.add(JS3);
        
        JS4 = new JSeparator(JSeparator.HORIZONTAL);
        JS4.setForeground(color2);
        JS4.setBounds(220, 355, 170, 30);
        Panel1.add(JS4);
        
        JS5 = new JSeparator(JSeparator.HORIZONTAL);
        JS5.setForeground(color2);
        JS5.setBounds(150, 415, 240, 30);
        Panel1.add(JS5);
        
        JS6 = new JSeparator(JSeparator.HORIZONTAL);
        JS6.setForeground(color2);
        JS6.setBounds(160, 475, 230, 30);
        Panel1.add(JS6);
        
        JS7 = new JSeparator(JSeparator.HORIZONTAL);
        JS7.setForeground(color2);
        JS7.setBounds(130, 535, 260, 30);
        Panel1.add(JS7);
        
        PNombre.setVisible(false);
        SNombre.setVisible(false);
        PApellido.setVisible(false);
        SApellido.setVisible(false);
        Correo.setVisible(false);
        Telefono.setVisible(false);
        Direccion.setVisible(false);
        TPNombre.setVisible(false);
        TSNombre.setVisible(false);
        TPApellido.setVisible(false);
        TSApellido.setVisible(false);
        TCorreo.setVisible(false);
        TTelefono.setVisible(false);
        TDireccion.setVisible(false);
        JS1.setVisible(false);
        JS2.setVisible(false);
        JS3.setVisible(false);
        JS4.setVisible(false);
        JS5.setVisible(false);
        JS6.setVisible(false);
        JS7.setVisible(false);
        CrearP.setVisible(false);
        
        imagen = new ImageIcon("Logo1.png");
        Logo = new JLabel(imagen);
        Logo.setBounds(20, 20, 410,680);
        
        tabla = new JTable();
        tabla = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        panel = new JScrollPane(tabla);// debe ir aqui pare evitar errores
        tabla.getTableHeader().setReorderingAllowed(false);//Orden de las columnas
        tabla.getTableHeader().setResizingAllowed(false);// orden
        tabla.setFocusable(false);//
        tabla.setBackground(new Color(110, 197, 184));
        panel.getViewport().setBackground(color1);
        panel.setBorder(new LineBorder(color1));
        tabla.setBorder(new LineBorder(color1));
        tabla.setForeground(Color.white);
        panel.setBounds(60, 170, 660, 500);
        
        Panel2.add(panel);
        Panel1.add(Logo);
        Panel2.add(ListaB);
        Panel2.add(ActualizarB);
        Panel1.add(volver);
        Panel1.add(CrearP);
        Panel1.add(TCorreo); 
        Panel1.add(TTelefono); 
        Panel1.add(TDireccion);  
        Panel1.add(TSApellido);
        Panel1.add(TPApellido);
        Panel1.add(TSNombre);
        Panel1.add(TPNombre);
        Panel1.add(Correo);
        Panel1.add(Telefono);
        Panel1.add(Direccion);
        Panel1.add(SApellido);
        Panel1.add(PApellido);
        Panel1.add(SNombre);
        Panel1.add(PNombre);     
        Panel1.add(CerrarB);
        Panel1.add(MinimizarB);
        Panel1.add(Titulo);
        Panel2.add(BEliminar);
        Panel2.add(BCrear);
        this.add(Panel2);
        this.add(Panel1);
        
        this.setUndecorated(true);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(3);
    }
}
