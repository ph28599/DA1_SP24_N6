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
import model.CTSPModel;
import model.SanPhamModel;
import ultility.DBConnection;

/**
 *
 * @author LAPTOP24H
 */
public class CTSPRepository {

    private DBConnection connection;

    public List<CTSPModel> getAll() {
        String sql = "SELECT ID, MA, MAVACH, MOTA, SOLUONG, ID_SP, ID_TH, ID_LA, ID_SIZE, ID_MS, ID_CL, GIANHAP, GIABAN, TRANGTHAI\n"
                + "FROM     dbo.SAN_PHAM_CHI_TIET";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<CTSPModel> list = new ArrayList<>();
            while (rs.next()) {
                //CTSPModel model = new CTSPModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getFloat(12), rs.getFloat(13), rs.getBoolean(14));
                //list.add(model);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean getAdd(CTSPModel ctsp) {
        int check = 0;
        String sql = """
                    INSERT INTO [dbo].[SAN_PHAM_CHI_TIET]
                               ([MA]
                               ,[MAVACH]
                               ,[MOTA]
                               ,[SOLUONG]
                               ,[ID_SP]
                               ,[ID_TH]
                               ,[ID_LA]
                               ,[ID_SIZE]
                               ,[ID_MS]
                               ,[ID_CL]
                               ,[GIANHAP]
                               ,[GIABAN]
                               ,[TRANGTHAI])
                         VALUES
                               (?,?,?,?,?,?,?,?,?,?,?,?,?)
                    """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement pr = con.prepareStatement(sql)) {

            pr.setObject(1, ctsp.getMa());
            pr.setObject(2, ctsp.getMaVach());
            pr.setObject(3, ctsp.getMoTa());
            pr.setObject(4, ctsp.getSoLuong());
            pr.setObject(5, ctsp.getIdSP());
            pr.setObject(6, ctsp.getIdTH());
            pr.setObject(7, ctsp.getIdLA());
            pr.setObject(8, ctsp.getIdKC());
            pr.setObject(9, ctsp.getIdMS());
            pr.setObject(10, ctsp.getIdCL());
            pr.setObject(11, ctsp.getGiaNhap());
            pr.setObject(12, ctsp.getGiaBan());
            pr.setObject(13, ctsp.isTrangThai());

            check = pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean getUpdate(CTSPModel ctsp, int id) {
        int check = 0;
        String sql = """
                    UPDATE [dbo].[SAN_PHAM_CHI_TIET]
                             SET  [MA] = ?
                               ,[MAVACH] = ?
                               ,[MOTA] = ?
                               ,[SOLUONG] = ?
                               ,[ID_SP] = ?
                               ,[ID_TH] = ?
                               ,[ID_LA] = ?
                               ,[ID_SIZE] = ?
                               ,[ID_MS] = ?
                               ,[ID_CL] = ?
                               ,[GIANHAP] = ?
                               ,[GIABAN] = ?
                               ,[TRANGTHAI] = ?
                         
                              WHERE id=?
                    """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement pr = con.prepareStatement(sql)) {

            pr.setObject(1, ctsp.getMa());
            pr.setObject(2, ctsp.getMaVach());
            pr.setObject(3, ctsp.getMoTa());
            pr.setObject(4, ctsp.getSoLuong());
            pr.setObject(5, ctsp.getIdSP());
            pr.setObject(6, ctsp.getIdTH());
            pr.setObject(7, ctsp.getIdLA());
            pr.setObject(8, ctsp.getIdKC());
            pr.setObject(9, ctsp.getIdMS());
            pr.setObject(10, ctsp.getIdCL());
            pr.setObject(11, ctsp.getGiaNhap());
            pr.setObject(12, ctsp.getGiaBan());
            pr.setObject(13, ctsp.isTrangThai());
            pr.setObject(14, id);

            check = pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
