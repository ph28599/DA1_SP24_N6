/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.PGGModel;
import model.PhieuGiamGiaCT;
import repository.PhieuGiamGiaCTRepository;

/**
 *
 * @author pc
 */
public class PhieuGiamGiaCTService {
    private final PhieuGiamGiaCTRepository phieuGiamGiaCTRepo;

    public PhieuGiamGiaCTService() {
        this.phieuGiamGiaCTRepo = new PhieuGiamGiaCTRepository();
    }
    
     public List<PhieuGiamGiaCT> getAllPGGCT() {
        return phieuGiamGiaCTRepo.getAllPGGCT();
    }

    public Integer addPGGCT(PhieuGiamGiaCT pggct) {
       return  phieuGiamGiaCTRepo.addPGGCT(pggct);
    }

    public Integer updatePGGCT(PhieuGiamGiaCT pggct) {
      return  phieuGiamGiaCTRepo.updatePGGCT(pggct);
    }

    public Integer deletePGGCT(String PhieuGiamGiaCT_ID) {
        return phieuGiamGiaCTRepo.deletePGGCT(PhieuGiamGiaCT_ID);
    }
    public  List<PhieuGiamGiaCT> getByMa(String ma) {
        return phieuGiamGiaCTRepo.getByMa(ma);
    }
    public  List<PhieuGiamGiaCT> getByGiaTri(String giaTri) {
        return phieuGiamGiaCTRepo.getByGiaTri(giaTri);
    }
    public List<PGGModel> getByMaPGGHD() {
        return phieuGiamGiaCTRepo.getLayMaGGHD();
    } 
    public String getUpdateSoLuongPGGKhiTT(int id){
        boolean update=phieuGiamGiaCTRepo.getUpdateSoLuongPGGKhiTT(id);
        if(update){
            return "Thanh cong";
        }else {
            return "That bai";
        }
    }
    
}
