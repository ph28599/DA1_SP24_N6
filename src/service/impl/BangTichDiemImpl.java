/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.BangTichDiem;
import repository.BangTichDiemRepository;
import service.BangTichDiemService;
import viewmodel.QLBangTichDiem;

/**
 *
 * @author pc
 */
public class BangTichDiemImpl implements BangTichDiemService{
    BangTichDiemRepository repository;
    
    public BangTichDiemImpl(){
        this.repository = new BangTichDiemRepository();
    }
    @Override
    public ArrayList<QLBangTichDiem> getList() {
        return repository.getListFromDB();
    }

    @Override
    public Boolean Them(BangTichDiem bangTichDiem) {
        return repository.Them(bangTichDiem);
    }

    @Override
    public Boolean Xoa(int id) {
        return repository.Xoa(id);
    }

    @Override
    public Boolean Sua(int id, BangTichDiem bangTichDiem) {
       return repository.Sua(id, bangTichDiem);
    }

    @Override
    public ArrayList<QLBangTichDiem> TimKiem(int idKH) {
        return repository.TimTheoIDKH(idKH);
    }

    @Override
    public Boolean getUpdateBangDiem(int id, QLBangTichDiem bangTichDiem) {
        return repository.updateBangDIem(id, bangTichDiem);
    }
    
}
