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
public class HuevoAJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          Vista_login v1 = new Vista_login();
        BD_huevos m =new  BD_huevos ();
         Controlador_Login n = new  Controlador_Login (v1,m);
    }
    
}
