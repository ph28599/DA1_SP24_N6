/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import repository.NhanVienVMRepository;
import repository.NhanVien_Repository;
import viewmodel.NhanVienVM;

/**
 *
 * @author pc
 */
public class NhanVienVMService {
    private final NhanVienVMRepository nhanVienVM_Repository;
    
    public NhanVienVMService() {
        this.nhanVienVM_Repository = new NhanVienVMRepository();
    }
    
    public List<NhanVienVM> getAllNVVM() {
        return nhanVienVM_Repository.getAllNVVM();
    }
    public List<NhanVienVM> getAllNVByTrangThai() {
        return nhanVienVM_Repository.getAllNVByTrangThai();
    }

    public Integer addNhanVienVM(NhanVienVM nvvm) {
        return nhanVienVM_Repository.addNhanVienVM(nvvm);
    }
    public Integer updateNhanVienVM(NhanVienVM nvvm) {
        return nhanVienVM_Repository.updateNhanVienVM(nvvm);
    }

    public List<NhanVienVM> timKiemByTen(String tennv) {
        return nhanVienVM_Repository.timKiemByTen(tennv);
    }

    public Integer voHieuHoaNhanVienVM(NhanVienVM nvvm) {
        return nhanVienVM_Repository.voHieuHoaNhanVienVM(nvvm);
    }
    
    public List<NhanVienVM> locChucVu(int chucvu) {
        return nhanVienVM_Repository.locChucVu(chucvu);
    }

    public List<NhanVienVM> locTrangThai(int trangThai) {
        return nhanVienVM_Repository.locTrangThai(trangThai);
    }
      public List<NhanVienVM> locNhanVien(int chucVu, int trangThai) {
          return nhanVienVM_Repository.locNhanVien(chucVu, trangThai);
      }
    
}
