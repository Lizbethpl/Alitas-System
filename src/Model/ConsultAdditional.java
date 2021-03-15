/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ConsultAdditional extends Conexion{
    
    
    public List Listar (){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
    
        List <Additional> datos = new ArrayList<>();
        String sql = "SELECT * FROM additional";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Additional add = new Additional();
                
                add.setId_additional(rs.getInt(1));
                add.setName_additional(rs.getString(2));
                add.setPrice_additional(rs.getDouble(3));
                datos.add(add);
            }
            
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return datos;
    }
    public int register(Additional add){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO additional (name_additional,price_additional) "
                + "VALUES (?,?)";
        
        try { 
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, add.getName_additional());
            ps.setDouble(2, add.getPrice_additional());
            ps.executeUpdate();
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }    
        return 1;
    }
    public int modify(Additional p){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        int r=0;
        String sql = "UPDATE additional SET name_additional=?,price_additional=? WHERE id_Additional=?";
        
        try { 
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, p.getName_additional());
            ps.setDouble(2, p.getPrice_additional());
            ps.setInt(3, p.getId_additional());
            r=ps.executeUpdate();
            if (r==1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }    
        return r;
    }
    public void delete(int id) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM additional WHERE id_Additional="+id;
        try {
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
    }
}
