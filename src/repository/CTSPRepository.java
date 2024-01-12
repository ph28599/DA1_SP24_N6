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
public class CTSPRepository {

    private DBConnection connection;

    public List<ChiTietSanPhamModel> getAll() {
        String sql = "SELECT dbo.SAN_PHAM_CHI_TIET.ID, dbo.SAN_PHAM_CHI_TIET.MA, dbo.SAN_PHAM_CHI_TIET.MAVACH, dbo.SAN_PHAM_CHI_TIET.MOTA, dbo.SAN_PHAM_CHI_TIET.SOLUONG, dbo.SAN_PHAM_CHI_TIET.ID_SP, \n"
                + "                  dbo.SAN_PHAM_CHI_TIET.ID_TH, dbo.SAN_PHAM_CHI_TIET.ID_LA, dbo.SAN_PHAM_CHI_TIET.ID_SIZE, dbo.SAN_PHAM_CHI_TIET.ID_MS, dbo.SAN_PHAM_CHI_TIET.ID_CL, dbo.SAN_PHAM_CHI_TIET.GIANHAP, \n"
                + "                  dbo.SAN_PHAM_CHI_TIET.GIABAN, dbo.SAN_PHAM_CHI_TIET.TRANGTHAI\n"
                + "FROM     dbo.CHAT_LIEU INNER JOIN\n"
                + "                  dbo.LOAI_AO ON dbo.CHAT_LIEU.ID = dbo.LOAI_AO.ID INNER JOIN\n"
                + "                  dbo.MAU_SAC ON dbo.CHAT_LIEU.ID = dbo.MAU_SAC.ID INNER JOIN\n"
                + "                  dbo.SAN_PHAM ON dbo.CHAT_LIEU.ID = dbo.SAN_PHAM.ID INNER JOIN\n"
                + "                  dbo.SAN_PHAM_CHI_TIET ON dbo.CHAT_LIEU.ID = dbo.SAN_PHAM_CHI_TIET.ID_CL AND dbo.LOAI_AO.ID = dbo.SAN_PHAM_CHI_TIET.ID_LA AND dbo.MAU_SAC.ID = dbo.SAN_PHAM_CHI_TIET.ID_MS AND \n"
                + "                  dbo.SAN_PHAM.ID = dbo.SAN_PHAM_CHI_TIET.ID_SP INNER JOIN\n"
                + "                  dbo.SIZE ON dbo.SAN_PHAM_CHI_TIET.ID_SIZE = dbo.SIZE.ID INNER JOIN\n"
                + "                  dbo.THUONG_HIEU ON dbo.SAN_PHAM_CHI_TIET.ID_TH = dbo.THUONG_HIEU.ID";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<ChiTietSanPhamModel> list = new ArrayList<>();
            while (rs.next()) {
                ChiTietSanPhamModel chatLieuModel = new ChiTietSanPhamModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getFloat(12), rs.getFloat(13), rs.getBoolean(14));
                list.add(chatLieuModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
