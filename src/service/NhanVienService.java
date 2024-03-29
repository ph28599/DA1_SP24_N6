/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import viewmodel.QLKhachHang;
import viewmodel.QLNhanVien;

/**
 *
 * @author adm
 */
public interface NhanVienService {
    public ArrayList<QLNhanVien> getList();
    
    public Boolean Them(NhanVien nhanVien);
    
    public Boolean Xoa(int id);
    
    public Boolean Sua(int id, NhanVien nhanVien);
    
    public ArrayList<QLNhanVien> TimKiem(String name);
    
    public List<QLNhanVien> getPhanTrang(int offset, int fetchSize);
}
