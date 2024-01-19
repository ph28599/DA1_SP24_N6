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
import model.HoaDonModel;
import ultility.DBConnection;

/**
 *
 * @author Admin
 */
public class HDRepository {
    public List<HoaDonModel> getAll() {
        String qery = """
                   SELECT [ID]
                         ,[MA]
                         ,[ID_NV]
                         ,[ID_KH]
                         ,[MAPGG]
                         ,[NGAYTAO]
                         ,[NGAYTHANHTOAN]
                         ,[TIENGIAM]
                         ,[TONGTIEN]
                       ,[TIENKHACHPHAITRA]
                         ,[TIENKHACHDUA]
                         ,[TIENTHUA]
                        
                         ,[HINHTHUCTHANHTOAN]
                         ,[MACHUYENKHOAN]
                         ,[TRANGTHAI]
                     FROM [dbo].[HOA_DON]
                    """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<HoaDonModel> listLTT = new ArrayList<>();
            while (rs.next()) {
                HoaDonModel ltt = new HoaDonModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getString(14),rs.getString(15));
                listLTT.add(ltt);
            }
            return listLTT;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
    
}
