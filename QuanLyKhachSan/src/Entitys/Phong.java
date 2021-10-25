/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
 *
 * @author Admin
 */
public class Phong {
    private String maP;
    private String tenP;
    private float gia;
    private boolean trangThai;

    public Phong() {
    }

    public Phong(String maP, String tenP, float gia, boolean trangThai) {
        this.maP = maP;
        this.tenP = tenP;
        this.gia = gia;
        this.trangThai = trangThai;
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

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    
    
    
}
