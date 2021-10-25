/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import Entitys.NguoiDung;
import dao.NguoiDungDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class NguoiDungDaoIMP implements NguoiDungDao{
    @Override
    public NguoiDung getNguoiDung(){
        NguoiDung nd = new NguoiDung();
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn= db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("Select TaiKhoan,MatKhau from NguoiDung where MaND=1");
            rs = pstm.executeQuery();
            if(rs.next()){
                nd.setTaiKhoan(rs.getString("TaiKhoan"));
                nd.setMatKhau(rs.getString("MatKhau"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDaoIMP.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return nd;
    }
    
    @Override
    public boolean DoiMatKhau(String matKhau){
        boolean bl = false;
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn= db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("Update NguoiDung set MatKhau=? where MaND=1");
            pstm.setString(1, matKhau);
            int i = pstm.executeUpdate();
            if(i>0){
                bl=true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDaoIMP.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
     
        return bl;
    }
}
