package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConsultasUsuario extends Conexion {
    
// Método registrar
    public boolean registrar(Usuario usu) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuario (rol, nombres, apellidos, identificación, contraseña, telefono, email, dirección, edad) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getRol());
            ps.setString(2, usu.getNombres());
            ps.setString(3, usu.getApellidos());
            ps.setString(4, usu.getIdentificación());
            ps.setString(5, usu.getContraseña());
            ps.setString(6, usu.getTelefono());
            ps.setString(7, usu.getEmail());
            ps.setString(8, usu.getDirección());
            ps.setInt(9, usu.getEdad());
            ps.execute();
            return true; 
             
        }catch (SQLException e)
        {
            System.err.println(e);
            return false;
            
        }finally{
           try {
               con.close();
           }catch (SQLException e)
           {
              System.err.println(e);          
           }  
        } 
    }
    
  // Método modificar
    public boolean modificar(Usuario usu) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE usuario SET rol=?, nombres=?, apellidos=?, identificación=?, contraseña=?, telefono=?, email=?, dirección=?, edad=? WHERE id_usuario=? ";

        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getRol());
            ps.setString(2, usu.getNombres());
            ps.setString(3, usu.getApellidos());
            ps.setString(4, usu.getIdentificación());
            ps.setString(5, usu.getContraseña());
            ps.setString(6, usu.getTelefono());
            ps.setString(7, usu.getEmail());
            ps.setString(8, usu.getDirección());
            ps.setInt(9, usu.getEdad());
            ps.setInt(10, usu.getId_usuario());
            ps.execute();
            return true;
            
        }catch (SQLException e)
        {
            System.err.println(e);
            return false;
            
        }finally{
           try {
               con.close();
           }catch (SQLException e)
           {
              System.err.println(e);          
           }  
        } 
    }  
    
 // Método Eliminar
    public boolean eliminar(Usuario usu) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM usuario WHERE id_usuario=? ";

        try{
            
            ps = con.prepareStatement(sql);            
            ps.setInt(1, usu.getId_usuario());
            ps.execute();
            return true;
            
        }catch (SQLException e)
        {
            System.err.println(e);
            return false;
            
        }finally{
           try {
               con.close();
           }catch (SQLException e)
           {
              System.err.println(e);          
           }  
        } 
    }     
   
   // Método Buscar
    public boolean buscar(Usuario usu) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM usuario WHERE identificación=? ";

        try{
            
            ps = con.prepareStatement(sql);            
            ps.setString(1, usu.getIdentificación());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                usu.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                usu.setRol(rs.getString("rol"));
                usu.setNombres(rs.getString("nombres"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setIdentificación(rs.getString("identificación"));               
                usu.setContraseña(rs.getString("contraseña"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setEmail(rs.getString("email"));
                usu.setDirección(rs.getString("dirección"));
                usu.setEdad(Integer.parseInt(rs.getString("edad")));
                return true;
            }
            
            return false;
            
        }catch (SQLException e)
        {
            System.err.println(e);
            return false;
            
        }finally{
           try {
               con.close();
           }catch (SQLException e)
           {
              System.err.println(e);          
           }  
        } 
    }    
    
}
