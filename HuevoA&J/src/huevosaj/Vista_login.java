/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevosaj;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 *  @author Spacecode A&J
 */
public class Vista_login extends javax.swing.JFrame {
    //variables vista login
    JPanel JPgallina,JPformulario;
    JLabel JLinicio,JLusuario,JLcontraseña;
    JLabel JLigallina,JLcerrar,JLminimizar,JLisusu,JLicontra;
    JTextField JTusuario;  JPasswordField JPcoontraseña;
    JButton JBingresar,JBcerrar,JBminimizar,JBregistrate,JBrecuperarcontra;
    JSeparator JSusu,JScontra;
    ImageIcon Igallina,Iusuario,Icontraseña,Ifondo,Icerrar,Iminimizar;
    Font fuentetitulo = new Font("Microsoft JhengHei Light", Font.BOLD, 50);
    Font fuentenormal = new Font("Microsoft JhengHei Light", Font.BOLD, 30);
      Font fuentebotones = new Font("Microsoft JhengHei Light", Font.CENTER_BASELINE, 20);
    Color Azul =new Color (110, 197, 184);
    Color Naranja =new Color (220, 91, 5);
    
    Vista_login() 
        {
        setTitle("INICIO DE SESIÓN ");
        setSize(1250, 720);
        setLayout(null);
        //diseño paneles
        JPgallina = new JPanel();
        JPgallina.setBackground(new Color(110, 197, 184));
        JPgallina.setBorder(new LineBorder(Azul));
        
        JPformulario = new JPanel();
       
        JPformulario.setBackground(new Color(255, 255, 255)); 
        JPformulario.setBorder(new LineBorder(Naranja));
        //diseño imagenes
        Igallina = new ImageIcon("Logo1.png");
        JLigallina = new JLabel(Igallina);
        ImageIcon a = new ImageIcon(Igallina.getImage().getScaledInstance(312, 428, java.awt.Image.SCALE_DEFAULT));
        JLigallina.setIcon(a);
        
        //diseño labels
        JLinicio = new JLabel("INICIO DE SESIÓN");
        JLinicio.setForeground(Naranja);
        JLinicio.setFont(fuentetitulo);
        JLusuario = new JLabel("Usuario");
        JLusuario.setForeground(Naranja);
        JLusuario.setFont(fuentenormal);
        JSusu = new JSeparator(JSeparator.HORIZONTAL);
        JSusu.setForeground(Azul);
        JLcontraseña = new JLabel("Contraseña");
        JLcontraseña.setForeground(Naranja);
        JLcontraseña.setFont(fuentenormal);
        JScontra = new JSeparator(JSeparator.HORIZONTAL);
        JScontra.setForeground(Azul);
        
               //---------------------Texfiel login
        JTusuario = new JTextField();
        JTusuario.setToolTipText(" Digite su usuario");
        JTusuario.setBackground(new Color(255, 255, 255));
        JTusuario.setOpaque(false);
        JTusuario.setBorder(new LineBorder(Color.WHITE));
        JTusuario.setFont(fuentenormal);
        
        //imagenes
                Iusuario = new ImageIcon("usu.png");
        JLisusu = new JLabel(Iusuario);
        ImageIcon b= new ImageIcon(Iusuario.getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_DEFAULT));
        JLisusu.setIcon(b);
        
       Icontraseña = new ImageIcon("contra.png");
        JLicontra = new JLabel(Icontraseña);
        ImageIcon c= new ImageIcon(Icontraseña.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT));
        JLicontra.setIcon(c);
        
        
        JPcoontraseña = new JPasswordField();
        JPcoontraseña.setToolTipText("Digite su contraseña");
        JPcoontraseña.setBackground(new Color(255, 255, 255));
        JPcoontraseña.setOpaque(false);
        JPcoontraseña.setBorder(new LineBorder(Color.WHITE));
        JPcoontraseña.setFont(fuentenormal);

         //botones
        JBingresar = new JButton("INGRESAR");
        JBingresar.setForeground(new Color(0, 0, 0));
        JBingresar.setFont(fuentebotones);
        JBingresar.setBorder(new LineBorder(Color.WHITE));
        JBingresar.setBackground(Azul);
        
        JBregistrate = new JButton("Registrate");
        JBregistrate.setForeground(Azul);
        JBregistrate.setFont(fuentebotones);
        JBregistrate.setBorder(new LineBorder(Azul));
        JBregistrate.setBackground(new Color(255, 255, 255));
        JBregistrate.setOpaque(false);
        JBregistrate.setContentAreaFilled(false);
        JBregistrate.setBorderPainted(false);
        
        JBrecuperarcontra = new JButton("¿Olvido su contraseña?");
        JBrecuperarcontra.setForeground(Azul);
        JBrecuperarcontra.setFont(fuentebotones);
        JBrecuperarcontra.setBorder(new LineBorder(Azul));
        JBrecuperarcontra.setBackground(new Color(255, 255, 255));
        JBrecuperarcontra.setOpaque(false);
        JBrecuperarcontra.setContentAreaFilled(false);
        JBrecuperarcontra.setBorderPainted(false);
        
        JBminimizar = new JButton(Iminimizar);
        JBminimizar.setContentAreaFilled(false);
        JBminimizar.setBorderPainted(false);
        JBminimizar.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Iminimizar = new ImageIcon("minimizara.png");
        ImageIcon d = new ImageIcon(Iminimizar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        JBminimizar.setIcon(d);
        
        
        JBcerrar = new JButton(Icerrar);
        JBcerrar.setContentAreaFilled(false);
        JBcerrar.setBorderPainted(false);
        JBcerrar.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Icerrar = new ImageIcon("cerrara.png");
        ImageIcon e = new ImageIcon(Icerrar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        JBcerrar.setIcon(e);
        
        //coordenadas
        //paneles
        JPgallina.setBounds(0, 0, 500, 720);
        JPformulario.setBounds(500, 0, 748, 718);
        //imagenes labels
        JLigallina.setBounds(80, 80, 312, 428);
        //labels
        JLinicio.setBounds(150, 80, 800, 80);
        JLusuario.setBounds(180, 250, 120, 30);
        JLisusu.setBounds(120, 300, 64, 64);
        JSusu.setBounds(180, 360, 400, 30);
        JLcontraseña.setBounds(180, 400, 180, 30);
         JLicontra.setBounds(130, 460, 50, 50);
        JScontra.setBounds(180, 510, 400, 30);
        // jtexfield
        JTusuario.setBounds(180, 320, 400, 40);
        JPcoontraseña.setBounds(180, 470, 400, 40);
          
          //BOTONES
        JBingresar.setBounds(280, 550, 200, 40);
        JBregistrate.setBounds(300, 640, 150, 40);
        JBrecuperarcontra.setBounds(250, 600, 250, 40);
        JBminimizar.setBounds(640, 10, 35, 35);
        JBcerrar.setBounds(690, 10, 35, 35);
          
        //null paneles
        JPgallina.setLayout(null);
        JPformulario.setLayout(null);
        
        //agrego
        //panel gallina
        JPgallina.add(JLigallina);
        //panelformulario
        JPformulario.add(JLinicio);
        JPformulario.add(JLusuario);
        JPformulario.add(JLcontraseña);
        JPformulario.add(JSusu);
        JPformulario.add(JScontra);
        JPformulario.add(JTusuario);
        JPformulario.add(JPcoontraseña);
        JPformulario.add(JBingresar);
        JPformulario.add(JLisusu);
         JPformulario.add(JLisusu);
         JPformulario.add(JLicontra);
         JPformulario.add(JBminimizar);
         JPformulario.add(JBcerrar);
         JPformulario.add(JBregistrate);
         JPformulario.add(JBrecuperarcontra);
         
         
         
         
        
        this.add(JPgallina);
        this.add(JPformulario);
        
        
        
       this.setUndecorated(true);
       setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        setDefaultCloseOperation(3);
        }
    }
