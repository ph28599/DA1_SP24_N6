/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.HoaDonCTDomain;
import viewmodel.SanPhamHDViewModel;


/**
 *
 * @author Admin
 */
public interface HoaDonCTRepo {
    List<HoaDonCTDomain> getall();
    boolean add(HoaDonCTDomain ht);
    boolean update(int id, HoaDonCTDomain ht);
    boolean delete(int id);
    List<SanPhamHDViewModel> getByHdId(int idHd);
    
}
