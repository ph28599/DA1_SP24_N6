/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.ChatLieuModel;
import model.LoaiAoModel;
import repository.LoaiAoRepository;
import service.ILoaiAoService;
import viewmodel.ChatLieuViewMoel;
import viewmodel.LoaiAoViewModel;

/**
 *
 * @author LAPTOP24H
 */
public class LoaiAoServiceImpl implements ILoaiAoService{
     private LoaiAoRepository aoRepository = new LoaiAoRepository();
    @Override
    public List<LoaiAoViewModel> getAll() {
         List<LoaiAoModel> models = aoRepository.getAll();
        List<LoaiAoViewModel> viewModels = new ArrayList<>();
        for (LoaiAoModel model : models) {
            viewModels.add(new LoaiAoViewModel(model.getId(), model.getMa(), model.getTen()));
        }
        return viewModels;
    }
    
}
