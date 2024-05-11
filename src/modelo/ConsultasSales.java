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
public class ConsultasSales extends Conexion{
    public ArrayList<Sales> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from sales;";
        ArrayList<Sales> sales = new ArrayList<Sales>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Sales sale = new Sales();
                sale.setStor_id(rs.getString("stor_id"));
                sale.setOrd_num(rs.getString("ord_num"));
                sale.setOrd_date(rs.getTimestamp("ord_date"));
                sale.setQty(rs.getInt("qty"));
                sale.setPayterms(rs.getString("payterms"));
                sale.setTitle_id(rs.getString("title_id"));
                
                
                sales.add(sale);
            }
            return sales;
        } catch (SQLException e) {
            System.err.println(e);
            return sales;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(Sales sale) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO sales (stor_id,ord_num,ord_date,qty,payterms,title_id) values(?,?,?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, sale.getStor_id());
            ps.setString(2, sale.getOrd_num());
            ps.setTimestamp(3, sale.getOrd_date());
            ps.setInt(4,sale.getQty());
            ps.setString(5,sale.getPayterms());
            ps.setString(6,sale.getTitle_id());
           
            
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

    
    public boolean put(Sales sale) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE sales SET ord_num = ?, ord_date = ?, qty= ?, payterms = ? WHERE stor_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, sale.getOrd_num());
            ps.setTimestamp(2, sale.getOrd_date());
            ps.setInt(3, sale.getQty());
            ps.setString(4, sale.getPayterms());
            ps.setString(5, sale.getStor_id());
            
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
    public boolean delete(Sales sale) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM sales WHERE stor_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, sale.getStor_id());
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
