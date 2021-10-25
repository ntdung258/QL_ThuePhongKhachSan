/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class Common {
    
    public static String FormatNumber(float number) {
        NumberFormat nf = NumberFormat.getInstance();
        return nf.format(number);
    }
    
    public static String FomatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
    
    public static String GioiTinh(boolean gioiTinh){
        String gd=null;
        if(gioiTinh==true){
            gd="Nam";
        }else{
            gd="Nữ";
        }
        return gd;
    }
    
    public static String TrangThai(boolean trangThai){
        String gd=null;
        if(trangThai==true){
            gd="Trống";
        }else{
            gd="Đang SD";
        }
        return gd;
    }
    
    public static String TrangThaiKH(boolean trangThai){
        String gd=null;
        if(trangThai==true){
            gd="Đang thuê";
        }else{
            gd="Đã rời đi";
        }
        return gd;
    }
    
    
}