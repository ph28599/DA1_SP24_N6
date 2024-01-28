/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.SPCTViewModel;
import viewmodel.SanPhamChiTietViewModel;

/**
 *
 * @author pc
 */
public interface SanPhamChiTietService {
    List<SanPhamChiTietViewModel> getAll();
    
    List<SPCTViewModel> getAllPhanTrang(int offset, int fetchSize);
    
    String getAdd(SanPhamChiTietViewModel spct);
    
    String getUpdate(SanPhamChiTietViewModel spct,int id);
    
    String getDelete(int id);
    
    List<SPCTViewModel> getAllTable();
    
    List<SPCTViewModel> getSearch(String ten , String ma);
    
    String getUpdateSoLuong(int soLuong,int id,int giaNhap);
    
    String getUpdateSLMua(int soLuong,int id);

    
}
