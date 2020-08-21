/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevosaj;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Vista_Registro extends JFrame implements ActionListener{
    
    JPanel PanelGallina, PanelTexto;
    JLabel Logo, Titulo, PrimerN, SegundoN, PrimerA, SegundoA, Correo, User, Pass, fondo;
    JTextField PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,Email,Usuario;
    JPasswordField Contra;
    JButton Registro, Inicio, CerrarB, MinimizarB;
    ImageIcon imagen, imagen1,Cerrar,Minimizar;
    Font fuente1 = new Font("Microsoft JhengHei Light", Font.PLAIN, 50);
    Font fuente2 = new Font("Microsoft JhengHei Light", Font.PLAIN, 18);
    Font fuente3 = new Font("Microsoft JhengHei Light", Font.PLAIN, 15);
    Color color1 = new Color(110, 197, 184);
    Color color2 = new Color(220, 91, 5);
    Border thickBorder = new LineBorder(Color.white, 2);
    
    Vista_Registro(){
        setTitle("Registro");
        setSize(1250, 720);
        setLayout(null);
        
        JPanel PanelGallina = new JPanel();
        PanelGallina.setBounds(800, 0, 450, 720);
        PanelGallina.setLayout(null);
        PanelGallina.setBackground(color1);
        
        imagen = new ImageIcon("Logo1.png");
        JLabel Logo = new JLabel(imagen);
        Logo.setBounds(20, 20, 410,680);
        
        imagen1 = new ImageIcon("hue.jpg");
        JPanel PanelTexto = new JPanel();
        PanelTexto.setLayout(null);
        PanelTexto.setBounds(0, 0, 800, 720);
        PanelTexto.setBackground(Color.white);
        
        JLabel Fondo = new JLabel(imagen1);
        Fondo.setLayout(null);
        Fondo.setBounds(0, 0, 800, 720);
        
        Titulo = new JLabel("REGISTRATE");
        Titulo.setBounds(260, 80, 280, 50);
        Titulo.setFont(fuente1);
        Titulo.setForeground(color2);
        
        PrimerN = new JLabel("Primer Nombre :");
        PrimerN.setBounds(80, 170, 150, 50);
        PrimerN.setFont(fuente2);
        PrimerN.setForeground(color2);
        
        PrimerNombre = new JTextField();
        PrimerNombre.setBounds(235, 178, 120, 27);
        PrimerNombre.setFont(fuente2);
        PrimerNombre.setForeground(color2);
        PrimerNombre.setBorder(thickBorder);
        
        PrimerA = new JLabel("Primer Apellido :");
        PrimerA.setBounds(80, 240, 150, 50);
        PrimerA.setFont(fuente2);
        PrimerA.setForeground(color2);
        
        PrimerApellido = new JTextField();
        PrimerApellido.setBounds(235, 248, 120, 27);
        PrimerApellido.setFont(fuente2);
        PrimerApellido.setForeground(color2);
        PrimerApellido.setBorder(thickBorder);
        
        SegundoN = new JLabel("Segundo Nombre :");
        SegundoN.setBounds(430, 170, 170, 50);
        SegundoN.setFont(fuente2);
        SegundoN.setForeground(color2);
        
        SegundoNombre = new JTextField();
        SegundoNombre.setBounds(595, 178, 120, 27);
        SegundoNombre.setFont(fuente2);
        SegundoNombre.setForeground(color2);
        SegundoNombre.setBorder(thickBorder);
        
        SegundoA = new JLabel("Segundo Apellido :");
        SegundoA.setBounds(430, 240, 170, 50);
        SegundoA.setFont(fuente2);
        SegundoA.setForeground(color2);
        
        SegundoApellido = new JTextField();
        SegundoApellido.setBounds(595, 248, 120, 27);
        SegundoApellido.setFont(fuente2);
        SegundoApellido.setForeground(color2);
        SegundoApellido.setBorder(thickBorder);
        
        Correo = new JLabel("Correo Electrónico :");
        Correo.setBounds(175, 310, 170, 50);
        Correo.setFont(fuente2);
        Correo.setForeground(color2);
        
        Email = new JTextField();
        Email.setBounds(350, 318, 220, 27);
        Email.setFont(fuente2);
        Email.setForeground(color2);
        Email.setBorder(thickBorder);
        
        User = new JLabel("Usuario :");
        User.setBounds(140, 380, 170, 50);
        User.setFont(fuente2);
        User.setForeground(color2);
        
        Usuario = new JTextField("");
        Usuario.setBounds(235, 388, 120, 27);
        Usuario.setFont(fuente2);
        Usuario.setForeground(color2);
        Usuario.setBorder(thickBorder);
        
        Pass = new JLabel("Contraseña :");
        Pass.setBounds(430, 380, 170, 50);
        Pass.setFont(fuente2);
        Pass.setForeground(color2);
        
        Contra = new JPasswordField();
        Contra.setBounds(545, 388, 120, 27);
        Contra.setFont(fuente2);
        Contra.setForeground(color2);
        Contra.setBorder(thickBorder);
        
        Registro = new JButton("Registrarme");
        Registro.setBounds(200, 480, 170, 50);
        Registro.setBackground(color1);
        Registro.setForeground(color2);
        Registro.setFont(fuente2);
        
        Inicio = new JButton("Iniciar Sesión");
        Inicio.setBounds(430, 480, 170, 50);
        Inicio.setBackground(color1);
        Inicio.setForeground(color2);
        Inicio.setFont(fuente2);
        
        MinimizarB = new JButton(Minimizar);
        MinimizarB.setContentAreaFilled(false);
        MinimizarB.setBorderPainted(false);
        MinimizarB.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Minimizar = new ImageIcon("minimizarn.png");
        ImageIcon d = new ImageIcon(Minimizar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        MinimizarB.setIcon(d);
        
        
        CerrarB = new JButton(Cerrar);
        CerrarB.setContentAreaFilled(false);
        CerrarB.setBorderPainted(false);
        CerrarB.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Cerrar = new ImageIcon("cerrarn.png");
        ImageIcon e = new ImageIcon(Cerrar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        CerrarB.setIcon(e);
        
        CerrarB.setBounds(390, 10, 35, 35);
        MinimizarB.setBounds(350, 10, 35, 35);

        PanelGallina.add(CerrarB);
        PanelGallina.add(MinimizarB);
        PanelTexto.add(Registro);
        PanelTexto.add(Inicio);
        PanelTexto.add(User);
        PanelTexto.add(Usuario);
        PanelTexto.add(Pass);
        PanelTexto.add(Contra);
        PanelTexto.add(Correo);
        PanelTexto.add(Email);
        PanelTexto.add(SegundoApellido);
        PanelTexto.add(SegundoA);
        PanelTexto.add(PrimerApellido);
        PanelTexto.add(PrimerA);
        PanelTexto.add(SegundoNombre);
        PanelTexto.add(SegundoN);
        PanelTexto.add(PrimerNombre);
        PanelTexto.add(PrimerN);
        PanelTexto.add(Titulo);
        PanelTexto.add(Fondo);
        this.add(PanelTexto);
        PanelGallina.add(Logo);
        this.add(PanelGallina);
        
        
        
        this.setUndecorated(true);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
    }
        
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color1);
        g.drawRect(235, 208, 120, 0);
        g.drawRect(235, 278, 120, 0);
        g.drawRect(595, 208, 120, 0);
        g.drawRect(595, 278, 120, 0);
        g.drawRect(350, 348, 220, 0);
        g.drawRect(235, 422, 120, 0);
        g.drawRect(545, 422, 120, 0);
        g.drawRect(545, 422, 120, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
   
}


