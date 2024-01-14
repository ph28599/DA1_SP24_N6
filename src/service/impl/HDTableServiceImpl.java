/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.HDTableModel;
import repository.HDTableRepository;
import service.HDTableService;
import viewmodel.HDTableViewModel;

/**
 *
 * @author Admin
 */
public class HDTableServiceImpl implements HDTableService {
    HDTableRepository HDRepo=new HDTableRepository();

    @Override
    public List<HDTableViewModel> getAll() {
        List<HDTableModel> _getAll=HDRepo.getAll();
        List<HDTableViewModel> getTable=new ArrayList<>();
        for (HDTableModel hd : _getAll) {
            getTable.add(new HDTableViewModel(hd.getId(),hd.getMa(),hd.getTenNhanVien(), hd.getTenKhachHang(),hd.getPgg(),hd.getNgayTao(),hd.getNgayThanhToan(),hd.getTienGiam(),hd.getTongTien(),hd.getTienKhachDua(),hd.getTienThua(),hd.getTienKhachPhaiTra(),hd.getHinhThucThanhToan(),hd.getMaChuyenKhoan(),hd.getTrangThai()));
        }
        return getTable;
    }
    
}
