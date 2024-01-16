/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Admin
 */
public class SanPhamHDViewModel {
    private int id;
    private String tenSP;
    private String thuongHieu;
    private String loaiAo;
    private String mauSac;
    private String chatLieu;
    private String size;
    private int soLuong;
    private int donGia;

    public SanPhamHDViewModel() {
    }

    public SanPhamHDViewModel(int id, String tenSP, String thuongHieu, String loaiAo, String mauSac, String chatLieu, String size, int soLuong, int donGia) {
        this.id = id;
        this.tenSP = tenSP;
        this.thuongHieu = thuongHieu;
        this.loaiAo = loaiAo;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.size = size;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getLoaiAo() {
        return loaiAo;
    }

    public void setLoaiAo(String loaiAo) {
        this.loaiAo = loaiAo;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
    
    
}
