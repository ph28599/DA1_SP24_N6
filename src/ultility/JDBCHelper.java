/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultility;

<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< HEAD
public class JDBCHelper {

    public static ResultSet excuteQuery(String sql, Object... args) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pr = null;

=======
/**
 *
 * @author pc
 */
public class JDBCHelper {
        public  static ResultSet excuteQuery(String sql, Object ...args){
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pr = null;
        
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
        cn = DBConnection.getConnection();
        try {
            pr = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
<<<<<<< HEAD
                pr.setObject(i + 1, args[i]);
=======
                pr.setObject(i+1, args[i]);
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
            }
            rs = pr.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
<<<<<<< HEAD

    public static Integer excuteUpdate(String sql, Object... args) {
        Connection cn = null;
        Integer row = 0;
        PreparedStatement pr = null;

=======
    public  static Integer excuteUpdate(String sql, Object ...args){
        Connection cn = null;
        Integer row = 0;
        PreparedStatement pr = null;
        
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
        cn = DBConnection.getConnection();
        try {
            pr = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
<<<<<<< HEAD
                pr.setObject(i + 1, args[i]);
=======
                pr.setObject(i+1, args[i]);
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
            }
            row = pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
<<<<<<< HEAD
=======
    
>>>>>>> dbd78694334c42f2a5d1053879053c656df919aa
}
