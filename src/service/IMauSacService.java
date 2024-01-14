/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.MauSacViewModel;

/**
 *
 * @author LAPTOP24H
 */
public interface IMauSacService {
    List<MauSacViewModel> getAll();
      String add(MauSacViewModel ms);
     String update(MauSacViewModel ms , int id);
}
