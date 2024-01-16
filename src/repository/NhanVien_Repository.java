/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.util.ArrayList;
import ultility.DBConnection;
import viewmodel.QLNhanVien;
import java.sql.*;

/**
 *
 * @author pc
 */
public class NhanVien_Repository {

    DBConnection con;

    public ArrayList<QLNhanVien> getListFromDB() {
        ArrayList<QLNhanVien> list = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, GIOTINH, SDT, NGAYSINH, DIACHI, EMAIL, CHUVU, TRANGTHAI from NHAN_VIEN";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien nv = new QLNhanVien();
                nv.setId(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setSdt(rs.getString(5));
                nv.setNgaySinh(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setEmail(rs.getString(8));
                nv.setChucVu(rs.getInt(9));
                nv.setTrangThai(rs.getInt(10));
                list.add(nv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }

}
