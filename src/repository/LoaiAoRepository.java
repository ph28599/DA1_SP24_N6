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
                + "FROM     dbo.lOAI_AO";
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
    
    
    public boolean getAdd(LoaiAoModel cl) {
        int check = 0;
        String sql = "INSERT [dbo].[LOAI_AO] ( [MA], [TEN]) VALUES (?,?)";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, cl.getMa());
            ps.setObject(2, cl.getTen());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean getUpđate(LoaiAoModel cl, int id) {
        int check = 0;
        String sql = """
                      UPDATE [dbo].[LOAI_AO]
                                  SET [MA] = ?
                                 ,[TEN] =?
                                  WHERE id=?
                     """;
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, cl.getMa());
            ps.setObject(2, cl.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
   
}
