/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.SizeModel;
import model.ThuongHieuModel;
import repository.ThuongHieuRepository;
import service.IThuongHieuService;
import viewmodel.SizeViewModel;
import viewmodel.ThuongHieuViewModel;

/**
 *
 * @author LAPTOP24H
 */
public class ThuongHieuServiceImpl implements IThuongHieuService{
     private ThuongHieuRepository hieuRepository = new ThuongHieuRepository();

    @Override
    public List<ThuongHieuViewModel> getAll() {
          List<ThuongHieuModel> models = hieuRepository.getAll();
        List<ThuongHieuViewModel> viewModels = new ArrayList<>();
        for (ThuongHieuModel model : models) {
            viewModels.add(new ThuongHieuViewModel(model.getId(), model.getMa(), model.getTen()));
        }
        return viewModels;
    }
}
