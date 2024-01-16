/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.NhanVien;
import viewmodel.QLNhanVien;

/**
 *
 * @author pc
 */
public interface NhanVien_Service {
    public ArrayList<QLNhanVien> getList();
    
    public Boolean Them(NhanVien nhanVien_View);
    
    public Boolean Xoa(int id);
    
    public Boolean Sua(int id, NhanVien nhanVien_View);
    
    public ArrayList<QLNhanVien> TimKiem(String name);
    
}
