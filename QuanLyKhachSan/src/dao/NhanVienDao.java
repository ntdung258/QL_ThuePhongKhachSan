/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entitys.NhanVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface NhanVienDao {
    public List<NhanVien> getAllNhanVien();
    public NhanVien getMaNV(String maNV);
    public boolean insertNhanVien (NhanVien nv);
    public boolean updateNhanVien (NhanVien nv);
    public boolean deleteNhanVien (NhanVien nv);
    public List<NhanVien> getNhanVienByName (String tenNV );
    public boolean checkMaNV(String maNV);
}
