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
public class ConsultSaleView extends Conexion {
    /*PreparedStatement ps = null;
    ResultSet rs= null;
    Connection con = getConnection();*/
    public List Listar (){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();

        List <sale_products> datos = new ArrayList<>();
        String sql = "select date_sale , id_sales_product, client_sale, total_sale from sales;";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                sale_products sp = new sale_products();
                sp.setDate_sale(rs.getString(1));
                sp.setId_sale_product(rs.getInt(2));
                sp.setClient_sale(rs.getString(3));
                sp.setTotal_sale(rs.getDouble(4));
                datos.add(sp);
            }
            
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return datos;
    }
    public List ListarProductos (int id){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();

        
        List <Sale> datos = new ArrayList<>();
        String sql = "select name_sproduct from sales_product where sales_id_sale ="+id;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Sale s = new Sale();
                s.setName_sproduct(rs.getString(1));
                datos.add(s);
            }
            
        } catch (Exception e) {
        }finally{
            try{ps.close();}catch (Exception e){} 
            try{con.close();}catch (Exception e){} 
            System.out.println("Conexion cerrada");
        }
        return datos;
    }
    public void delete(int id) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        
        String sql = "delete sales,sales_product\n" +
                    "from sales\n" +
                    "join sales_product\n" +
                    "on sales.id_sales_product=sales_product.sales_id_sale\n" +
                    "where sales_product.sales_id_sale="+id;
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
