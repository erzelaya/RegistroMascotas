/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProMascotas;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Logica {
         File archivo;
        
         
         
    
     public boolean registrarMascotas(String fecha, String lugar, String especie, String raza, String genero, String observaciones) 
    {
        String sql = "INSERT INTO registro.animal (fecha,lugar,especie,raza, genero, observaciones) VALUES (?,?,?,?,?,?)";
        
        Connection cn;
        PreparedStatement pst;
   
        try
        {   
            
             
             
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(sql);
            
            
            
            pst.setString(1, fecha);
            
            pst.setString(2, lugar);
            
            pst.setString(3, especie);
            
            pst.setString(4, raza);
            
            pst.setString(5, genero);
            
            pst.setString(6, observaciones);
            
         
            
            int i = pst.executeUpdate();
            
            if (i != 0)
            {
                JOptionPane.showMessageDialog(null,"Los datos se han guardado satisfactoriamente");
                
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                
                return false;
            }
            
        }
        catch(SQLException e)
        {            
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
            return false;
        }
    }
    

     
    
    
        
        
        
        
    
    
    
    
    
    public DefaultTableModel mostrarMascotas()
    {
        String []  nombresColumnas = {"id","fecha","lugar","especie","raza","genero", "observaciones"};
        String [] registros = new String[7];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM registro.animal";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id");
                
                registros[1] = rs.getString("fecha");
                
                registros[2] = rs.getString("lugar");
                
                registros[3] = rs.getString("especie");
                
                registros[4] = rs.getString("raza");
                
                registros[5] = rs.getString("genero");
                
                registros[6] = rs.getString("observaciones");
                
                
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
    
   public DefaultTableModel buscarMascotas(String buscar)
    {
        String []  nombresColumnas = {"id","fecha","lugar","especie","raza","genero", "observaciones"};
        String [] registros = new String[7];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM registro.animal WHERE raza LIKE '%"+buscar+"%'" ;
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id");
                
                registros[1] = rs.getString("fecha");
                
                registros[2] = rs.getString("lugar");
                
                registros[3] = rs.getString("especie");
                
                registros[4] = rs.getString("raza");
                
                registros[5] = rs.getString("genero");
                
                registros[6] = rs.getString("observaciones");
                
                
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
       
    
    
    
}
