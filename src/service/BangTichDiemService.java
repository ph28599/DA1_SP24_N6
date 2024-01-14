/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.BangTichDiem;
import viewmodel.QLBangTichDiem;

/**
 *
 * @author pc
 */
public interface BangTichDiemService {
    public ArrayList<QLBangTichDiem> getList();
    
    public  Boolean Them(BangTichDiem bangTichDiem);
    
    public Boolean Xoa(int id);
    
    public Boolean Sua(int id, BangTichDiem bangTichDiem);
    
    public ArrayList<QLBangTichDiem> TimKiem(int idKH);
    
    public Boolean getUpdateBangDiem(int id, QLBangTichDiem bangTichDiem);
    
}
