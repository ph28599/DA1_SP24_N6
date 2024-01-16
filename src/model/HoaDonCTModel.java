/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class HoaDonCTModel {
    
    private int id;
    private int idHD;
    private int idSPCT;
    private int soLuong;
    private Float donGia;

    public HoaDonCTModel() {
    }

    public HoaDonCTModel(int id, int idHD, int idSPCT, int soLuong, Float donGia) {
        this.id = id;
        this.idHD = idHD;
        this.idSPCT = idSPCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(int idSPCT) {
        this.idSPCT = idSPCT;
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
        return "HoaDonCTModel{" + "id=" + id + ", idHD=" + idHD + ", idSPCT=" + idSPCT + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
}
