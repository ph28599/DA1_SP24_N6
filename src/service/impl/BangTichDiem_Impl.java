/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.BangTichDiem;
import repository.BangTichDiem_Repository;
import service.BangTichDiem_Service;
import viewmodel.QLBangTichDiem;

/**
 *
 * @author pc
 */
public class BangTichDiem_Impl implements BangTichDiem_Service {

    private BangTichDiem_Repository bangTichDiem_Repository;

    public BangTichDiem_Impl() {
        this.bangTichDiem_Repository = new BangTichDiem_Repository();
    }

    @Override
    public ArrayList<QLBangTichDiem> getList() {
        return bangTichDiem_Repository.getListFromDB();
    }

    @Override
    public Boolean Them(BangTichDiem bangTichDiem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean Sua(int id, BangTichDiem bangTichDiem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<QLBangTichDiem> TimKiem(int idKH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean getUpdateBangDiem(int id, QLBangTichDiem bangTichDiem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
