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
import model.ChatLieuModel;

import ultility.DBConnection;
import viewmodel.ChatLieuViewMoel;

/**
 *
 * @author LAPTOP24H
 */
public class ChatLieuRepository {

    private DBConnection connection;

    public List<ChatLieuModel> getAll() {
        String sql = "SELECT ID, MA, TEN\n"
                + "FROM     dbo.CHAT_LIEU";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<ChatLieuModel> list = new ArrayList<>();
            while (rs.next()) {
                ChatLieuModel chatLieuModel = new ChatLieuModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(chatLieuModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
