/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.SizeModel;
import repository.SizeRepository;
import service.ISizeService;
import viewmodel.SizeViewModel;

/**
 *
 * @author LAPTOP24H
 */
public class SizeServiceImpl implements ISizeService{
    private SizeRepository sizeRepository = new SizeRepository();

    @Override
    public List<SizeViewModel> getAll() {
           List<SizeModel> models = sizeRepository.getAll();
        List<SizeViewModel> viewModels = new ArrayList<>();
        for (SizeModel model : models) {
            viewModels.add(new SizeViewModel(model.getId(), model.getMa(), model.getTen()));
        }
        return viewModels;
    }
    
}
