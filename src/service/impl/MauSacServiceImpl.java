/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.MauSacModel;
import repository.MauSacReoisitory;
import service.IMauSacService;
import viewmodel.MauSacViewModel;

/**
 *
 * @author LAPTOP24H
 */
public class MauSacServiceImpl implements IMauSacService {

    private MauSacReoisitory mauSacReoisitory = new MauSacReoisitory();

    @Override
    public List<MauSacViewModel> getAll() {
        List<MauSacModel> models = mauSacReoisitory.getAll();
        List<MauSacViewModel> viewModels = new ArrayList<>();
        for (MauSacModel model : models) {
            viewModels.add(new MauSacViewModel(model.getId(), model.getMa(), model.getTen()));
        }
        return viewModels;
    }

    @Override
    public String add(MauSacViewModel ms) {
         MauSacModel model = new MauSacModel(ms.getId(),ms.getMa(),ms.getTen());
        boolean them = mauSacReoisitory.getAdd(model);
         if (them) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
      }

    @Override
    public String update(MauSacViewModel ms, int id) {
        MauSacModel model = new MauSacModel(ms.getId(),ms.getMa(),ms.getTen());
        boolean them = mauSacReoisitory.getUpđate(model, id);
         if (them) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }  }

}
