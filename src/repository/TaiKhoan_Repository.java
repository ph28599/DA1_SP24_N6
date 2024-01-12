/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import ultility.DBConnection;
import viewmodel.QLTaiKhoan;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author pc
 */
public class TaiKhoan_Repository {
    DBConnection con;
    
    public ArrayList<QLTaiKhoan> getListFromDB(){
        ArrayList<QLTaiKhoan> list = new ArrayList<>();
        String sql ="select ID, ID_NV, TENDANGNHAP, MATKHAU from TAI_KHOAN";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                QLTaiKhoan tk = new QLTaiKhoan();
                tk.setId(rs.getInt(1));
                tk.setIdNV(rs.getInt(2));
                tk.setTaiKhoan(rs.getString(3));
                tk.setMatKhau(rs.getString(4));
                list.add(tk);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
