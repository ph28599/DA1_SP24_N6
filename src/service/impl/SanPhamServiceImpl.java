/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.SanPhamModel;
import repository.SanPhamRepository;
import service.ISanPhamSevice;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author LAPTOP24H
 */
public class SanPhamServiceImpl implements ISanPhamSevice{

    SanPhamRepository sanPhamRepository = new SanPhamRepository();
    
    
    @Override
    public List<SanPhamViewModel> getAll() {
       List<SanPhamModel> lietSPmodel = sanPhamRepository.getAll();
       List<SanPhamViewModel> viewModels = new ArrayList<>();
       for(SanPhamModel sp : lietSPmodel){
           viewModels.add(new SanPhamViewModel(sp.getId(), sp.getMa(), sp.getTen(), sp.getLoaiSanPham(), sp.getSoLuong()));
       }
       return viewModels;
    }

    @Override
    public String getAdd(SanPhamViewModel sp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdate(SanPhamViewModel sp, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
