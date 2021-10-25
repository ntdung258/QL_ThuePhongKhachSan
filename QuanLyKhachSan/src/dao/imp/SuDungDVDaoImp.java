/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import Entitys.ChiTietSDDV;
import Entitys.SuDungDV;
import dao.SuDungDVDao;
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
public class SuDungDVDaoImp implements SuDungDVDao{
    
    @Override
    public boolean insertSuDungDv(SuDungDV sddv) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("insert into SuDungDV(MaHD,MaDV,SoLuong,NgaySuDung)values(?,?,?,?)");
            pstm.setString(1, sddv.getMaHD());
            pstm.setString(2, sddv.getMaDV());
            pstm.setInt(3, sddv.getSoLuong());
            pstm.setDate(4, new Date(sddv.getNgaySuDung().getTime()));            
             int i = pstm.executeUpdate();
             if(i>0){
                 bl=true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(SuDungDVDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public List<ChiTietSDDV> getCTDV(String maHD) {
        List<ChiTietSDDV> listctsddv  = new ArrayList<>();
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select DichVu.MaDV,DichVu.TenDV,DichVu.Gia,SuDungDV.SoLuong,SuDungDV.NgaySuDung,DichVu.Gia*SuDungDV.SoLuong AS TienDV from SuDungDV join DichVu on SuDungDV.MaDV = DichVu.MaDV where SuDungDV.MaHD=?");
            pstm.setString(1,maHD);
            rs = pstm.executeQuery();
            while(rs.next()){
                ChiTietSDDV ctsddv = new ChiTietSDDV();
                ctsddv.setMaDV(rs.getString("MaDv"));
                ctsddv.setTenDV(rs.getString("TenDv"));
                ctsddv.setGia(rs.getFloat("Gia"));
                ctsddv.setSoLuong(rs.getInt("SoLuong"));
                ctsddv.setNgaySD(rs.getDate("NgaySuDung"));
                ctsddv.setTienDV(rs.getFloat("TienDV"));
                listctsddv.add(ctsddv);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SuDungDVDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn,pstm,rs);
        }
        
        return listctsddv;
    }

    @Override
    public ChiTietSDDV getTongTienDV(String maHD) {
        ChiTietSDDV ctsddv = new ChiTietSDDV();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select SUM(TienDichVu.TienDV)AS TongTienDV from TienDichVu where MaHD=?");
            pstm.setString(1, maHD);
            rs = pstm.executeQuery();
            if(rs.next()) {
                ctsddv.setTongTienDV(rs.getFloat("TongTienDV"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SuDungDVDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.DbUlity.closeAll(conn, pstm, rs);
        }

        return ctsddv;
    }

    @Override
    public boolean deleteSuDungDV(String maHD) {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("delete SuDungDV where MaHD=?");
            pstm.setString(1,maHD);
            int i = pstm.executeUpdate();
            if(i>0){
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuDungDVDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public boolean XoaSuDungDV(String maHD, String maDV) {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("delete SuDungDV where MaHD=?  AND MaDV=? ");
            pstm.setString(1,maHD);
            pstm.setString(2, maDV);
            int i = pstm.executeUpdate();
            if(i>0){
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuDungDVDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }
    
}
