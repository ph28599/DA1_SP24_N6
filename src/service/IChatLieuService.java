/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ChatLieuModel;
import viewmodel.ChatLieuViewMoel;

/**
 *
 * @author LAPTOP24H
 */
public interface IChatLieuService {

    List<ChatLieuViewMoel> getAll();

    String add(ChatLieuViewMoel cl);

    String update(ChatLieuViewMoel cl, int id);
}
