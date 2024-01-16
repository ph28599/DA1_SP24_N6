/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.time.LocalDate;

/**
 *
 * @author pc
 */
public class NhanVienVM {
    private int id;
    private String ma;
    private String hoTen;
    private int gioiTinh;
    private String sdt;
    private LocalDate ngaySinh;
    private String diaChi;
    private String email;
    private int chucVu;
    private String tenDN;
    private String matKhau;
    private int trangThai;

    public NhanVienVM() {
    }

    public NhanVienVM(int id, String ma, String hoTen, int gioiTinh, String sdt, LocalDate ngaySinh, String diaChi, String email, int chucVu, String tenDN, String matKhau, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.chucVu = chucVu;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getChucVu() {
        return chucVu;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
     public String getgt() {
        if (gioiTinh == 1) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }
    public String getcv() {
        if (chucVu == 1) {
            return "Nhân viên";
        } else {
            return "Quản lý";
        }
    }
    public String gettt() {
        if (trangThai == 1) {
            return "Làm việc";
        } else {
            return "Nghỉ việc";
        }
    }
    
}
