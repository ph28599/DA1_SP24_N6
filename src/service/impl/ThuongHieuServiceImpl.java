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

    @Override
    public String getAdd(ThuongHieuViewModel th) {
       ThuongHieuModel model = new ThuongHieuModel(th.getId(),th.getMa(),th.getTen());
        boolean them = hieuRepository.getAdd(model);
         if (them) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }  }

    @Override
    public String getUpdate(ThuongHieuViewModel th, Integer id) {
        ThuongHieuModel model = new ThuongHieuModel(th.getId(),th.getMa(),th.getTen());
        boolean them = hieuRepository.getUpđate(model,id);
         if (them) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }   }
}
