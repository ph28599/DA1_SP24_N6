/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.NhanVien;
import repository.NhanVienRepository;
import viewmodel.QLNhanVien;
import service.NhanVienService;

/**
 *
 * @author pc
 */
public class NhanVienImpl implements NhanVienService{
    NhanVienRepository nhanVienRepository;

    public NhanVienImpl(){
        this.nhanVienRepository = new NhanVienRepository();
    }
    @Override
    public ArrayList<QLNhanVien> getList() {
       return nhanVienRepository.getListFromDB();
    }

    @Override
    public Boolean Them(NhanVien nhanVien) {
        return nhanVienRepository.Them(nhanVien);
    }
   

    @Override
    public Boolean Sua(int id, NhanVien nhanVien) {
        return nhanVienRepository.Sua(id, nhanVien);
    }

    @Override
    public ArrayList<QLNhanVien> TimKiem(String name) {
        return nhanVienRepository.TimKiemTheoMa(name);
    }
    
}
