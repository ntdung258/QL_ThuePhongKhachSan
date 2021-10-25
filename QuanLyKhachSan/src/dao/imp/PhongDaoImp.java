/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import Entitys.Phong;
import dao.PhongDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PhongDaoImp implements PhongDao{

    @Override
    public List<Phong> getAllPhong() {
        List<Phong> listp = new ArrayList<>();
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("Select *from Phong");
            rs = pstm.executeQuery();
            while(rs.next()){
                Phong p = new Phong();
                p.setMaP(rs.getString("MaP"));
                p.setTenP(rs.getString("TenP"));
                p.setGia(rs.getFloat("Gia"));
                p.setTrangThai(rs.getBoolean("TrangThai"));
                listp.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn,pstm,rs);
        }
        
        return listp;
    }

    @Override
    public Phong getMaPhong(String maP) {
        Phong p = null;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("Select *from Phong where MaP=?");
            pstm.setString(1,maP);
            rs = pstm.executeQuery();
            if(rs.next()){
                p = new Phong();
                p.setMaP(rs.getString("MaP"));
                p.setTenP(rs.getString("TenP"));
                p.setGia(rs.getFloat("Gia"));
                p.setTrangThai(rs.getBoolean("TrangThai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn,pstm,rs);
        }
        
        return p;
    }

    @Override
    public boolean insertPhong(Phong p) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Them_Phong(?,?,?,?)}");
            pstm.setString(1, p.getMaP());
            pstm.setString(2, p.getTenP());
            pstm.setFloat(3, p.getGia());
            pstm.setBoolean(4, p.isTrangThai());            
             int i = pstm.executeUpdate();
             if(i>0){
                 bl=true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public boolean updatePhong(Phong p) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Sua_Phong(?,?,?,?)}");
            pstm.setString(1, p.getMaP());
            pstm.setNString(2, p.getTenP());
            pstm.setFloat(3, p.getGia());
            pstm.setBoolean(4, p.isTrangThai());
            
            
             int i = pstm.executeUpdate();
             if(i>0){
                 bl=true;
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(PhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }


    

    @Override
    public boolean deletePhong(Phong p) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Xoa_Phong(?)}");
            pstm.setString(1,p.getMaP() );
            
             int i = pstm.executeUpdate();
             if(i>0){
                 bl=true;
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(PhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public boolean checkMaPhong(String maP) {
        boolean bl = false;
        Phong p  = new Phong();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select *from Phong where MaP=?");
            pstm.setString(1,maP);
            rs = pstm.executeQuery();
            bl=rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(PhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }


}
