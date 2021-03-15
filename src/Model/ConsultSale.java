
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author toshiba
 */
public class ConsultSale extends Conexion{
    /*PreparedStatement ps = null;
    ResultSet rs= null;
    Connection con = getConnection();*/
    
    public void InsertTick(int numOrd, String clientName){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
    
        String sql = "INSERT INTO ticketsave (sales_id_sale,client_sale) VALUES (?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,numOrd); 
            ps.setString(2, clientName);
            ps.execute();
        }catch(SQLException e){ // si no se ejecuta manda exepciones
            System.err.print( e);           
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        } 
    }
    
    public void DeleteTick(int numOrd){ // Consulta a la tabla ConsultTikc
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM ticketsave WHERE sales_id_sale ="+numOrd;
        try{
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException e){ // si no se ejecuta manda exepciones
            System.err.print( e);           
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        } 
    }
    
    public List ListUser (){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
    //public List ListUser (int id){
         // clase necesarioa para hacer lista
        List <sale_products> datos = new ArrayList<>(); // Lista tipo sale
        //String sql = "SELECT * FROM ticketsave WHERE sales_id_sale ="+id;
        String sql = "SELECT * FROM ticketsave";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {  
                sale_products salep = new sale_products();
                salep.setId_sale_product(rs.getInt(1));
                salep.setClient_sale(rs.getString(2)); 
                datos.add(salep);
            }
        }catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return datos;
    }
    public List Listar (int id){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
 
        List <Sale> datos = new ArrayList<>();
        String sql = "SELECT name_sproduct, total_sproduct,id_sproduct,lot_sproduct, description_sproduct FROM sales_product where sales_id_sale="+id;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Sale sale = new Sale();
                sale.setName_sproduct(rs.getString(1));
                sale.setTotal_sproduct(rs.getDouble(2));
                sale.setId(rs.getInt(3));
                sale.setLot_sproduct(rs.getInt(4));
                sale.setDescription_sproduct(rs.getString(5));
                datos.add(sale);
            }
            
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return datos;
    }
    public List ListarCambio(int id){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
 
        List <Shift> datos = new ArrayList<>();
        String sql = "select shift_s from shift where id_sales_shift="+id;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Shift shift = new Shift();
                shift.setShift_s(rs.getDouble(1));
                
                datos.add(shift);
            }
            
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return datos;
    }
    public int register(Sale p){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO sales_product (name_sproduct, lot_sproduct,description_sproduct,total_sproduct,sales_id_sale) "
                + "VALUES (?,?,?,?,?)";
        
        try { 
            //con=getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, p.getName_sproduct());
            ps.setInt(2, p.getLot_sproduct());
            ps.setString(3, p.getDescription_sproduct());
            ps.setDouble(4, p.getTotal_sproduct());
            ps.setInt(5, p.getSales_id_sale());
            ps.executeUpdate();
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }    
        return 1;
    }
    
    public double priceAlitas() {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        double price_alitas  =0;
        try {       
            String sql=("SELECT price_product AS price_alitas FROM products WHERE name_product = 'ALITAS'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_alitas = rs.getInt("price_alitas");

        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        } 
        return price_alitas;
     }
    public double priceBoneless() {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        double price_alitas  =0;
        
        double price_boneless  =0;
        try {
            String sql=("SELECT price_product AS price_boneless FROM products WHERE name_product = 'BONELESS'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_boneless = rs.getInt("price_boneless");

   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return price_boneless;
     }
    public double priceBurger(String burger) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        double price_burger  =0;
        try {                        
            String sql=("select price_product from products where name_product ='"+burger+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_burger = rs.getInt("price_product");

          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return price_burger;
     }
    public double pricePotatoes(String potatoes) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        double price_potatoes  =0;
        try {
            
            String sql=("select price_product from products where name_product ='"+potatoes+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_potatoes = rs.getInt("price_product");

          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return price_potatoes;
     }
    public double priceDrink(String drink) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        double price_drink  =0;
        try {
            String sql=("select price_product from products where name_product ='"+drink+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_drink = rs.getInt("price_product");

        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return price_drink;
     }
    public double priceDesserts(String desserts) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        double price_Desserts  =0;
        try {
           
            String sql=("select price_product from products where name_product ='"+desserts+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_Desserts = rs.getInt("price_product");

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return price_Desserts;
     }
    public double priceAdditional(String Additional) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        double price_Additional  =0;
        try {
         
            String sql=("select price_additional from additional where name_additional ='"+Additional+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_Additional = rs.getInt("price_product");

           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return price_Additional;
     }
    public double pricePackages(String Packages) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        double price_Packages  =0;
        try {
          
            String sql=("select price_package from packages where name_package ='"+Packages+"'");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            price_Packages = rs.getInt("price_package");

             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return price_Packages;
     }
    public double totalPrice(int id) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        double totalPrice  =0;
        try {
           
            String sql=("select sum(total_sproduct) as total from sales_product where sales_id_sale ="+id);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();   
            rs.next();
            totalPrice = rs.getInt("total");

            //con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return totalPrice;
     }
    public void delete(int id) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "delete from sales_product where sales_id_sale ="+id;
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
    public void deleteProduct(int id) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM sales_product WHERE id_sproduct="+id;
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
    
    public int registerSale(sale_products sp){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO sales (date_sale, total_sale,client_sale,id_sales_product) "
                + "VALUES (?,?,?,?)";
        
        try { 
            con=getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, sp.getDate_sale());
            ps.setDouble(2, sp.getTotal_sale());
            ps.setString(3, sp.getClient_sale());
            ps.setInt(4, sp.getId_sale_product());
            ps.executeUpdate();
            System.out.println(sql);
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }   
        return 1;
        
    }
    public List ListarVentaDetalle (int id){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        List <sale_products> datos = new ArrayList<>();
        String sql = "select client_sale, total_sale from sales where id_sales_product="+id;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                sale_products salep = new sale_products();
                salep.setClient_sale(rs.getString(1));
                salep.setTotal_sale(rs.getDouble(2));
                
                datos.add(salep);
                System.out.println(datos);
            }
            
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return datos;
        
    }
    public List ListarVentaProducto (int id){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        List <Sale> datos = new ArrayList<>();
        String sql = "SELECT name_sproduct, lot_sproduct, total_sproduct FROM sales_product where sales_id_sale="+id;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Sale sale = new Sale();
                sale.setName_sproduct(rs.getString(1));
                sale.setLot_sproduct(rs.getInt(2));
                sale.setTotal_sproduct(rs.getDouble(3));
                datos.add(sale);
            }
            
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return datos;
        
    }
    public List ListarOrden (){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        List <Sale> datos = new ArrayList<>();
        String sql = "SELECT sales_id_sale FROM sales_product ORDER by sales_id_sale DESC LIMIT 1";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Sale sale = new Sale();
                sale.setSales_id_sale(rs.getInt(1));
                
                datos.add(sale);
                System.out.println(datos);
            }
            
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }  
        return datos;
        
    }
    public void deleteSale(int id) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "Call deletesale("+id+")";
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
    public int registerShift(Shift s){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO shift (shift_s, id_sales_shift) "
                + "VALUES (?,?)";
        
        try { 
            con=getConnection();
            ps= con.prepareStatement(sql);           
            ps.setDouble(1, s.getShift_s());         
            ps.setInt(2, s.getId_sales_shift());
            ps.executeUpdate();
            System.out.println(sql);
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }   
        return 1;
        
    }
    
}
