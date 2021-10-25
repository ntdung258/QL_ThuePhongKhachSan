/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entitys.Phong;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface PhongDao {
    public List<Phong> getAllPhong();
    public Phong getMaPhong(String maP);
    public boolean insertPhong (Phong p);
    public boolean updatePhong (Phong p);
    public boolean deletePhong (Phong p);
    public boolean checkMaPhong (String maP);
    
}
