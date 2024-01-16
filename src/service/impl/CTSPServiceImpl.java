/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.CTSPModel;
import model.ChiTietSanPhamModel;
import repository.CTSPRepository;
import repository.CTSPTableRepo;
import service.ICTSPService;
import viewmodel.CTSPViewModel;
import viewmodel.ChiTietSanPhamViewModel;

/**
 *
 * @author LAPTOP24H
 */
public class CTSPServiceImpl implements ICTSPService {

    CTSPRepository cTSPRepository = new CTSPRepository();
    CTSPTableRepo tableRepo = new CTSPTableRepo();

    @Override
    public List<CTSPViewModel> getAll() {

        List<CTSPModel> listAll = cTSPRepository.getAll();
        List<CTSPViewModel> listTable = new ArrayList<>();
        for (CTSPModel c : listAll) {
            listTable.add(new CTSPViewModel(c.getId(), c.getMa(), c.getMaVach(), c.getMoTa(), c.getSoLuong(), c.getIdSP(), c.getIdTH(), c.getIdLA(), c.getIdKC(), c.getIdMS(), c.getIdCL(), c.getGiaNhap(), c.getGiaBan(), c.isTrangThai()));
        }
        return listTable;
    }

    @Override
    public String add(CTSPViewModel ctsp) {
        // CTSPModel model = new CTSPModel(ctsp.getId(), ctsp.getMa(), ctsp.getMaVach(), ctsp.getMoTa(), ctsp.getSoLuong(), ctsp.getIdSP(), ctsp.getIdTH(), ctsp.getIdLA(), ctsp.getIdKC(), ctsp.getIdMS(),ctsp.getIdCL(),ctsp.getGiaNhap(), ctsp.getGiaBan(),ctsp.isTrangThai() );

        CTSPModel model = new CTSPModel(ctsp.getId(), ctsp.getMa(), ctsp.getMaVach(), ctsp.getMoTa(), ctsp.getSoLuong(), ctsp.getIdSP(), ctsp.getIdTH(), ctsp.getIdLA(), ctsp.getIdKC(), ctsp.getIdMS(), ctsp.getIdCL(), ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.isTrangThai());
        boolean them = cTSPRepository.getAdd(model);
        if (them) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public List<ChiTietSanPhamViewModel> getAllTale() {
        List<ChiTietSanPhamModel> listAll = tableRepo.getAllTable();
        List<ChiTietSanPhamViewModel> listTable = new ArrayList<>();
        for (ChiTietSanPhamModel c : listAll) {
            listTable.add(new ChiTietSanPhamViewModel(c.getId(), c.getMa(), c.getMaVach(), c.getMoTa(), c.getSoLuong(), c.getIdSP(), c.getIdTH(), c.getIdLA(), c.getIdKC(), c.getIdMS(), c.getIdCL(), c.getGiaNhap(), c.getGiaBan(), c.isTrangThai()));
        }
        return listTable;
    }

    @Override
    public String getupdate(CTSPViewModel ctsp, int id) {

        CTSPModel model = new CTSPModel(ctsp.getId(), ctsp.getMa(), ctsp.getMaVach(), ctsp.getMoTa(), ctsp.getSoLuong(), ctsp.getIdSP(), ctsp.getIdTH(), ctsp.getIdLA(), ctsp.getIdKC(), ctsp.getIdMS(), ctsp.getIdCL(), ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.isTrangThai());
        boolean Sua = cTSPRepository.getUpdate(model, id);
        if (Sua) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public List<ChiTietSanPhamViewModel> getSerch(String ten) {
          List<ChiTietSanPhamModel> listAll = tableRepo.getSerch(ten);
        List<ChiTietSanPhamViewModel> listTable = new ArrayList<>();
        for (ChiTietSanPhamModel c : listAll) {
            listTable.add(new ChiTietSanPhamViewModel(c.getId(), c.getMa(), c.getMaVach(), c.getMoTa(), c.getSoLuong(), c.getIdSP(), c.getIdTH(), c.getIdLA(), c.getIdKC(), c.getIdMS(), c.getIdCL(), c.getGiaNhap(), c.getGiaBan(), c.isTrangThai()));
        }
        return listTable;
    }

}
