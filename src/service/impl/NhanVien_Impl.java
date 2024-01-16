/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.NhanVien;
import repository.NhanVien_Repository;
import service.NhanVien_Service;
import viewmodel.QLNhanVien;

/**
 *
 * @author pc
 */
public class NhanVien_Impl implements NhanVien_Service{
    NhanVien_Repository nhanVien_Repository;

    @Override
    public ArrayList<QLNhanVien> getList() {
       return nhanVien_Repository.getListFromDB();
    }

    @Override
    public Boolean Them(NhanVien nhanVien_View) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean Xoa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean Sua(int id, NhanVien nhanVien_View) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<QLNhanVien> TimKiem(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
