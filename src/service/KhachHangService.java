/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.KhachHang;
import viewmodel.QLKhachHang;

/**
 *
 * @author pc
 */
public interface KhachHangService {
     public ArrayList<QLKhachHang> getList();

    public Boolean Them(KhachHang khachHang);

    public Boolean Xoa(int id);

    public Boolean Sua(int id, KhachHang khachHang);

    public ArrayList<QLKhachHang> TimKiem(String name);

    void khachHangTaoHD(int id);

    void khachHangThanhToanHD(int id);
    
}
