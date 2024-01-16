/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.KhachHang;
import repository.KhachHangRepository;
import service.KhachHangService;
import viewmodel.QLKhachHang;

/**
 *
 * @author pc
 */
public class KhachHangServiceImpl implements KhachHangService{
    KhachHangRepository repository;
    
    public KhachHangServiceImpl(){
        this.repository = new KhachHangRepository();
    }
    @Override
    public ArrayList<QLKhachHang> getList() {
       return repository.getListFromDB();
    }

    @Override
    public Boolean Them(KhachHang khachHang) {
        return repository.Them(khachHang);
    }

    @Override
    public Boolean Xoa(int id) {
        return repository.Xoa(id);
    }

    @Override
    public Boolean Sua(int id, KhachHang khachHang) {
       return repository.Sua(id, khachHang);
    }

    @Override
    public ArrayList<QLKhachHang> TimKiem(String name) {
        return repository.TimKiemTheoMa(name);
    }

    @Override
    public void khachHangTaoHD(int id) {
        repository.khachHangTaoHoaDon(id);
    }

    @Override
    public void khachHangThanhToanHD(int id) {
        repository.khachHangThanhToanHoaDon(id);
    }

    
}
