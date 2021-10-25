/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entitys.KhachHang;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface KhachHangDao {
    public List<KhachHang> getAllKhachHang();
    public KhachHang getKhachHanh (String maKH);
    public boolean insertKhachHang (KhachHang kh);
    public boolean updateKhachHang (KhachHang kh);
    public boolean deleteKhachHang (KhachHang kh);
    public List<KhachHang> getKhachHangByName (String tenKH);
    public boolean checkMaKH (String maKH);
}