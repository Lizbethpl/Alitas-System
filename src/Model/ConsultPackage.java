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
 * @author toshiba
 */
public class ConsultPackage extends Conexion{
    /*PreparedStatement ps = null;
    ResultSet rs= null;
    Connection con = getConnection();*/
    
    public List Listar (){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        List <Package> datos = new ArrayList<>();
        String sql = "SELECT * FROM packages";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Package pack = new Package();
                
                pack.setName_package(rs.getString(1));
                pack.setDescription_package(rs.getString(2));
                pack.setPrice_package(rs.getDouble(3));
                pack.setId_package(rs.getInt(4));
                datos.add(pack);
            }
            
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return datos;
    }
    public int register(Package p){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO packages (name_package,description_package,price_package) "
                + "VALUES (?,?,?)";
        
        try { 
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, p.getName_package());
            ps.setString(2, p.getDescription_package());
            ps.setDouble(3, p.getPrice_package());
            ps.executeUpdate();
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }    
        return 1;
    }
    public int modify(Package p){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        int r=0;
        String sql = "UPDATE packages SET name_package=?, description_package=?,price_package=? WHERE Id_package=?";
        
        try { 
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, p.getName_package());
            ps.setString(2, p.getDescription_package());
            ps.setDouble(3, p.getPrice_package());
            ps.setInt(4, p.getId_package());
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
        
        String sql = "DELETE FROM packages WHERE Id_package="+id;
        try {
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
    }
}
