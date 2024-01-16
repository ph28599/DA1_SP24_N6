/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.Login;
import viewmodel.QLTaiKhoan;

/**
 *
 * @author pc
 */
public interface TaiKhoan_Service {
    public ArrayList<QLTaiKhoan> getList();
    
    public Boolean Them(Login login_View);
    
    public Boolean Xoa(int id);
    
    public Boolean Sua(int id, Login login_View);
    
    public ArrayList<QLTaiKhoan> TimKiem(String name);
    
}
