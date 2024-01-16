/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ultility.DBConnection;
import viewmodel.QLBangTichDiem;

/**
 *
 * @author pc
 */
public class BangTichDiem_Repository {
    public ArrayList<QLBangTichDiem> getListFromDB(){
        ArrayList<QLBangTichDiem> list = new ArrayList<>();
        String sql = "select ID, ID_KH, MA, DIEMTICH, TIENDUOCGIAN from BANG_TICH_DIEM";
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLBangTichDiem bt = new QLBangTichDiem();
                bt.setId(rs.getInt(1));
                bt.setIdKH(rs.getInt(2));
                bt.setMa(rs.getString(3));
                bt.setDiemTich(rs.getInt(4));
                bt.setTienDuocGiam(rs.getInt(5));
                list.add(bt);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
