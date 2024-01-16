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
public class SanPhamServiceImpl implements ISanPhamSevice {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPhamViewModel> getAll() {
        List<SanPhamModel> lietSPmodel = sanPhamRepository.getAll();
        List<SanPhamViewModel> viewModels = new ArrayList<>();
        for (SanPhamModel sp : lietSPmodel) {
            viewModels.add(new SanPhamViewModel(sp.getId(), sp.getMa(), sp.getTen(), sp.getLoaiSanPham(), sp.getSoLuong()));
        }
        return viewModels;
    }

    @Override
    public String getAdd(SanPhamViewModel sp) {
        SanPhamModel model = new SanPhamModel(sp.getId(), sp.getMa(), sp.getTen(), sp.getLoaiSanPham(), sp.getSoLuong());
        boolean them = sanPhamRepository.getAdd(model);
        if (them) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String getUpdate(SanPhamViewModel sp, Integer id) {
        SanPhamModel model = new SanPhamModel(sp.getId(), sp.getMa(), sp.getTen(), sp.getLoaiSanPham(), sp.getSoLuong());
        boolean t = sanPhamRepository.getUpđate(model, id);
        if (t) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

}
