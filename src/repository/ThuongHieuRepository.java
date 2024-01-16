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
import model.ThuongHieuModel;

import ultility.DBConnection;

/**
 *
 * @author LAPTOP24H
 */
public class ThuongHieuRepository {
     private DBConnection connection;
     
       public List<ThuongHieuModel> getAll() {
        String sql = "SELECT ID, MA, TEN\n"
                + "FROM     dbo.THUONG_HIEU";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<ThuongHieuModel> list = new ArrayList<>();
            while (rs.next()) {
                ThuongHieuModel model = new ThuongHieuModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(model);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
       
           
    public boolean getAdd(ThuongHieuModel m) {
        int check = 0;
        String sql = "INSERT [dbo].[THUONG_HIEU] ( [MA], [TEN]) VALUES (?,?)";
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

    public boolean getUpđate(ThuongHieuModel m, int id) {
        int check = 0;
        String sql = """
                      UPDATE [dbo].[THUONG_HIEU]
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
