/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.CTSPViewModel;
import viewmodel.ChiTietSanPhamViewModel;

/**
 *
 * @author LAPTOP24H
 */
public interface ICTSPService {

    List<CTSPViewModel> getAll();

    List<ChiTietSanPhamViewModel> getAllTale();

    String add(CTSPViewModel ctsp);

    String getupdate(CTSPViewModel ctsp, int id);
}
