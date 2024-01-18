/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author LAPTOP24H
 */
public interface ISanPhamSevice {

    List<SanPhamViewModel> getAll();

    List<SanPhamViewModel> getSerch(String ten);

    String getAdd(SanPhamViewModel sp);

    String getUpdate(SanPhamViewModel sp, Integer id);

}
