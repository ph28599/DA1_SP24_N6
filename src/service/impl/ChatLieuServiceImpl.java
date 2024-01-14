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

    @Override
    public String add(ChatLieuViewMoel cl) {
        ChatLieuModel model = new ChatLieuModel(cl.getId(), cl.getMa(), cl.getTen());
        boolean them = chatLieuViewMoel.getAdd(model);
        if (them) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ChatLieuViewMoel cl, int id) {
        ChatLieuModel model = new ChatLieuModel(cl.getId(), cl.getMa(), cl.getTen());
        boolean sua = chatLieuViewMoel.getUpđate(model, id);

        if (sua) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

}
