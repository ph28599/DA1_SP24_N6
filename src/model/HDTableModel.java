/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class HDTableModel {
    private int id;
    private String ma;
    private String tenNhanVien;
    private String tenKhachHang;
    private String pgg;
    private Date ngayTao;
    private Date ngayThanhToan;
    private int tienGiam;
    private int tongTien;
    private int tienKhachPhaiTra;
    private int tienKhachDua;
    private int tienThua;
    
    private int hinhThucThanhToan;
    private String maChuyenKhoan;
    private String trangThai;

    public HDTableModel() {
    }

    public HDTableModel(int id, String ma, String tenNhanVien, String tenKhachHang, String pgg, Date ngayTao, Date ngayThanhToan, int tienGiam, int tongTien, int tienKhachPhaiTra, int tienKhachDua, int tienThua, int hinhThucThanhToan, String maChuyenKhoan, String trangThai) {
        this.id = id;
        this.ma = ma;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.pgg = pgg;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tienGiam = tienGiam;
        this.tongTien = tongTien;
        this.tienKhachPhaiTra = tienKhachPhaiTra;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.maChuyenKhoan = maChuyenKhoan;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getPgg() {
        return pgg;
    }

    public void setPgg(String pgg) {
        this.pgg = pgg;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTienGiam() {
        return tienGiam;
    }

    public void setTienGiam(int tienGiam) {
        this.tienGiam = tienGiam;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTienKhachPhaiTra() {
        return tienKhachPhaiTra;
    }

    public void setTienKhachPhaiTra(int tienKhachPhaiTra) {
        this.tienKhachPhaiTra = tienKhachPhaiTra;
    }

    public int getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(int tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public int getTienThua() {
        return tienThua;
    }

    public void setTienThua(int tienThua) {
        this.tienThua = tienThua;
    }

    public int getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getMaChuyenKhoan() {
        return maChuyenKhoan;
    }

    public void setMaChuyenKhoan(String maChuyenKhoan) {
        this.maChuyenKhoan = maChuyenKhoan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
}
