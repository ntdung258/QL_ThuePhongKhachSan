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
public class HoaDon {
    private String maHD;
    private String maKH;
    private String maNV;
    

    public HoaDon() {
    }

    public HoaDon(String maHD, String maKH, String maNV) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
}
