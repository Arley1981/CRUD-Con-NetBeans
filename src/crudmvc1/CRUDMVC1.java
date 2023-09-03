/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudmvc1;

import Controlador.CtrlUsuario;
import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.frmUsuario;

/**
 *
 * @author carlo
 */
public class CRUDMVC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
      Usuario mod = new Usuario();
      ConsultasUsuario modC = new ConsultasUsuario();
      frmUsuario frm = new frmUsuario();
      
      CtrlUsuario ctrl= new CtrlUsuario(mod, modC, frm);
      ctrl.iniciar();
      frm.setVisible(true);
      
        
    }
    
}
