/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.HoaDonCTView;
import viewmodel.SanPhamHDViewModel;

/**
 *
 * @author Admin
 */
public interface IHoaDonCTService {
    List<HoaDonCTView> getAll();
    boolean add(HoaDonCTView hd);
    boolean update(int id, HoaDonCTView hd);
    boolean delete(int id);
    List<SanPhamHDViewModel> getByHdId(int idHd);
}
