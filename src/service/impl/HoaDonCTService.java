/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.HoaDonCTDomain;
import repository.HoaDonCTRepository;
import service.IHoaDonCTService;
import viewmodel.HoaDonCTView;
import viewmodel.SanPhamHDViewModel;

/**
 *
 * @author Admin
 */
public class HoaDonCTService implements IHoaDonCTService {
    private HoaDonCTRepository rs = new HoaDonCTRepository();

    @Override
    public List<HoaDonCTView> getAll() {
        List<HoaDonCTView> hdc = new ArrayList<>();
        List<HoaDonCTDomain> list = this.rs.getall();
        for (HoaDonCTDomain x : list) {
            HoaDonCTView hoaDonCTView = new HoaDonCTView(x.getId(), x.getIdHD(), x.getIdSPCT(), x.getTen(), x.getIdTH(), x.getIdLA(), x.getIdMS(), x.getIdCL(), x.getIdS(), x.getSoLuong(), x.getDonGia());
            hdc.add(hoaDonCTView);
        }
        return hdc;
    }

    @Override
    public boolean add(HoaDonCTView hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(int id, HoaDonCTView hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPhamHDViewModel> getByHdId(int idHd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
