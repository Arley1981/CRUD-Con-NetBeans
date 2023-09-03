
package Controlador;

import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.frmUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class CtrlUsuario implements ActionListener{
    
    private Usuario mod;
    private ConsultasUsuario modC;
    private frmUsuario frm;
    
    public CtrlUsuario(Usuario mod, ConsultasUsuario modC, frmUsuario frm)
    {
         this.mod = mod;
         this.modC = modC;
         this.frm = frm;
         this.frm.btnGuardar.addActionListener(this);
         this.frm.btnModificar.addActionListener(this);
         this.frm.btnEliminar.addActionListener(this);
         this.frm.btnLimpiar.addActionListener(this);
         this.frm.btnBuscar.addActionListener(this);
    }
    // Método para iniciar la vista
    public void iniciar()
    {
        frm.setTitle("Usuarios");
        frm.setLocationRelativeTo(null);
        frm.txtid_usuario.setVisible(false);
    }
    
    // Métodos para escuchar los clics a los botones
    @Override
    public void actionPerformed(ActionEvent e)
    {
       
      // Hacemos un if para detectar que botón se presionó (Guardar)
        if (e.getSource()== frm.btnGuardar)
        {
            
            //Ahora se toman valores de las caj tex para insert al modelo, luego llamar método guardar par insert en la DB
            mod.setRol(frm.cbxrol.getSelectedItem().toString());
            mod.setNombres(frm.txtnombres.getText());
            mod.setApellidos(frm.txtapellidos.getText()); 
            mod.setIdentificación(frm.txtidentificación.getText());
            mod.setContraseña(frm.txtcontraseña.getText());
            mod.setTelefono(frm.txttelefono.getText());
            mod.setEmail(frm.txtemail.getText());
            mod.setDirección(frm.txtdirección.getText());
            mod.setEdad(Integer.parseInt(frm.txtedad.getText()));
            
            // llamar el método registrar
            if(modC.registrar(mod))
            {
                JOptionPane.showMessageDialog(null,"Registro guardado"); 
                //Invocar el método limpiar
                limpiar();
            }else {
                JOptionPane.showMessageDialog(null,"Error al guardar");
                // Invocar el método limpiar
                limpiar();
            }        
        
    }
    
        
        // Hacemos un if para detectar que botón se presionó (Modificar)
        if (e.getSource()== frm.btnModificar)
        {
            
            //Ahora se toman valores de las caj tex para modif al modelo, luego llamar método modif par insert en la DB
            mod.setId_usuario(Integer.parseInt(frm.txtid_usuario.getText()));
            mod.setRol(frm.cbxrol.getSelectedItem().toString());
            mod.setNombres(frm.txtnombres.getText());
            mod.setApellidos(frm.txtapellidos.getText()); 
            mod.setIdentificación(frm.txtidentificación.getText());
            mod.setContraseña(frm.txtcontraseña.getText());
            mod.setTelefono(frm.txttelefono.getText());
            mod.setEmail(frm.txtemail.getText());
            mod.setDirección(frm.txtdirección.getText());
            mod.setEdad(Integer.parseInt(frm.txtedad.getText()));
            
            // llamar el método modificar
            if(modC.modificar(mod))
            {
                JOptionPane.showMessageDialog(null,"Registro modificado"); 
                //Invocar el método limpiar
                limpiar();
            }else {
                JOptionPane.showMessageDialog(null,"Error al modificar");
                // Invocar el método limpiar
                limpiar();
            }        
        
    }
        
     // Hacemos un if para detectar que botón se presionó (Eliminar)
        if (e.getSource()== frm.btnEliminar)
        {
            
            //Ahora se toman valores de las caj tex para elim al modelo, luego llamar método eliminar en la DB
            mod.setId_usuario(Integer.parseInt(frm.txtid_usuario.getText()));
            
            
            // llamar el método eliminar
            if(modC.eliminar(mod))
            {
                JOptionPane.showMessageDialog(null,"Registro eliminado"); 
                //Invocar el método limpiar
                limpiar();
            }else {
                JOptionPane.showMessageDialog(null,"Error al eliminar");
                // Invocar el método limpiar
                limpiar();
            }        
        
    }
        
     // Hacemos un if para detectar que botón se presionó (Buscar)
        if (e.getSource()== frm.btnBuscar)
        {
            
            //Ahora se toman valores de las caj tex para buscar en la DB
            mod.setIdentificación(frm.txtidentificación.getText());
            
            
            // llamar el método buscar
            if(modC.buscar(mod))
            {
                frm.txtid_usuario.setText(String.valueOf(mod.getId_usuario()));
                frm.cbxrol.setSelectedItem(mod.getRol());
                frm.txtnombres.setText(mod.getNombres());
                frm.txtapellidos.setText(mod.getApellidos());
                frm.txtidentificación.setText(mod.getIdentificación());
                frm.txtcontraseña.setText(mod.getContraseña());
                frm.txttelefono.setText(mod.getTelefono());
                frm.txtemail.setText(mod.getEmail());
                frm.txtdirección.setText(mod.getDirección());
                frm.txtedad.setText(String.valueOf(mod.getEdad()));
                
                
          
            }else {
                JOptionPane.showMessageDialog(null,"No se encontró registro");
                // Invocar el método limpiar
                limpiar();
            }        
        
    }   
       
        if (e.getSource()== frm.btnLimpiar)
        {
            limpiar();
        }
        
    }
    
    // Creamos método para limpiar el formulario
        public void limpiar()
      {
          frm.txtid_usuario.setText(null);
          frm.cbxrol.setSelectedIndex(0);
          frm.txtnombres.setText(null);
          frm.txtapellidos.setText(null);
          frm.txtidentificación.setText(null);
          frm.txtcontraseña.setText(null);
          frm.txttelefono.setText(null);
          frm.txtemail.setText(null);
          frm.txtdirección.setText(null);
          frm.txtedad.setText(null);
      }
}
