/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.ChatLieuModel;
import repository.ChatLieuRepository;
import service.IChatLieuService;
import viewmodel.ChatLieuViewMoel;


/**
 *
 * @author LAPTOP24H
 */
public class ChatLieuServiceImpl implements IChatLieuService {
 private ChatLieuRepository chatLieuViewMoel = new ChatLieuRepository();
    @Override
    public List<ChatLieuViewMoel> getAll() {
         List<ChatLieuModel> models = chatLieuViewMoel.getAll();
        List<ChatLieuViewMoel> viewModels = new ArrayList<>();
        for (ChatLieuModel model : models) {
            viewModels.add(new ChatLieuViewMoel(model.getId(), model.getMa(), model.getTen()));
        }
        return viewModels;
    }
    
}
