/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import Entitys.NhanVien;
import dao.NhanVienDao;
import java.sql.Connection;
import java.sql.Date;
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
public class NhanVienDaoImp implements NhanVienDao {

    @Override
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> listnv = new ArrayList<>();
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("Select *from NhanVien");
            rs = pstm.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setSDT(rs.getString("SDT"));
                listnv.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        
        return listnv;
    }

    @Override
    public NhanVien getMaNV(String maNV) {
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        NhanVien nv = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("Select *from NhanVien where MaNV=?");
            pstm.setString(1, maNV);
            rs = pstm.executeQuery();
            if(rs.next()){
                nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setSDT(rs.getString("SDT"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return nv;     
    }

    @Override
    public boolean insertNhanVien(NhanVien nv) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Them_NhanVien(?,?,?,?,?)}");
            pstm.setString(1, nv.getMaNV());
            pstm.setString(2, nv.getTenNV());
            pstm.setBoolean(3, nv.isGioiTinh());
            pstm.setDate(4, new Date(nv.getNgaySinh().getTime()));
            pstm.setString(5, nv.getSDT());
             int i = pstm.executeUpdate();
             if(i>0){
                 bl=true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
            
        
        return bl;
    }

    @Override
    public boolean updateNhanVien(NhanVien nv) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Sua_NhanVien(?,?,?,?,?)}");
            pstm.setString(1, nv.getMaNV());
            pstm.setString(2, nv.getTenNV());
            pstm.setBoolean(3, nv.isGioiTinh());
            pstm.setDate(4, new Date(nv.getNgaySinh().getTime()));
            pstm.setString(5, nv.getSDT());
             int i = pstm.executeUpdate();
             if(i>0){
                 bl=true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
            
        
        return bl;
    }

    @Override
    public boolean deleteNhanVien(NhanVien nv) {
         boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Xoa_NhanVien(?)}");
            pstm.setString(1,nv.getMaNV() );
            
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
    public List<NhanVien> getNhanVienByName(String tenNV) {
        List<NhanVien> listnv = new ArrayList<>();
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("{CALL pr_TimKiemTheoTen_NhanVien(?)}");
            pstm.setString(1, tenNV);
            rs = pstm.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("maNV"));
                nv.setTenNV(rs.getString("tenNV"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setSDT(rs.getString("SDT"));
                listnv.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        
        return listnv;
    }

    @Override
    public boolean checkMaNV(String maNV) {
         boolean bl = false;
        NhanVien nv  = new NhanVien();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select *from NhanVien where MaNV=?");
            pstm.setString(1,maNV);
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
