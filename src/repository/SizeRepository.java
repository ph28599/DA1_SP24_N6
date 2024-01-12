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
import model.SizeModel;
import ultility.DBConnection;
import viewmodel.SizeViewModel;

/**
 *
 * @author LAPTOP24H
 */
public class SizeRepository {
    
    private DBConnection connection;

    public List<SizeModel> getAll() {
        String sql = "SELECT ID, MA, TEN\n"
                + "FROM     dbo.CHAT_LIEU";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<SizeModel> list = new ArrayList<>();
            while (rs.next()) {
                SizeModel model = new SizeModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(model);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
