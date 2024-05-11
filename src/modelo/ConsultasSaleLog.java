/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Jose Miguel
 */
//100603475
public class ConsultasSaleLog extends Conexion{
    public ArrayList<SalesLog> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from sales_log;";
        ArrayList<SalesLog> salesLogs = new ArrayList<SalesLog>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                SalesLog salesLog = new SalesLog();
                salesLog.setSalesLogId(rs.getInt("sales_log_id"));
                salesLog.setStor_id(rs.getString("stor_id"));
                salesLog.setOrdNum(rs.getString("ord_num"));
                salesLog.setTitleId(rs.getString("title_id"));
                salesLog.setAuId(rs.getString("au_id"));
                salesLog.setLogFecha(rs.getTimestamp("log_fecha"));
                salesLog.setPrice(rs.getDouble("price"));
                salesLog.setQuantity(rs.getInt("quantity"));
                
                salesLogs.add(salesLog);
            }
            return salesLogs;
        } catch (SQLException e) {
            System.err.println(e);
            return salesLogs;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(SalesLog salesLog) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO sales_log (sales_log_id,stor_id,ord_num,title_id,au_id,log_fecha,price,quantity) values(?,?,?,?,?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, salesLog.getSalesLogId());
            ps.setString(2, salesLog.getStor_id());
            ps.setString(3, salesLog.getOrdNum());
            ps.setString(4,salesLog.getTitleId());
            ps.setString(5,salesLog.getAuId());
            ps.setTimestamp(6,salesLog.getLogFecha());
            ps.setDouble(7,salesLog.getPrice());
            ps.setInt(8,salesLog.getQuantity());
           
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean put(SalesLog salesLog) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE sales_log SET stor_id = ?, ord_num = ?, title_id= ?, au_id = ?, log_fecha = ?, price = ?, quantity = ? WHERE sales_log_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, salesLog.getStor_id());
            ps.setString(2, salesLog.getOrdNum());
            ps.setString(3, salesLog.getTitleId());
            ps.setString(4, salesLog.getAuId());
            ps.setTimestamp(5, salesLog.getLogFecha());
            ps.setDouble(6, salesLog.getPrice());
            ps.setInt(7, salesLog.getQuantity());
            ps.setInt(8, salesLog.getSalesLogId());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }
    public boolean delete(SalesLog salesLog) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM sales_log WHERE sales_log_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, salesLog.getSalesLogId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
