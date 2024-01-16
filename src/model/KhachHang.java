/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
<<<<<<< HEAD
 * @author ngochieu
 */
public class KhachHang {
    private int id;
    private String ma;
    private String ten;
    private String email;
    private String sdt;
    private int gioiTinh;
    private Date ngaySinh;
=======
 * @author pc
 */
public class KhachHang {

    private int id;
    private String ma, ten, email, sdt;
    private int gioiTinh;
<<<<<<< HEAD
    private Date ngaySinh;
=======
    private Date  ngaySinh;
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
>>>>>>> fce514accff1888c4939d58f1ddf4a353b6cc771
    private String diaChi;
    private int trangThai;

    public KhachHang() {
    }

    public KhachHang(int id, String ma, String ten, String email, String sdt, int gioiTinh, Date ngaySinh, String diaChi, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
<<<<<<< HEAD

=======
    
<<<<<<< HEAD
    
    
=======
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
>>>>>>> fce514accff1888c4939d58f1ddf4a353b6cc771
}
