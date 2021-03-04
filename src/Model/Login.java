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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Login extends Conexion {
    
    public boolean log (User us){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT name_user,password_user, id_Tipo FROM users WHERE name_user = ?";
      
    try{
        ps = con.prepareStatement(sql); 
        ps.setString(1, us.getName()); //
        rs = ps.executeQuery();
        
        if(rs.next()){
            if(us.getPassword().equals(rs.getString(2))){
                //us.setId(rs.getInt(1));
                us.setName(rs.getString(1));               
                us.setId_Tipo(rs.getInt(3));
                return true;
            }else{
                return false;
            }
        }
        return false;
    }catch(SQLException ex){
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,ex);
        return false;
    }        
    }
}
