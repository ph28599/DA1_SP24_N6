/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.SanPhamViewModel;
import viewmodel.SizeViewModel;

/**
 *
 * @author LAPTOP24H
 */
public interface ISizeService {

    List<SizeViewModel> getAll();

    String getAdd(SizeViewModel s);

    String getUpdate(SizeViewModel s, Integer id);
}
