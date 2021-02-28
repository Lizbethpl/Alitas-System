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
public class ConsultSaleViews extends Conexion {
    PreparedStatement ps = null;
    ResultSet rs= null;
    Connection con = getConnection();
    
    public List Listar (int id){
        
        List <Sale> datos = new ArrayList<>();
        String sql = "select sales_id_sale, name_sproduct, lot_sproduct, description_sproduct, total_sproduct from sales_product where sales_id_sale ="+id;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Sale s = new Sale();
                s.setSales_id_sale(rs.getInt(1));
                s.setName_sproduct(rs.getString(2));
                s.setLot_sproduct(rs.getInt(3));
                s.setDescription_sproduct(rs.getString(4));
                s.setTotal_sproduct(rs.getDouble(5));
                datos.add(s);
            }
            
        } catch (Exception e) {
        }
        return datos;
    }
    
}
