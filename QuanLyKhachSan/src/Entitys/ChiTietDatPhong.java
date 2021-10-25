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
public class ChiTietDatPhong {
    private String maHD;
    private String maP;
    private String tenP;
    private Float gia;
    private Date ngayDen;
    private Date ngayDi;
    private Float tienP;
    private float tongTienPhong;

    public ChiTietDatPhong() {
    }

    public ChiTietDatPhong(String maHD, String maP, String tenP, Float gia, Date ngayDen, Date ngayDi, Float tienP, float tongTienPhong) {
        this.maHD = maHD;
        this.maP = maP;
        this.tenP = tenP;
        this.gia = gia;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
        this.tienP = tienP;
        this.tongTienPhong = tongTienPhong;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    
    
    public String getMaP() {
        return maP;
    }

    public void setMaP(String maP) {
        this.maP = maP;
    }

    public String getTenP() {
        return tenP;
    }

    public void setTenP(String tenP) {
        this.tenP = tenP;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public Date getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(Date ngayDen) {
        this.ngayDen = ngayDen;
    }

    public Date getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(Date ngayDi) {
        this.ngayDi = ngayDi;
    }

    public Float getTienP() {
        return tienP;
    }

    public void setTienP(Float tienP) {
        this.tienP = tienP;
    }

    public float getTongTienPhong() {
        return tongTienPhong;
    }

    public void setTongTienPhong(float tongTienPhong) {
        this.tongTienPhong = tongTienPhong;
    }

    
    
    
}
