/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Admin
 */
public class HDCTViewModel {
    private int id;
    private int idHD;
    private int idSPCT;
    private int idTH;
    private int idLA;
    private int idMS;
    private int idCL;
    private int idS;
    private int soLuong;
    private Float donGia;

    public HDCTViewModel(int id, int idHD, int idSPCT, int idTH, Float donGia) {
        this.id = id;
        this.idHD = idHD;
        this.idSPCT = idSPCT;
        this.idTH = idTH;
        this.idLA = idLA;
        this.idMS = idMS;
        this.idCL = idCL;
        this.idS = idS;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HDCTViewModel() {
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

    public int getIdTH() {
        return idTH;
    }

    public void setIdTH(int idTH) {
        this.idTH = idTH;
    }

    public int getIdLA() {
        return idLA;
    }

    public void setIdLA(int idLA) {
        this.idLA = idLA;
    }

    public int getIdMS() {
        return idMS;
    }

    public void setIdMS(int idMS) {
        this.idMS = idMS;
    }

    public int getIdCL() {
        return idCL;
    }

    public void setIdCL(int idCL) {
        this.idCL = idCL;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
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
    public Object[] toRowData(){
        return new Object[]{idHD,idSPCT,idLA,idTH,idMS,idCL,idS ,soLuong,donGia};
    }
    
}
