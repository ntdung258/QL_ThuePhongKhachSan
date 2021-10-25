/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entitys.ChiTietSDDV;
import Entitys.SuDungDV;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface SuDungDVDao {
    public boolean insertSuDungDv(SuDungDV sddv);
    public List<ChiTietSDDV> getCTDV(String maHD);
    
    public ChiTietSDDV getTongTienDV(String maHD);
    public boolean deleteSuDungDV(String maHD);
    public boolean XoaSuDungDV(String maHD,String maDV);
}
