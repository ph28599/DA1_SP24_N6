/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author pc
 */
public class QLBangTichDiem {
    int id, idKH;
   String  ma ;
   int diemTich, tienDuocGiam;
   
    public QLBangTichDiem() {
    }

    public QLBangTichDiem(int id, int idKH, String ma, int diemTich, int tienDuocGiam) {
        this.id = id;
        this.idKH = idKH;
        this.ma = ma;
        this.diemTich = diemTich;
        this.tienDuocGiam = tienDuocGiam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getDiemTich() {
        return diemTich;
    }

    public void setDiemTich(int diemTich) {
        this.diemTich = diemTich;
    }

    public int getTienDuocGiam() {
        return tienDuocGiam;
    }

    public void setTienDuocGiam(int tienDuocGiam) {
        this.tienDuocGiam = tienDuocGiam;
    }

    
}
