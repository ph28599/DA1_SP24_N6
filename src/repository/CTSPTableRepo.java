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
import model.ChiTietSanPhamModel;
import ultility.DBConnection;

/**
 *
 * @author LAPTOP24H
 */
public class CTSPTableRepo {

    private DBConnection connection;

    public List<ChiTietSanPhamModel> getAllTable() {
        String sql = """
                     SELECT dbo.SAN_PHAM_CHI_TIET.ID, dbo.SAN_PHAM_CHI_TIET.MA, dbo.SAN_PHAM_CHI_TIET.MAVACH, dbo.SAN_PHAM_CHI_TIET.MOTA, dbo.SAN_PHAM_CHI_TIET.SOLUONG, dbo.SAN_PHAM.TEN, 
                                                                              THUONG_HIEU.TEN,LOAI_AO.TEN, SIZE.SIZE, MAU_SAC.TEN, CHAT_LIEU.TEN, dbo.SAN_PHAM_CHI_TIET.GIANHAP, 
                                                                              dbo.SAN_PHAM_CHI_TIET.GIABAN, dbo.SAN_PHAM_CHI_TIET.TRANGTHAI
                                                            FROM     dbo.SAN_PHAM_CHI_TIET INNER JOIN
                                                                              dbo.SAN_PHAM ON dbo.SAN_PHAM_CHI_TIET.ID_SP = dbo.SAN_PHAM.ID INNER JOIN
                                                                              dbo.THUONG_HIEU ON dbo.SAN_PHAM_CHI_TIET.ID_TH = dbo.THUONG_HIEU.ID INNER JOIN
                                                                              dbo.LOAI_AO ON dbo.SAN_PHAM_CHI_TIET.ID_LA = dbo.LOAI_AO.ID INNER JOIN
                                                                              dbo.SIZE ON dbo.SAN_PHAM_CHI_TIET.ID_SIZE = dbo.SIZE.ID INNER JOIN
                                                                              dbo.MAU_SAC ON dbo.SAN_PHAM_CHI_TIET.ID_MS = dbo.MAU_SAC.ID INNER JOIN
                                                                              dbo.CHAT_LIEU ON dbo.SAN_PHAM_CHI_TIET.ID_CL = dbo.CHAT_LIEU.ID
                     """;
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<ChiTietSanPhamModel> list = new ArrayList<>();
            while (rs.next()) {
                ChiTietSanPhamModel chatLieuModel = new ChiTietSanPhamModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getFloat(12), rs.getFloat(13), rs.getBoolean(14));
                list.add(chatLieuModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        
    }
}
