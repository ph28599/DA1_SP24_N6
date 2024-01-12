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

}
