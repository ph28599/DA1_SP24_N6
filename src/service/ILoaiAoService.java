/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.LoaiAoModel;
import viewmodel.LoaiAoViewModel;

/**
 *
 * @author LAPTOP24H
 */
public interface ILoaiAoService {

    List<LoaiAoViewModel> getAll();
    List<LoaiAoViewModel> getS(String ten);
    List<LoaiAoViewModel> getALLPage(int offset , int fetchSet);
    String add(LoaiAoViewModel la);

    String update(LoaiAoViewModel la, int id);
}
