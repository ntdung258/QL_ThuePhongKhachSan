/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entitys.DichVu;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DichVuDao {
    public List<DichVu> getAllDichVu();
    public DichVu getDichVu (String maDV);
    public boolean insertDichVu (DichVu dv);
    public boolean updateDichVu (DichVu dv);
    public boolean deleteDichVu(DichVu dv);
    public List<DichVu> getDichVuByName (String tenDV);
    public boolean checkMaDV(String maDV);
    public boolean checkTenDV(String tenDV);
}
