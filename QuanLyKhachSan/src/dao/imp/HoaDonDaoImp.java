/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import Entitys.HoaDon;
import Entitys.HoaDonDTO;
import Entitys.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.HoaDonDao;

/**
 *
 * @author Admin
 */
public class HoaDonDaoImp implements HoaDonDao{

    @Override
    public List<HoaDonDTO> getALlHoaDon() {
        List<HoaDonDTO> listhd = new ArrayList<>();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("select *from HoaDonDTO");
            rs = pstm.executeQuery();
            while(rs.next()){
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setTenNV(rs.getString("TenNV"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                listhd.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }        
        return listhd;
    }

    @Override
    public boolean insertHoaDon(HoaDon hd) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("Insert into HoaDon (MaHD,MaKH,MaNV)values(?,?,?)");
            pstm.setString(1, hd.getMaHD());
            pstm.setString(2, hd.getMaKH());
            pstm.setString(3, hd.getMaNV());
            int i = pstm.executeUpdate();
             if(i>0){
                 bl=true;
             }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        
        return bl;
    }

    @Override
    public boolean checkMaHD(String maHD) {
        boolean bl = false;
        HoaDon hd = new HoaDon();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select *from HoaDon where MaHD=?");
            pstm.setString(1,maHD);
            rs = pstm.executeQuery();
            bl=rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public boolean updateHoaDon(HoaDon hd) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("Update HoaDon set MaKH=?,MaNV=? where MaHD=?");
            pstm.setString(3, hd.getMaHD());
            pstm.setString(1, hd.getMaKH());
            pstm.setString(2, hd.getMaNV());
            int i = pstm.executeUpdate();
             if(i>0){
                 bl=true;
             }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        
        return bl;
    }

    
    @Override
    public boolean updateTrangThaiKhachHang(String maKH) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("Update KhachHang set TrangThai=0 where MaKH=?");
            pstm.setString(1, maKH);
            int i = pstm.executeUpdate();
             if(i>0){
                 bl=true;
             }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        
        return bl;
    }

    @Override
    public List<KhachHang> getKhachHangThue() {
        List<KhachHang> listkh = new ArrayList<>();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("select *from KhachHang where TrangThai=1");
            rs = pstm.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                listkh.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }        
        return listkh;
    }

    @Override
    public boolean AnButtonThanhToan(String maKH) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("select *from KhachHang where MaKH=? AND TrangThai=0");
            pstm.setString(1, maKH);
            rs = pstm.executeQuery();
            bl = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        
        return bl;
    }

    @Override
    public boolean deleteHoaDon(String maHD) {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("delete HoaDon where maHD=?");
            pstm.setString(1,maHD);
            int i = pstm.executeUpdate();
            if(i>0){
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public List<HoaDonDTO> getHoaDonByMa(String maHD) {
        List<HoaDonDTO> listhddto  = new ArrayList<>();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("select *from HoaDonDTO where MaHD=?");
            pstm.setString(1, maHD);
            rs = pstm.executeQuery();
            if(rs.next()){
                HoaDonDTO hddto = new HoaDonDTO();
                hddto.setMaHD(rs.getString("MaHD"));
                hddto.setMaKH(rs.getString("MaKH"));
                hddto.setTenKH(rs.getString("TenKH"));
                hddto.setMaNV(rs.getString("MaNV"));
                hddto.setTenNV(rs.getString("TenNV"));
                hddto.setTrangThai(rs.getBoolean("TrangThai"));
                listhddto.add(hddto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }        
        return listhddto;
    }

    @Override
    public List<HoaDonDTO> getHoaDonByTenKH(String tenKH) {
       List<HoaDonDTO> listhd = new ArrayList<>();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_TimKiemTheoTen_KhachHang_HoaDon(?)}");
            pstm.setString(1, tenKH);
            rs = pstm.executeQuery();
            while(rs.next()){
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setTenNV(rs.getString("TenNV"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                listhd.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }        
        return listhd;
    }

    @Override
    public List<HoaDonDTO> getHoaDonByMaNV(String maNV) {
        List<HoaDonDTO> listhd = new ArrayList<>();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("Select *from HoaDonDTO where MaNV=?");
            pstm.setString(1, maNV);
            rs = pstm.executeQuery();
            while(rs.next()){
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setTenNV(rs.getString("TenNV"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                listhd.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }        
        return listhd;
    }
    
    

}
