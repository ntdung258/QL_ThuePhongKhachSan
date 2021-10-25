/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import Entitys.HoaDonDTO;
import Entitys.HoaDon;
import Entitys.KhachHang;
/**
 *
 * @author Admin
 */
public interface HoaDonDao {
    public List<HoaDonDTO> getALlHoaDon();
    public boolean insertHoaDon(HoaDon hd);
    public boolean updateHoaDon(HoaDon hd);
    public boolean checkMaHD (String maHD);
    public List<KhachHang> getKhachHangThue();
    public boolean updateTrangThaiKhachHang(String maKH);
    public boolean AnButtonThanhToan(String maKH);
    public boolean deleteHoaDon(String maHD);
    public List<HoaDonDTO> getHoaDonByMa(String maHD);
    public List<HoaDonDTO> getHoaDonByTenKH(String tenKH);
    public List<HoaDonDTO> getHoaDonByMaNV(String maNV);
}
