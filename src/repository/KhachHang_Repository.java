/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ultility.DBConnection;
import viewmodel.QLKhachHang;
import viewmodel.QLNhanVien;

/**
 *
 * @author pc
 */
public class KhachHang_Repository {
    DBConnection con;
    
    public ArrayList<QLKhachHang> getListFromDB(){
        ArrayList<QLKhachHang> list= new ArrayList<>();
        String sql = "select ID, MA, HOTEN, EMAIL, SDT, GIOTINH, NGAYSINH, DIACHI, TRANGTHAI from KHACH_HANG";
           try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLKhachHang kh = new QLKhachHang();
                kh.setId(rs.getInt(1));
                kh.setMa(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setEmail(rs.getString(4));
                kh.setSdt(rs.getString(5));
                kh.setGioiTinh(rs.getInt(6));
                kh.setNgaySinh(rs.getDate(7));
                kh.setDiaChi(rs.getString(8));
                kh.setTrangThai(rs.getInt(9));
                list.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
           return list;
    }
    
}
