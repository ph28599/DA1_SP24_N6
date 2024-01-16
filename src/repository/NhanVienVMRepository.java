/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ultility.DBConnection;
import ultility.JDBCHelper;
import viewmodel.NhanVienVM;

/**
 *
 * @author pc
 */
public class NhanVienVMRepository {

    private List<NhanVienVM> getNhanVienFromResultSet(ResultSet rs) {
        List<NhanVienVM> lst = new ArrayList<>();
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String hoTen = rs.getString(2);
                int gioiTinh = rs.getInt(3);
                String sdt = rs.getString(4);
                LocalDate ngaySinh = null;
                java.sql.Date ngaysinhDate = rs.getDate(5);
                if (ngaysinhDate != null) {
                    ngaySinh = ngaysinhDate.toLocalDate();
                }
                String diaChi = rs.getString(6);
                String email = rs.getString(7);
                int chucVu = rs.getInt(8);
                String tenDN = rs.getString(9);
                String matKhau = rs.getString(10);
                int trangThai = rs.getInt(10);
                lst.add(new NhanVienVM(chucVu, ma, hoTen, gioiTinh, sdt, ngaySinh, diaChi, email, chucVu, tenDN, matKhau, trangThai));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    public List<NhanVienVM> getAllNVVM() {
        String sql = "select nv.MA,nv.HOTEN,nv.GIOTINH,nv.SDT,nv.NGAYSINH,nv.DIACHI,nv.EMAIL,nv.CHUVU,tk.TENDANGNHAP,tk.MATKHAU,nv.TRANGTHAI from NHAN_VIEN nv  join TAI_KHOAN tk on nv.ID = tk.ID_NV";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getNhanVienFromResultSet(rs);
    }
    public List<NhanVienVM> getAllNVByTrangThai() {
        String sql = "select nv.MA,nv.HOTEN,nv.GIOTINH,nv.SDT,nv.NGAYSINH,nv.DIACHI,nv.EMAIL,nv.CHUVU,tk.TENDANGNHAP,tk.MATKHAU,nv.TRANGTHAI from NHAN_VIEN nv  join TAI_KHOAN tk on nv.ID = tk.ID_NV where nv.TRANGTHAI = 1";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getNhanVienFromResultSet(rs);
    }


    public Integer addNhanVienVM(NhanVienVM nvvm) {
        String sql = "BEGIN TRANSACTION;\n"
                + "DECLARE @NhanVienID INT;\n"
                + "INSERT INTO NHAN_VIEN (MA, HOTEN, GIOTINH,SDT,NGAYSINH,DIACHI,EMAIL,CHUVU,TRANGTHAI) VALUES (?, ?, ?,?,?,\n"
                + "?,?,?,?,?);\n"
                + "SET @NhanVienID = SCOPE_IDENTITY();\n"
                + "INSERT INTO TAI_KHOAN (ID_NV, TENDANGNHAP, MATKHAU) VALUES (@NhanVienID, ?, ?);\n"
                + "COMMIT;";
        Integer row = JDBCHelper.excuteUpdate(sql, nvvm.getMa(), nvvm.getHoTen(), nvvm.getGioiTinh(), nvvm.getSdt(),
                nvvm.getNgaySinh(), nvvm.getDiaChi(), nvvm.getEmail(), nvvm.getChucVu(), nvvm.getTrangThai(), nvvm.getTenDN(), nvvm.getMatKhau());
        return row;
    }

    public Integer updateNhanVienVM(NhanVienVM nvvm) {
        String sql = "BEGIN TRANSACTION;\n"
                + "DECLARE @NhanVienID INT;\n"
                + "UPDATE NHAN_VIEN\n"
                + "SET HOTEN = ?, GIOTINH = ?,SDT = ?,CCCD = ?,NGAYSINH = ?,DIACHI=?,\n"
                + "EMAIL = ?,CHUVU = ?,TRANGTHAI=?\n"
                + "WHERE MA = ?;\n"
                + "SET @NhanVienID = (SELECT ID FROM NHAN_VIEN WHERE MA = ?);\n"
                + "UPDATE TAI_KHOAN\n"
                + "SET TENDANGNHAP = ?, MATKHAU = ?\n"
                + "WHERE ID_NV = @NhanVienID;\n"
                + "COMMIT;";

        Integer row = JDBCHelper.excuteUpdate(sql, nvvm.getHoTen(), nvvm.getGioiTinh(), nvvm.getSdt(),
                nvvm.getNgaySinh(), nvvm.getDiaChi(), nvvm.getEmail(), nvvm.getChucVu(), nvvm.getTrangThai(), nvvm.getMa(), nvvm.getMa(), nvvm.getTenDN(), nvvm.getMatKhau());
        return row;
    }

    public Integer voHieuHoaNhanVienVM(NhanVienVM nvvm) {
        String sql = "update NHAN_VIEN set  TRANGTHAI = ? where MA = ?";
        Integer row = JDBCHelper.excuteUpdate(sql, nvvm.getTrangThai(), nvvm.getMa());
        return row;
    }

    public List<NhanVienVM> timKiemByTen(String tennv) {
        String sql = " select*from NHAN_VIEN "
                + "where hoten like '%" + tennv + "%'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getNhanVienFromResultSet(rs);
    }
//

    public List<NhanVienVM> locChucVu(int chucvu) {
        String sql = "SELECT nv.MA, nv.HOTEN, nv.GIOTINH, nv.SDT, nv.NGAYSINH, nv.DIACHI, nv.EMAIL, nv.CHUVU, tk.TENDANGNHAP, tk.MATKHAU, nv.TRANGTHAI "
                + "FROM NHAN_VIEN nv JOIN TAI_KHOAN tk ON nv.ID = tk.ID_NV WHERE CHUVU = ?";
        try ( Connection connection = DBConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, chucvu);
            ResultSet rs = statement.executeQuery();
            return getNhanVienFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<NhanVienVM> locTrangThai(int trangThai) {
        String sql = "SELECT nv.MA, nv.HOTEN, nv.GIOTINH, nv.SDT, nv.NGAYSINH, nv.DIACHI, nv.EMAIL, nv.CHUVU, tk.TENDANGNHAP, tk.MATKHAU, nv.TRANGTHAI \n"
                + "                 FROM NHAN_VIEN nv JOIN TAI_KHOAN tk ON nv.ID = tk.ID_NV WHERE TRANGTHAI = ?";
        try ( Connection connection = DBConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, trangThai);
            ResultSet rs = statement.executeQuery();
            return getNhanVienFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<NhanVienVM> locNhanVien(int chucVu, int trangThai) {
        String sql = "SELECT nv.MA, nv.HOTEN, nv.GIOTINH, nv.SDT, nv.NGAYSINH, nv.DIACHI, nv.EMAIL, nv.CHUVU, tk.TENDANGNHAP, tk.MATKHAU, nv.TRANGTHAI\n"
                + "FROM NHAN_VIEN nv\n"
                + "JOIN TAI_KHOAN tk ON nv.ID = tk.ID_NV\n"
                + "WHERE nv.CHUVU = ? AND nv.TRANGTHAI = ?;";
        try ( Connection connection = DBConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, chucVu);
            statement.setInt(2, trangThai);
            ResultSet rs = statement.executeQuery();
            return getNhanVienFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
