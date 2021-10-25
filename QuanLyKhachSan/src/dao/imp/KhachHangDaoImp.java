/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import Entitys.KhachHang;
import dao.KhachHangDao;
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
public class KhachHangDaoImp implements KhachHangDao{

    @Override
    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> listkh = new ArrayList<>();
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs =null;
        
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("Select *from KhachHang");
            rs = pstm.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setGioiTinh(rs.getBoolean("GioiTinh"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSDT(rs.getString("SDT"));
                kh.setCMND(rs.getString("CMND"));
                kh.setTrangThai(rs.getBoolean("TrangThai"));
                listkh.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return listkh;
    }

    @Override
    public KhachHang getKhachHanh(String maKH) {
        KhachHang kh = null;
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs =null;
        
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("Select *from KhachHang where MaKH=?");
            pstm.setString(1, maKH);
            rs = pstm.executeQuery();
            if(rs.next()){
                kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setGioiTinh(rs.getBoolean("GioiTinh"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSDT(rs.getString("SDT"));
                kh.setCMND(rs.getString("CMND"));
                kh.setTrangThai(rs.getBoolean("TrangThai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return kh;
    }

    @Override
    public boolean insertKhachHang(KhachHang kh) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Them_KhachHang(?,?,?,?,?,?,?)}");
            pstm.setString(1, kh.getMaKH());
            pstm.setString(2, kh.getTenKH());
            pstm.setBoolean(3, kh.isGioiTinh());
            pstm.setString(4, kh.getDiaChi());
            pstm.setString(5, kh.getSDT());
            pstm.setString(6, kh.getCMND());
            pstm.setBoolean(7, kh.isTrangThai());
            int i = pstm.executeUpdate();
            if(i>0){
                bl=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public boolean updateKhachHang(KhachHang kh) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Sua_KhachHang(?,?,?,?,?,?,?)}");
            pstm.setString(1, kh.getMaKH());
            pstm.setString(2, kh.getTenKH());
            pstm.setBoolean(3, kh.isGioiTinh());
            pstm.setString(4, kh.getDiaChi());
            pstm.setString(5, kh.getSDT());
            pstm.setString(6, kh.getCMND());
            pstm.setBoolean(7, kh.isTrangThai());
            int i = pstm.executeUpdate();
            if(i>0){
                bl=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public boolean deleteKhachHang(KhachHang kh) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Xoa_KhachHang(?)}");
            pstm.setString(1, kh.getMaKH());
            int i = pstm.executeUpdate();
            if(i>0){
                bl=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public List<KhachHang> getKhachHangByName(String tenKH) {
       List<KhachHang> listkh = new ArrayList<>();
       
       Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs =null;
        
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_TimKiemTheoTen_KhachHang(?)}");
            pstm.setString(1, tenKH);
            rs = pstm.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setGioiTinh(rs.getBoolean("GioiTinh"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSDT(rs.getString("SDT"));
                kh.setCMND(rs.getString("CMND"));
                kh.setTrangThai(rs.getBoolean("TrangThai"));
                listkh.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
       
       return listkh;
    }

    @Override
    public boolean checkMaKH(String maKH) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("Select *from KhachHang where MaKH=?");
            pstm.setString(1, maKH);
            rs = pstm.executeQuery();
            bl=rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bl;
    }
    
}
