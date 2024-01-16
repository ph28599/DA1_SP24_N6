/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.NhanVien;
import ultility.DBConnection;
import viewmodel.QLNhanVien;

/**
 *
 * @author pc
 */
public class NhanVienRepository {

    DBConnection con;

    public ArrayList<QLNhanVien> getListFromDB() {
        ArrayList<QLNhanVien> list = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, GIOTINH, SDT, NGAYSINH, DIACHI, EMAIL, CHUCVU, TRANGTHAI from NHAN_VIEN";
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
        } catch (Exception ex) {

        }
        return list;
    }

    public Boolean Them(NhanVien nhanVien) {
        String sql = "insert into NHAN_VIEN(MA, HOTEN, GIOTINH, SDT, NGAYSINH, DIACHI, EMAIL, CHUCVU, TRANGTHAI)"
                + "values(?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, nhanVien.getMa());
            ps.setObject(2, nhanVien.getTen());
            ps.setObject(3, nhanVien.getGioiTinh());
            ps.setObject(4, nhanVien.getSdt());
            ps.setObject(5, nhanVien.getNgaySinh());
            ps.setObject(6, nhanVien.getDiaChi());
            ps.setObject(7, nhanVien.getEmail());
            ps.setObject(8, nhanVien.getChucVu());
            ps.setObject(9, nhanVien.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean Xoa(int id) {
        String sql = "Delete NHAN_VIEN where ID = ?";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean Sua(int id, NhanVien nhanVien) {
        String sql = "update NHAN_VIEN set MA =?, HOTEN=?, GIOTINH=?, SDT=?, NGAYSINH=?, DIACHI=?,"
                + " EMAIL =?, CHUCVU =?, TRANGTHAI =? where ID = ?";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, nhanVien.getMa());
            ps.setObject(2, nhanVien.getTen());
            ps.setObject(3, nhanVien.getGioiTinh());
            ps.setObject(4, nhanVien.getSdt());
            ps.setObject(5, nhanVien.getNgaySinh());
            ps.setObject(6, nhanVien.getDiaChi());
            ps.setObject(7, nhanVien.getEmail());
            ps.setObject(8, nhanVien.getChucVu());
            ps.setObject(9, nhanVien.getTrangThai());
            ps.setObject(10, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<QLNhanVien> TimKiemTheoMa(String name) {
        ArrayList<QLNhanVien> listNV = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, GIOTINH, SDT, NGAYSINH, DIACHI, EMAIL, CHUCVU, TRANGTHAI from NHAN_VIEN "
                + "where MA like '%" + name + "%'";
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
                listNV.add(nv);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

}
