/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import Entitys.ChiTietDatPhong;
import Entitys.DatPhong;
import Entitys.Phong;
import dao.DatPhongDao;
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
public class DatPhongDaoImp implements DatPhongDao{

    @Override
    public boolean datPhong(DatPhong dp) {
        boolean bl = false;
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        
        try {
            pstm = conn.prepareStatement("insert into DatPhong(MaHD,MaP,NgayDen,NgayDi) values(?,?,?,?)");
            pstm.setString(1,dp.getMaHD());
            pstm.setString(2,dp.getMaP() );
            pstm.setDate(3,new Date(dp.getNgayDen().getTime()) );
            pstm.setDate(4,new Date(dp.getNgayDi().getTime()) );
            int i = pstm.executeUpdate();
            if(i>0){
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }

        
        return bl;
    }

    @Override
    public List<Phong> getPhongTrong() {
        List<Phong> listp = new ArrayList<>();
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("Select *from Phong where TrangThai=1");
            rs = pstm.executeQuery();
            while(rs.next()){
                Phong p = new Phong();
                p.setMaP(rs.getString("MaP"));
                p.setTenP(rs.getString("TenP"));
                p.setGia(rs.getFloat("Gia"));
                p.setTrangThai(rs.getBoolean("trangThai"));
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
    public boolean updateTrangThaiPhongSangDangSD(DatPhong dp) {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("update Phong set TrangThai=0 where MaP=?");
            pstm.setString(1,dp.getMaP());
            int i = pstm.executeUpdate();
            if(i>0){
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public List<ChiTietDatPhong> getChiTietDP(String maHD) {
        List<ChiTietDatPhong> listctdp = new ArrayList<>();
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select Phong.MaP,Phong.TenP,Phong.Gia,DatPhong.NgayDen,DatPhong.NgayDi,DATEDIFF(Day,DatPhong.NgayDen,DatPhong.NgayDi)*Phong.Gia AS TienPhong from DatPhong join Phong on DatPhong.MaP = Phong.MaP where DatPhong.MaHD=?");
            pstm.setString(1,maHD);
            rs = pstm.executeQuery();
            while(rs.next()){
                ChiTietDatPhong ctdp = new ChiTietDatPhong();
                ctdp.setMaP(rs.getString("MaP"));
                ctdp.setTenP(rs.getString("TenP"));
                ctdp.setGia(rs.getFloat("Gia"));
                ctdp.setNgayDen(rs.getDate("NgayDen"));
                ctdp.setNgayDi(rs.getDate("NgayDi"));
                ctdp.setTienP(rs.getFloat("TienPhong"));
                listctdp.add(ctdp);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn,pstm,rs);
        }
        
        return listctdp;
    }

    @Override
    public ChiTietDatPhong getTienPhong(String maHD) {
        
        ChiTietDatPhong ctdp = new ChiTietDatPhong();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select SUM(TienPhong.TienPhong)AS TongTienPhong from TienPhong where MaHD=?");
            pstm.setString(1, maHD);
            rs = pstm.executeQuery();
            if(rs.next()) {
                ctdp.setTongTienPhong(rs.getFloat("TongTienPhong"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatPhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.DbUlity.closeAll(conn, pstm, rs);
        }

        return ctdp;
    }

    @Override
    public ChiTietDatPhong getDatPhong(String maHD) {
        ChiTietDatPhong ctdp = new ChiTietDatPhong();
        
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select DatPhong.MaP,DatPhong.NgayDen,DatPhong.NgayDi from DatPhong where MaHD=?");
            pstm.setString(1, maHD);
            rs = pstm.executeQuery();
            if(rs.next()){
                ctdp.setMaP(rs.getString("MaP"));
                ctdp.setNgayDen(rs.getDate("NgayDen"));
                ctdp.setNgayDi(rs.getDate("NgayDi"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn,pstm,rs);
        }
        
        return ctdp;
    }

    @Override
    public boolean updateTrangThaiPhongSangTrong(String maP) {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("update Phong set TrangThai=1 where MaP=?");
            pstm.setString(1,maP);
            int i = pstm.executeUpdate();
            if(i>0){
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public boolean delete(String maHD) {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("delete DatPhong where maHD=?");
            pstm.setString(1,maHD);
            int i = pstm.executeUpdate();
            if(i>0){
                bl = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    @Override
    public DatPhong getMaPhong(String maHD) {
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        DatPhong dp = new DatPhong();
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("Select *from DatPhong where MaHD=?");
            pstm.setString(1,maHD);
            rs = pstm.executeQuery();
            if(rs.next()){
              dp.setMaP(rs.getString("MaP"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn,pstm,rs);
        }
        
        return dp;
    }

    @Override
    public boolean XoaDatPhong(String maHD, String maP) {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("delete DatPhong where MaHD=?  AND MaP=? ");
            pstm.setString(1,maHD);
            pstm.setString(2, maP);
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
    public boolean getHoaDonByMaKH(String maKH) {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = db.DbUlity.openConnection();
        try {
            pstm = conn.prepareStatement("select *from HoaDon where MaKH=?");
            pstm.setString(1,maKH);
            rs = pstm.executeQuery();
            bl=rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.DbUlity.closeAll(conn, pstm, rs);
        }
        
        return bl;
    }

    

   
}
