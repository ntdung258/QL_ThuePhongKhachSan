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
public class ChiTietSDDV {
    private String maHD; 
    private String maDV;
    private String tenDV;
    private Float gia;
    private int soLuong;
    private Date ngaySD;
    private float tienDV;
    private float tongTienDV;

    public ChiTietSDDV() {
    }

    public ChiTietSDDV(String maHD, String maDV, String tenDV, Float gia, int soLuong, Date ngaySD, float tienDV, float tongTienDV) {
        this.maHD = maHD;
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.gia = gia;
        this.soLuong = soLuong;
        this.ngaySD = ngaySD;
        this.tienDV = tienDV;
        this.tongTienDV = tongTienDV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    
    
    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgaySD() {
        return ngaySD;
    }

    public void setNgaySD(Date ngaySD) {
        this.ngaySD = ngaySD;
    }

    public float getTienDV() {
        return tienDV;
    }

    public void setTienDV(float tienDV) {
        this.tienDV = tienDV;
    }

    public float getTongTienDV() {
        return tongTienDV;
    }

    public void setTongTienDV(float tongTienDV) {
        this.tongTienDV = tongTienDV;
    }

    
    
}
