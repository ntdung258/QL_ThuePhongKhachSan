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
public class SuDungDV {
    private String maHD;
    private String maDV;
    private int soLuong;
    private Date NgaySuDung;

    public SuDungDV() {
    }

    public SuDungDV(String maHD, String maDV, int soLuong, Date NgaySuDung) {
        this.maHD = maHD;
        this.maDV = maDV;
        this.soLuong = soLuong;
        this.NgaySuDung = NgaySuDung;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgaySuDung() {
        return NgaySuDung;
    }

    public void setNgaySuDung(Date NgaySuDung) {
        this.NgaySuDung = NgaySuDung;
    }

    
    
}
