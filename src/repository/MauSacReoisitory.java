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
import model.MauSacModel;
import ultility.DBConnection;

/**
 *
 * @author LAPTOP24H
 */
public class MauSacReoisitory {

    private DBConnection connection;

    public List<MauSacModel> getAll() {
        String sql = "SELECT ID, MA, TEN\n"
                + "FROM     dbo.MAU_SAC";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<MauSacModel> list = new ArrayList<>();
            while (rs.next()) {
                MauSacModel mauSacModel = new MauSacModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(mauSacModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MauSacModel> getSearch(String ten) {
        String sql = """
                   select * from MAU_SAC 
                  where TEN like '%' + ? + '%'
                     """;
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            List<MauSacModel> list = new ArrayList<>();
            while (rs.next()) {
                MauSacModel mauSacModel = new MauSacModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(mauSacModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean getAdd(MauSacModel m) {
        int check = 0;
        String sql = "INSERT [dbo].[MAU_SAC] ( [MA], [TEN]) VALUES (?,?)";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, m.getMa());
            ps.setObject(2, m.getTen());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean getUpđate(MauSacModel m, int id) {
        int check = 0;
        String sql = """
                      UPDATE [dbo].[MAU_SAC]
                                  SET [MA] = ?
                                 ,[TEN] =?
                                  WHERE id=?
                     """;
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, m.getMa());
            ps.setObject(2, m.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
