/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.LoaiAoModel;
import ultility.DBConnection;

/**
 *
 * @author LAPTOP24H
 */
public class LoaiAoRepository {
     private DBConnection connection;

    public List<LoaiAoModel> getAll() {
        String sql = "SELECT ID, MA, TEN\n"
                + "FROM     dbo.CHAT_LIEU";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<LoaiAoModel> list = new ArrayList<>();
            while (rs.next()) {
                LoaiAoModel loaiAoModel = new LoaiAoModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(loaiAoModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
