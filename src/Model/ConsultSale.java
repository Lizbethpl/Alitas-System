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
import javax.swing.JOptionPane;

/**
 *
 * @author toshiba
 */
public class ConsultSale extends Conexion{
    PreparedStatement ps = null;
    ResultSet rs= null;
    Connection con = getConnection();
    public List Listar (int id){
        
        List <Sale> datos = new ArrayList<>();
        String sql = "SELECT name_sproduct, total_sproduct,id_sproduct FROM sales_product where sales_id_sale="+id;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Sale sale = new Sale();
                sale.setName_sproduct(rs.getString(1));
                sale.setTotal_sproduct(rs.getDouble(2));
                sale.setId(rs.getInt(3));
                datos.add(sale);
            }
            
        } catch (Exception e) {
        }
        return datos;
    }
    public int register(Sale p){
        String sql = "INSERT INTO sales_product (name_sproduct, lot_sproduct,description_sproduct,total_sproduct,sales_id_sale) "
                + "VALUES (?,?,?,?,?)";
        
        try { 
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, p.getName_sproduct());
            ps.setInt(2, p.getLot_sproduct());
            ps.setString(3, p.getDescription_sproduct());
            ps.setDouble(4, p.getTotal_sproduct());
            ps.setInt(5, p.getSales_id_sale());
            ps.executeUpdate();
        } catch (Exception e) {
        }    
        return 1;
    }
    
    public double priceAlitas() {
        double price_alitas  =0;
        try {
            
            ResultSet res;
            
            String sql=("SELECT price_product AS price_alitas FROM products WHERE name_product = 'ALITAS'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_alitas = rs.getInt("price_alitas");

              con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return price_alitas;
     }
    public double priceBoneless() {
        double price_boneless  =0;
        try {
            
            ResultSet res;
            
            String sql=("SELECT price_product AS price_boneless FROM products WHERE name_product = 'BONELESS'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_boneless = rs.getInt("price_boneless");

              con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return price_boneless;
     }
    public double priceBurger(String burger) {
        double price_burger  =0;
        try {
            
            ResultSet res;
            
            String sql=("select price_product from products where name_product ='"+burger+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_burger = rs.getInt("price_product");

              con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return price_burger;
     }
    public double pricePotatoes(String potatoes) {
        double price_potatoes  =0;
        try {
            
            ResultSet res;
            
            String sql=("select price_product from products where name_product ='"+potatoes+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_potatoes = rs.getInt("price_product");

              con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return price_potatoes;
     }
    public double priceDrink(String drink) {
        double price_drink  =0;
        try {
            
            ResultSet res;
            
            String sql=("select price_product from products where name_product ='"+drink+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_drink = rs.getInt("price_product");

              con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return price_drink;
     }
    public double priceDesserts(String desserts) {
        double price_Desserts  =0;
        try {
            
            ResultSet res;
            
            String sql=("select price_product from products where name_product ='"+desserts+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_Desserts = rs.getInt("price_product");

              con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return price_Desserts;
     }
    public double priceAdditional(String Additional) {
        double price_Additional  =0;
        try {
            
            ResultSet res;
            
            String sql=("select price_additional from additional where name_additional ='"+Additional+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_Additional = rs.getInt("price_product");

              con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return price_Additional;
     }
    public double totalPrice(int id) {
        double totalPrice  =0;
        try {
            
            ResultSet res;
            
            String sql=("select sum(total_sproduct) as total from sales_product where sales_id_sale ="+id);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            totalPrice = rs.getInt("total");

            //con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return totalPrice;
     }
    public void delete(int id) {
        String sql = "delete from sales_product where sales_id_sale ="+id;
        try {
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void deleteProduct(int id) {
        String sql = "DELETE FROM sales_product WHERE id_sproduct="+id;
        try {
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        ConsultSale c = new ConsultSale();
        System.out.println(+c.totalPrice(908));
    }
}
