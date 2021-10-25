/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;
import Entitys.DichVu;
import dao.DichVuDao;
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
public class DichVuDaoImp implements DichVuDao{

    @Override
    public List<DichVu> getAllDichVu() {
        List<DichVu> listdv = new ArrayList<>();
        
        Connection conn;
        PreparedStatement pstm =null;
        ResultSet rs =null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("Select *from DichVu");
            rs = pstm.executeQuery();
            while(rs.next()){
                DichVu dv = new DichVu();
                dv.setMaDV(rs.getString("MaDV"));
                dv.setTenDV(rs.getString("TenDV"));
                dv.setGia(rs.getFloat("Gia"));
                listdv.add(dv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return listdv;
    }

    @Override
    public DichVu getDichVu(String maDV) {
        DichVu dv =null;
        Connection conn;
        PreparedStatement pstm =null;
        ResultSet rs =null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("Select *from DichVu where MaDV=?");
            pstm.setString(1, maDV);
            rs = pstm.executeQuery();
            if(rs.next()){
                dv = new DichVu();
                dv.setMaDV(rs.getString("MaDV"));
                dv.setTenDV(rs.getString("TenDV"));
                dv.setGia(rs.getFloat("Gia"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return dv;
    }

    @Override
    public boolean insertDichVu(DichVu dv) {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstm =null;
        ResultSet rs =null;
 
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("{CALL pr_Them_DichVu(?,?,?)}");
            pstm.setString(1, dv.getMaDV());
            pstm.setString(2, dv.getTenDV());
            pstm.setFloat(3, dv.getGia());
             int i = pstm.executeUpdate();
             if(i>0){
                 bl=true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        
        return bl;
    }

    @Override
    public boolean updateDichVu(DichVu dv) {
       boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Sua_DichVu(?,?,?)}");
            pstm.setString(1, dv.getMaDV());
            pstm.setString(2, dv.getTenDV());
            pstm.setFloat(3, dv.getGia());
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
    public boolean deleteDichVu(DichVu dv) {
       boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("{CALL pr_Xoa_DichVu(?)}");
            pstm.setString(1,dv.getMaDV() );
            
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
    public List<DichVu> getDichVuByName(String tenDV) {
       List<DichVu> listdv = new ArrayList<>();
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("{CALL pr_TimKiemTheoTen_DichVu(?)}");
            pstm.setString(1, tenDV);
            rs = pstm.executeQuery();
            while(rs.next()){
                DichVu dv = new DichVu();
                dv.setMaDV(rs.getString("MaDV"));
                dv.setTenDV(rs.getString("TenDV"));
                dv.setGia(rs.getFloat("Gia"));
                listdv.add(dv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        
        return listdv;
    }

    @Override
    public boolean checkMaDV(String maDV) {
        boolean bl = false;
        DichVu dv = new DichVu();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select *from DichVu where MaDV=?");
            pstm.setString(1,maDV);
            rs = pstm.executeQuery();
            bl=rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(PhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public boolean checkTenDV(String tenDV) {
        boolean bl = false;
        DichVu dv = new DichVu();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select *from DichVu where TenDV=?");
            pstm.setString(1,tenDV);
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
