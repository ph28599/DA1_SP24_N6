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
import model.HoaDonModel;
import ultility.DBConnection;

/**
 *
 * @author Admin
 */
public class HDRepository {

    public List<HoaDonModel> getAll() {
        String qery = """
                   SELECT [ID]
                         ,[MA]
                         ,[ID_NV]
                         ,[ID_KH]
                         ,[MAPGG]
                         ,[NGAYTAO]
                         ,[NGAYTHANHTOAN]
                         ,[TIENGIAM]
                         ,[TONGTIEN]
                         ,[TIENKHACHPHAITRA]
                         ,[TIENKHACHDUA]
                         ,[TIENTHUA]                        
                         ,[HINHTHUCTHANHTOAN]
                         ,[MACHUYENKHOAN]
                         ,[TRANGTHAI]
                     FROM [dbo].[HOA_DON]
                    """;
        try (Connection con = DBConnection.getConnection(); PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<HoaDonModel> listLTT = new ArrayList<>();
            while (rs.next()) {
                HoaDonModel ltt = new HoaDonModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getString(14), rs.getInt(15));
                listLTT.add(ltt);
            }
            return listLTT;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean getAdd(HoaDonModel hd) {
        int check = 0;
        String qery = """
                  INSERT INTO [dbo].[HOA_DON] 
                      ([MA], [ID_NV], [ID_KH], [MAPGG], [NGAYTAO], [NGAYTHANHTOAN], [TIENGIAM], [TONGTIEN], [TIENKHACHDUA], [TIENTHUA], [TIENKHACHPHAITRA], [HINHTHUCTHANHTOAN], [MACHUYENKHOAN], [TRANGTHAI]) 
                  VALUES 
                      
                      (?, ?, ?, ?,?, ?, ?, ?,? , ?, ?, ?, ?, ?);
                    """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement pr = con.prepareStatement(qery)) {

            pr.setObject(1, hd.getMa());
            pr.setObject(2, hd.getIdNV());
            pr.setObject(3, hd.getIdKH());
            pr.setObject(4, hd.getPgg());
            pr.setObject(5, hd.getNgayTao());
            pr.setObject(6, hd.getNgayThanhToan());
            pr.setObject(7, hd.getTienGiam());
            pr.setObject(8, hd.getTongTien());
            pr.setObject(9, hd.getTienKhachDua());
            pr.setObject(10, hd.getTienThua());
            pr.setObject(11, hd.getTienKhachPhaiTra());
            pr.setObject(12, hd.getHinhThucThanhToan());
            pr.setObject(13, hd.getMaChuyenKhoan());
            pr.setObject(14, hd.getTrangThai());

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

}
