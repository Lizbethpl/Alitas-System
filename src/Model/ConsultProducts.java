/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author toshiba
 */
public class ConsultProducts extends Conexion {

    /*PreparedStatement ps = null;
    ResultSet rs= null;
    Connection con = getConnection();*/
   
    public List Listar (){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        List <Products> datos = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Products pro = new Products();
                pro.setIdProduct(rs.getInt(1));
                pro.setNameProduct(rs.getString(2));
                pro.setCategoryProduct(rs.getString(3));
                pro.setFlavorProduct(rs.getString(4));
                pro.setPriceProduct(rs.getDouble(5));
                datos.add(pro);
            }
            
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return datos;
    }
    public int register(Products p){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO products (name_product,category_product,flavor_product,price_product) "
                + "VALUES (?,?,?,?)";
        
        try { 
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, p.getNameProduct());
            ps.setString(2, p.getCategoryProduct());
            ps.setString(3, p.getFlavorProduct());
            ps.setDouble(4, p.getPriceProduct());
            ps.executeUpdate();
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }    
        return 1;
    }
    public int modify(Products p){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        int r=0;
        String sql = "UPDATE products SET name_product=?, category_product=?,flavor_product=?,price_product=? WHERE Id_product=?";
        
        try { 
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, p.getNameProduct());
            ps.setString(2, p.getCategoryProduct());
            ps.setString(3, p.getFlavorProduct());
            ps.setDouble(4, p.getPriceProduct());
            ps.setInt(5, p.getIdProduct());
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
        
        String sql = "DELETE FROM products WHERE Id_product="+id;
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
