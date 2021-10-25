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
public class DatPhong {
    private String maHD;
    private String maP;
    private Date ngayDen;
    private Date ngayDi;

    public DatPhong(String maHD, String maP, Date ngayDen, Date ngayDi) {
        this.maHD = maHD;
        this.maP = maP;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
    }

    
    

    public DatPhong() {
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
    
}
