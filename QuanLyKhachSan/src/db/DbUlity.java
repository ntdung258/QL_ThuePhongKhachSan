/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DbUlity {
    public static Connection openConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QL_KhachSan","sa","123");
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbUlity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbUlity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void closeAll(Connection conn, PreparedStatement pstm, ResultSet rs){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbUlity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(pstm!=null){
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbUlity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbUlity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(openConnection());
    }
}
