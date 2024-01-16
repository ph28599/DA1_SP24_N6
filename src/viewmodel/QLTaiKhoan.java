/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author pc
 */
public class QLTaiKhoan {
    private int id;
    private int idNV;
    private String taiKhoan;
    private String matKhau;

    public QLTaiKhoan() {
    }

    public QLTaiKhoan(int id, int idNV, String taiKhoan, String matKhau) {
        this.id = id;
        this.idNV = idNV;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
    
}
