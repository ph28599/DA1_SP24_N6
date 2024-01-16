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
public interface NhanVienService {

    public ArrayList<QLNhanVien> getList();

    public Boolean Them(NhanVien nhanVien);

    public Boolean Sua(int id, NhanVien nhanVien);

    public ArrayList<QLNhanVien> TimKiem(String name);

}
