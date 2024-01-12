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

    private Integer id;
    private String ma;
    private String maVach;
    private String moTa;
    private Integer soLuong;
    private Integer idSP;
    private Integer idTH;
    private Integer idLA;
    private Integer idKC;
    private Integer idMS;
    private Integer idCL;
    private float giaNhap;
    private float giaBan;
    private boolean trangThai;

    public ChiTietSanPhamViewModel() {
    }

    public ChiTietSanPhamViewModel(Integer id, String ma, String maVach, String moTa, Integer soLuong, Integer idSP, Integer idTH, Integer idLA, Integer idKC, Integer idMS, Integer idCL, float giaNhap, float giaBan, boolean trangThai) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getIdSP() {
        return idSP;
    }

    public void setIdSP(Integer idSP) {
        this.idSP = idSP;
    }

    public Integer getIdTH() {
        return idTH;
    }

    public void setIdTH(Integer idTH) {
        this.idTH = idTH;
    }

    public Integer getIdLA() {
        return idLA;
    }

    public void setIdLA(Integer idLA) {
        this.idLA = idLA;
    }

    public Integer getIdKC() {
        return idKC;
    }

    public void setIdKC(Integer idKC) {
        this.idKC = idKC;
    }

    public Integer getIdMS() {
        return idMS;
    }

    public void setIdMS(Integer idMS) {
        this.idMS = idMS;
    }

    public Integer getIdCL() {
        return idCL;
    }

    public void setIdCL(Integer idCL) {
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
    
     public Object[] toDataRow() {
        return new Object[]{id, ma, maVach, moTa, soLuong, idSP, idTH, idLA, idKC, idMS, idCL, giaNhap, giaBan,trangThai};
    }
}
