/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author LAPTOP24H
 */
public class ChiTietSanPhamViewModel {

    private int id;
    private String ma;
    private String maVach;
    private String moTa;
    private int soLuong;
    private String idSP;
    private String idTH;
    private String idLA;
    private String idKC;
    private String idMS;
    private String idCL;
    private float giaNhap;
    private float giaBan;
    private boolean trangThai;

    public ChiTietSanPhamViewModel() {
    }

    public ChiTietSanPhamViewModel(int id, String ma, String maVach, String moTa, int soLuong, String idSP, String idTH, String idLA, String idKC, String idMS, String idCL, float giaNhap, float giaBan, boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.maVach = maVach;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.idSP = idSP;
        this.idTH = idTH;
        this.idLA = idLA;
        this.idKC = idKC;
        this.idMS = idMS;
        this.idCL = idCL;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
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

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdTH() {
        return idTH;
    }

    public void setIdTH(String idTH) {
        this.idTH = idTH;
    }

    public String getIdLA() {
        return idLA;
    }

    public void setIdLA(String idLA) {
        this.idLA = idLA;
    }

    public String getIdKC() {
        return idKC;
    }

    public void setIdKC(String idKC) {
        this.idKC = idKC;
    }

    public String getIdMS() {
        return idMS;
    }

    public void setIdMS(String idMS) {
        this.idMS = idMS;
    }

    public String getIdCL() {
        return idCL;
    }

    public void setIdCL(String idCL) {
        this.idCL = idCL;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String trangThai(boolean trangThai) {
        if (trangThai == true) {
            return "Còn Hàng";
        } else {

            return "Hết Hàng";
        }
    }

  
    
    
    
    public Object[] toDataRow() {
       
        return new Object[]{ma, maVach, moTa, soLuong, idSP , idTH, idLA, idKC, idMS, idCL, giaNhap, giaBan, trangThai(trangThai)};
    }
}
