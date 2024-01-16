/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonCTDomain;
import ultility.DBConnection;
import viewmodel.SanPhamHDViewModel;

/**
 *
 * @author Admin
 */
public class HoaDonCTRepository implements HoaDonCTRepo {

    @Override
    public List<HoaDonCTDomain> getall() {

        ArrayList<HoaDonCTDomain> hdct = new ArrayList<>();
        try {
            Connection cnn = DBConnection.getConnection();
            String sql = "SELECT HDCT.ID,HDCT.ID_HD,HDCT.ID_SPCT, SP.TEN ,TH.TEN,LA.TEN,MS.TEN, CL.TEN , S.SIZE,HDCT.SOLUONG,HDCT.DONGIA \n"
                    + "FROM HOA_DON_CT HDCT\n"
                    + "JOIN\n"
                    + "    SAN_PHAM_CHI_TIET SPCT ON HDCT.ID_SPCT = SPCT.ID\n"
                    + "JOIN\n"
                    + "    SAN_PHAM SP ON SPCT.ID_SP = SP.ID\n"
                    + "JOIN\n"
                    + "    THUONG_HIEU TH ON SPCT.ID_TH = TH.ID\n"
                    + "JOIN\n"
                    + "    LOAI_AO LA ON SPCT.ID_LA = LA.ID\n"
                    + "JOIN\n"
                    + "    MAU_SAC MS ON SPCT.ID_MS = MS.ID\n"
                    + "JOIN\n"
                    + "    CHAT_LIEU CL ON SPCT.ID_CL = CL.ID\n"
                    + "JOIN\n"
                    + "    SIZE S ON SPCT.ID_SIZE = S.ID";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                HoaDonCTDomain hdd = new HoaDonCTDomain(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4), rs.getInt(5), rs.getInt(6),rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
                hdct.add(hdd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hdct;
    }

    @Override
    public boolean add(HoaDonCTDomain ht) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(int id, HoaDonCTDomain ht) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPhamHDViewModel> getByHdId(int idHd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
