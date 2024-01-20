/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.HoaDonModel;
import repository.HDRepository;
import service.HDService;
import viewmodel.HDViewModel;

/**
 *
 * HDViewModel(hd.getId(), hd.getMa(), hd.getIdNV(), hd.getIdKH(), hd.getPgg(),
 * hd.getNgayTao(), hd.getNgayThanhToan(), hd.getTienGiam(), hd.getTongTien(),
 * hd.getTienKhachDua(), hd.getTienThua(), hd.getTienKhachPhaiTra(),
 * hd.getHinhThucThanhToan(), hd.getMaChuyenKhoan(), hd.getTrangThai()));
 *
 * @author Admin
 */
public class HDServiceImpl implements HDService {

    HDRepository hdRepo = new HDRepository();

    @Override
    public List<HDViewModel> getAll() {
        List<HoaDonModel> list = hdRepo.getAll();
        List<HDViewModel> listAll = new ArrayList<>();
        for (HoaDonModel hd : list) {
            listAll.add(new HDViewModel(hd.getId(), hd.getMa(), hd.getIdNV(), hd.getIdKH(), hd.getPgg(), hd.getNgayTao(), hd.getNgayThanhToan(), hd.getTienGiam(), hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getTienKhachPhaiTra(), hd.getHinhThucThanhToan(), hd.getMaChuyenKhoan(), hd.getTrangThai()));
        }
        return listAll;
    }

    @Override
    public String getAdd(HDViewModel hd) {
        HoaDonModel hdAdd = new HoaDonModel(hd.getId(), hd.getMa(), hd.getIdNV(), hd.getIdKH(), hd.getPGG(), hd.getNgayTao(), hd.getNgayThanhToan(), hd.getTienGiam(), hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getTienKhachPhaiTra(), hd.getHinhThucThanhToan(), hd.getMaChuyenKhoan(), hd.getTrangThai());
        boolean add = hdRepo.getAdd(hdAdd);
        if (add) {
            return "Thanh cong";
        } else {
            return "That bai";
        }
    }

    @Override
    public String getUpdate(HDViewModel hd, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDelete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getThanhToan(HDViewModel hd, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
