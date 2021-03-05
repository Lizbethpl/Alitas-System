package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsultUser extends Conexion {
    Hash hash = new Hash();
    
    public List Listar (){
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConnection();
        List <User> datos = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                User us = new User();
                us.setId(rs.getInt(1));
                us.setName(rs.getString(2));
                us.setLastNameP(rs.getString(3));
                us.setLastNameM(rs.getString(4));
                us.setPhoneNumber(rs.getString(5));
                us.setGender(rs.getString(6));
                us.setDateRegister(rs.getString(7));
                
                us.setPassword(rs.getString(8));
                us.setId_Tipo(rs.getInt(9));
                datos.add(us);
            }
            
        } catch (Exception e) {
        }finally{
        try {
            con.close();
        }catch(SQLException e){
            System.out.println( e);
            }
        } 
        return datos;
    }
    
    public boolean Register(User us) throws SQLException{
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO users (name_user,lastNameP_user,lastNameM_user,phone_user,gender_user,date_user,password_user,id_tipo) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getName());
            ps.setString(2, us.getLastNameP());
            ps.setString(3, us.getLastNameM());
            ps.setString(4, us.getPhoneNumber());
            ps.setString(5, us.getGender());
            ps.setString(6, us.getDateRegister());
            ps.setString(7, us.getPassword());
            ps.setInt(8, us.getId_Tipo());
            /*ps.setString(7, hash.sha1(us.getPassword()));*/
            
            ps.execute();
            return true;          
        }catch(SQLException e){ // si no se ejecuta manda exepciones
            System.err.print( e);
            return false;
        } finally{
        try {
            con.close();
        }catch(SQLException e){
            System.out.println( e);
            }
        } 
        
    }
    
    public boolean UpdateD(User us){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE users SET name_user = ?,lastNameP_user = ?,LastNameM_user = ?,phone_user = ?,gender_user = ?,"
                + "date_user = ?,password_user = ? ,id_tipo = ? WHERE id_user = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getName());
            ps.setString(2, us.getLastNameP());
            ps.setString(3, us.getLastNameM());
            ps.setString(4, us.getPhoneNumber());
            ps.setString(5, us.getGender());
            ps.setString(6, us.getDateRegister());
            ps.setString(7, us.getPassword());
            ps.setInt(8,us.getId_Tipo());
            ps.setInt(9,us.getId());
            
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.print(e);
            return false;
        } finally{
        try {
            con.close();
        }catch(SQLException e){
            System.out.println(e);
            }
        }
    }
    
    public boolean Delete(User us){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM users WHERE id_user = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, us.getId());
            
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.print(e);
            return false;
        } finally{
        try {
            con.close();
        }catch(SQLException e){
            System.out.println(e);
            }
        }
        
        
    }
    
}
