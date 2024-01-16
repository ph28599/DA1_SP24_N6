/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.Login;
import repository.TaiKhoan_Repository;
import service.TaiKhoan_Service;
import viewmodel.QLTaiKhoan;

/**
 *
 * @author pc
 */
public class TaiKhoan_Impl implements TaiKhoan_Service{
    private TaiKhoan_Repository taiKhoan_Repository;

    @Override
    public ArrayList<QLTaiKhoan> getList() {
        return taiKhoan_Repository.getListFromDB();
    }

    @Override
    public Boolean Them(Login login_View) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean Xoa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean Sua(int id, Login login_View) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<QLTaiKhoan> TimKiem(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
