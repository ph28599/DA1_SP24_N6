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
import model.SanPhamModel;
import ultility.DBConnection;

/**
 *
 * @author LAPTOP24H
 */
public class SanPhamRepository {

    private DBConnection connection;

    public List<SanPhamModel> getAll() {
        String sql = "SELECT ID, MA, TEN, LOAISANPHAM, SOLUONG\n"
                + "FROM     dbo.SAN_PHAM";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<SanPhamModel> listSP = new ArrayList<>();
            while (rs.next()) {
                SanPhamModel sanPhamModel = new SanPhamModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                listSP.add(sanPhamModel);
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean getAdd(SanPhamModel m) {
        int check = 0;
        String sql = "INSERT [dbo].[SAN_PHAM] ( [MA], [TEN] , [LOAISANPHAM], [SOLUONG]) VALUES (?,?,?,?)";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, m.getMa());
            ps.setObject(2, m.getTen());
            ps.setObject(3, m.getLoaiSanPham());
            ps.setObject(4, m.getSoLuong());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean getUpđate(SanPhamModel m, int id) {
        int check = 0;
        String sql = """
                      UPDATE [dbo].[SAN_PHAM]
                                  SET [MA] = ?
                                 ,[TEN] =?
                                 ,[LOAISANPHAM]= ?
                                 ,[SOLUONG] = ?
                                  WHERE id=?
                     """;
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, m.getMa());
            ps.setObject(2, m.getTen());
            ps.setObject(3, m.getLoaiSanPham());
            ps.setObject(4, m.getSoLuong());
            ps.setObject(5, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        
    }

}
