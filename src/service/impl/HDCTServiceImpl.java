/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.HoaDonCTModel;
import repository.HDCTRepository;
import service.HDCTService;
import viewmodel.GioHangViewModel;
import viewmodel.HDCTViewModel;

/**
 *
 * @author Admin
 */
public class HDCTServiceImpl implements HDCTService {
    HDCTRepository hdctRepo=new HDCTRepository();
    @Override
    public List<HDCTViewModel> getAll() {
List<HoaDonCTModel> list=hdctRepo.getAll();
        List<HDCTViewModel> listAl=new ArrayList<>();
        for (HoaDonCTModel hdct : list) {
            listAl.add(new HDCTViewModel(hdct.getId(),hdct.getIdHD(),hdct.getIdSPCT(),hdct.getSoLuong(),hdct.getDonGia()));
        }
        return listAl;    }

    @Override
    public String getAdd(HDCTViewModel hdct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdate(HDCTViewModel hdct, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDelete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GioHangViewModel> getGioHang() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateSoLuong(int id, int soLuong, Float donGia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
