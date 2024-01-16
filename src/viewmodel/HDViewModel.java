/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HDViewModel {
    private int id;
    private String ma;
    private int idNV;
    private int idKH;
    private String PGG;
    private Date ngayTao;
    private Date ngayThanhToan;
    private int tienGiam;
    private int tongTien;
    private int tienKhachDua;
    private int tienThua;
    private int tienKhachPhaiTra;
    private int HinhThucThanhToan;
    private String maChuyenKhoan;
    private String trangThai;

    public HDViewModel() {
    }

    public HDViewModel(int id, String ma, int idNV, int idKH, String PGG, Date ngayTao, Date ngayThanhToan, int tienGiam, int tongTien, int tienKhachDua, int tienThua, int tienKhachPhaiTra, int HinhThucThanhToan, String maChuyenKhoan, String trangThai) {
        this.id = id;
        this.ma = ma;
        this.idNV = idNV;
        this.idKH = idKH;
        this.PGG = PGG;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tienGiam = tienGiam;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
        this.tienKhachPhaiTra = tienKhachPhaiTra;
        this.HinhThucThanhToan = HinhThucThanhToan;
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

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getPGG() {
        return PGG;
    }

    public void setPGG(String PGG) {
        this.PGG = PGG;
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

    public int getTienKhachPhaiTra() {
        return tienKhachPhaiTra;
    }

    public void setTienKhachPhaiTra(int tienKhachPhaiTra) {
        this.tienKhachPhaiTra = tienKhachPhaiTra;
    }

    public int getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int HinhThucThanhToan) {
        this.HinhThucThanhToan = HinhThucThanhToan;
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

    
    
    public Object[] toRowData(){
        return new Object[]{ma,ngayTao,idNV,idKH};
    }

    
    
}
