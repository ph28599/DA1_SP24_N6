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
import model.HoaDonCTModel;
import ultility.DBConnect;

/**
 *
 * @author Admin
 */
public class HDCTRepository {
    public List<HoaDonCTModel> getAll() {
        String qery = "SELECT HDCT.ID,HDCT.ID_HD,HDCT.ID_SPCT, SP.TEN ,TH.TEN,LA.TEN,MS.TEN, CL.TEN , S.SIZE,HDCT.SOLUONG,HDCT.DONGIA \n"
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
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<HoaDonCTModel> listMS = new ArrayList<>();
            while (rs.next()) {
                HoaDonCTModel ms = new HoaDonCTModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(10), rs.getFloat(11));
                listMS.add(ms);
            }
            return listMS;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
    
}
