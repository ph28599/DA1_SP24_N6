/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonDomain;
import ultility.DBConnect;

/**
 *
 * @author Admin
 */
public class HoaDonRepository implements HoaDonRepo{
    @Override
    public List<HoaDonDomain> getall() {
        ArrayList<HoaDonDomain> hd = new ArrayList<>();
        try {
            Connection cnn = DBConnect.getConnection();
            String sql =  """
                   SELECT [ID]
                         ,[MA]
                         ,[ID_NV]
                         ,[ID_KH]
                         ,[ID_PGG]
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
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                HoaDonDomain hdd = new HoaDonDomain(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
                         rs.getInt(12), rs.getInt(13),rs.getString(14),rs.getString(15));
                
               hd.add(hdd);
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

    @Override
    public HoaDonDomain findByMa(String ma) {
        HoaDonDomain hd = null;
        try {
            Connection cnn = DBConnect.getConnection();
            String sql =  """
                   SELECT [ID]
                         ,[MA]
                         ,[ID_NV]
                         ,[ID_KH]
                         ,[ID_PGG]
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
                     FROM [dbo].[HOA_DON] where HOA_DON.Ma like '?'
                    """;
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                HoaDonDomain hdd = new HoaDonDomain(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
                         rs.getInt(12), rs.getInt(13),rs.getString(14),rs.getString(15));
                
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;    }

    @Override
    public List<HoaDonDomain> searchByDate(Date start, Date end, int type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(HoaDonDomain hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(int id, HoaDonDomain hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
