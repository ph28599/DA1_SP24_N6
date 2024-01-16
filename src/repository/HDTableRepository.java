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
import model.HDTableModel;
import ultility.DBConnection;

/**
 *
 * @author Admin
 */
public class HDTableRepository {

    public List<HDTableModel> getAll() {
        String query = """
                        SELECT HOA_DON.[ID]
                                                                            ,HOA_DON.[MA]
                                                                            ,NHAN_VIEN.HOTEN
                                                                            ,KHACH_HANG.HOTEN
                                                                            ,PHIEU_GIAM_GIA_CHI_TIET.MA
                                                                            ,[NGAYTAO]
                                                                            ,[NGAYTHANHTOAN]
                                                                            ,[TIENGIAM]
                                                                            ,[TONGTIEN]
                                                                            ,[TIENKHACHPHAITRA]
                                                                            ,[TIENKHACHDUA]
                                                                            ,[TIENTHUA]
                                                                            
                                                                            ,[HINHTHUCTHANHTOAN]
                                                                            ,[MACHUYENKHOAN]
                                                                            ,HOA_DON.[TRANGTHAI]
                                                                        FROM [dbo].[HOA_DON]
                                                                        join KHACH_HANG on KHACH_HANG.ID=HOA_DON.ID_KH
                                                                        join NHAN_VIEN on NHAN_VIEN.ID=HOA_DON.ID_NV 
                                              						  join PHIEU_GIAM_GIA_CHI_TIET on PHIEU_GIAM_GIA_CHI_TIET.ID = HOA_DON.ID_PGG where HOA_DON.[TRANGTHAI]=0
                                                                     ORDER BY NGAYTHANHTOAN   ;
                     """;
        try (Connection con = DBConnection.getConnection(); 
            PreparedStatement pr = con.prepareStatement(query)) {
            ResultSet rs = pr.executeQuery();
            List<HDTableModel> listKC = new ArrayList<>();
            while (rs.next()) {
                HDTableModel kc = new HDTableModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getString(14), rs.getString(15));
                listKC.add(kc);
            }
            return listKC;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
}