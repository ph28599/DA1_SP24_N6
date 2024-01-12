/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.KhachHang_View;
import viewmodel.QLKhachHang;

/**
 *
 * @author pc
 */
public interface KhachHang_Service {
    public ArrayList<QLKhachHang> getList();
    
    public Boolean Them(KhachHang_View khachHang_View);
    
    public Boolean Xoa(int id);
    
    public Boolean Sua(int id, KhachHang_View khachHang_View);
    
    public ArrayList<QLKhachHang> TimKiem(String name);
    
    void khachHangTaoHD(int id);
    
    void khachHangThanhToanHD(int id);
    
}
