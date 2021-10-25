/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entitys.ChiTietDatPhong;
import Entitys.DatPhong;
import Entitys.Phong;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DatPhongDao {
    public boolean datPhong(DatPhong dp);
    public List<Phong> getPhongTrong();
    public boolean updateTrangThaiPhongSangDangSD (DatPhong dp);
    public boolean updateTrangThaiPhongSangTrong (String maP);
    public List<ChiTietDatPhong> getChiTietDP(String maHD);
    public  ChiTietDatPhong getTienPhong(String maHD);
    public ChiTietDatPhong getDatPhong(String maHD);
    public boolean delete(String maHD);
    public DatPhong getMaPhong(String maHD);
    public boolean XoaDatPhong(String maHD,String maP);
    public boolean getHoaDonByMaKH(String maKH);
}
