/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.HDTableModel;
import model.HoaDonDomain;
import repository.HDTableRepository;
import repository.HoaDonRepository;
import service.IHoaDonService;
import viewmodel.HDTableViewModel;
import viewmodel.HoaDonView;

/**
 *
 * @author Admin
 */
public class HoaDonService implements IHoaDonService {
    
    private HoaDonRepository rs = new HoaDonRepository();
    HDTableRepository HDRepo=new HDTableRepository();

    @Override
    public List<HoaDonView> getall() {
       List<viewmodel.HoaDonView> hdd = new ArrayList<>();
        List<HoaDonDomain> list = this.rs.getall();
        for (HoaDonDomain x : list) {
            HoaDonView hoaDonView = new HoaDonView(x.getId(), x.getMa(), x.getIdNV(), x.getIdKH(), x.getPgg(), x.getNgayTao(), x.getNgayThanhToan(), x.getTienGiam(), x.getTongTien(),x.getTienKhachPhaiTra(), x.getTienKhachDua(), x.getTienThua(), x.getHinhThucThanhToan(), x.getMaChuyenKhoan(),x.getTrangThai());
            hdd.add(hoaDonView);
        }
        return hdd;}

    @Override
    public boolean add(HoaDonView hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(int id, HoaDonView hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id_hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonView findById(String ma) {
     HoaDonDomain x = rs.findByMa(ma);
        HoaDonView hoaDonView = new HoaDonView(x.getId(), x.getMa(), x.getIdNV(), x.getIdKH(), x.getPgg(), x.getNgayTao(), x.getNgayThanhToan(), x.getTienGiam(), x.getTongTien(), x.getTienKhachPhaiTra(), x.getTienKhachDua(), x.getTienThua(), x.getHinhThucThanhToan(), x.getMaChuyenKhoan(), x.getTrangThai());
        return hoaDonView; }

    

    @Override
    public List<HDTableViewModel> getAllTable() {
        List<HDTableModel> getAll=HDRepo.getAll();
        List<HDTableViewModel> getTable=new ArrayList<>();
        for (HDTableModel hd : getAll) {
            getTable.add(new HDTableViewModel(hd.getId(),hd.getMa(),hd.getTenNhanVien(), hd.getTenKhachHang(),hd.getPgg(),hd.getNgayTao(),hd.getNgayThanhToan(),hd.getTienGiam(),hd.getTongTien(),hd.getTienKhachDua(),hd.getTienThua(),hd.getTienKhachPhaiTra(),hd.getHinhThucThanhToan(),hd.getMaChuyenKhoan(),hd.getTrangThai()));
        }
        return getTable;}

    @Override
    public List<HoaDonView> searchByDate(Date start, Date end, int type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
