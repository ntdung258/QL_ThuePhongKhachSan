/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.util.Date;



/**
 *
 * @author Admin
 */
public class NhanVien {
    private String maNV;
    private String tenNV;
    private boolean GioiTinh;
    private Date ngaySinh;
    private String SDT;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, boolean GioiTinh, Date ngaySinh, String SDT) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.GioiTinh = GioiTinh;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
    
}
