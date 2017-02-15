/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCONNECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class db_connect1 {
    public static Connection connect(){
        
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/st_2","root","");//this will conect with st_2 database
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        
        return con;
    }
}
