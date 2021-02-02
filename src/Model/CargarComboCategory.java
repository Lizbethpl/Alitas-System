/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author toshiba
 */
public class CargarComboCategory extends Conexion{
    public double price_burger =0;
    public void consultarCategory(JComboBox cbxCategory) throws SQLException{
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "SELECT name_category FROM category";
        
        try {
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            cbxCategory.addItem("SELECCIONA CATEGORIA");
            while (result.next()) {                
                cbxCategory.addItem(result.getString("name_category"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
             if (conn!= null) {
                 conn.close();
            }
        }
    }
    public void consultFlavor(JComboBox cbxFlavor) throws SQLException{
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "SELECT name_flavor FROM flavor";
        
        try {
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            cbxFlavor.addItem("SABOR");
            while (result.next()) {                
                cbxFlavor.addItem(result.getString("name_flavor"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
             if (conn!= null) {
                 conn.close();
            }
        }
    }
    public void consultBurger(JComboBox cbxBurger) throws SQLException{
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "SELECT name_product,price_product FROM products WHERE category_product='HAMBURGUESAS'";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            cbxBurger.addItem("SABOR");
            while (result.next()) {                
                cbxBurger.addItem(result.getString("name_product"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
             if (conn!= null) {
                 conn.close();
            }
        }
    }
    public void consultPotatoes(JComboBox cbxPotatoes) throws SQLException{
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "SELECT name_product,price_product FROM products WHERE category_product='PAPAS'";
        
        try {
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            cbxPotatoes.addItem("SABOR");
            while (result.next()) {                
                cbxPotatoes.addItem(result.getString("name_product"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
             if (conn!= null) {
                 conn.close();
            }
        }
    }
    public void consultDrinks(JComboBox cbxDrinks) throws SQLException{
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "SELECT name_product,price_product FROM products WHERE category_product='BEBIDAS'";
        
        try {
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            cbxDrinks.addItem("BEBIDA");
            while (result.next()) {                
                cbxDrinks.addItem(result.getString("name_product"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
             if (conn!= null) {
                 conn.close();
            }
        }
    }
    public void consultDesserts(JComboBox cbxDesserts) throws SQLException{
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "SELECT name_product,price_product FROM products WHERE category_product='POSTRES'";
        
        try {
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            cbxDesserts.addItem("POSTRES");
            while (result.next()) {                
                cbxDesserts.addItem(result.getString("name_product"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
             if (conn!= null) {
                 conn.close();
            }
        }
    }
     public void consultAdditional(JComboBox cbxDesserts) throws SQLException{
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "SELECT name_additional FROM additional";
        
        try {
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            cbxDesserts.addItem("EXTRAS");
            while (result.next()) {                
                cbxDesserts.addItem(result.getString("name_additional"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
             if (conn!= null) {
                 conn.close();
            }
        }
    }
}
