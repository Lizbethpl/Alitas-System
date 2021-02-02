/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Conexion {
    private final String base = "db_alitas";
    private final String user = "root";
    private final String password = "password";
    private final String url = "jdbc:mysql://localhost/db_Alitas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    private Connection con = null;
    
    
    public Connection getConnection(){
    
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");  
           con = (Connection)DriverManager.getConnection(url, user, password);
           System.out.println("Conexion exitosa");
       }catch(SQLException e){
           System.out.println(e);
           System.out.println("Conexion fallida");
       }catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;   
    }
    
    public static void main(String[] args) {
        Conexion cone = new Conexion();
        cone.getConnection();
    }
  
}
