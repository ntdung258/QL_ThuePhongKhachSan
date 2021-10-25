/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entitys.NguoiDung;

/**
 *
 * @author Admin
 */
public interface NguoiDungDao {
    public NguoiDung getNguoiDung();
    public boolean DoiMatKhau(String matKhau);
}
