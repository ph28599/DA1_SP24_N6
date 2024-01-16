/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class GioHangModel {
    private int id;
    private String maHD;
    private String tenSp;
    private int soLuong;
    private Float donGia;

    public GioHangModel() {
    }

    public GioHangModel(int id, String maHD, String tenSp, int soLuong, Float donGia) {
        this.id = id;
        this.maHD = maHD;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "GioHangModel{" + "id=" + id + ", maHD=" + maHD + ", tenSp=" + tenSp + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
    
}
