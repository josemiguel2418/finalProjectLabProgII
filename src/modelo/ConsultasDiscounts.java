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
public class ConsultasDiscounts extends Conexion{
    public ArrayList<Discounts> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from discounts;";
        ArrayList<Discounts> discounts = new ArrayList<Discounts>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Discounts discount = new Discounts();
                discount.setDiscounttype(rs.getString("discounttype"));
                discount.setStor_id(rs.getString("stor_id"));
                discount.setLowqty(rs.getInt("lowqty"));
                discount.setHighqty(rs.getInt("highqty"));
                discount.setDiscount(rs.getDouble("discount"));
                
                discounts.add(discount);
            }
            return discounts;
        } catch (SQLException e) {
            System.err.println(e);
            return discounts;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(Discounts discount) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO discounts (discounttype,stor_id,lowqty,highqty,discount) values(?,?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, discount.getDiscounttype());
            ps.setString(2, discount.getStor_id());
            ps.setInt(3, discount.getLowqty());
            ps.setInt(4,discount.getHighqty());
            ps.setDouble(5,discount.getDiscount());
            
            
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

    
    public boolean put(Discounts discount) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE discounts SET discounttype = ?, lowqty = ?, highqty = ?, discount = ?  WHERE stor_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, discount.getDiscounttype());
            ps.setInt(2, discount.getLowqty());
            ps.setInt(3, discount.getHighqty());
            ps.setDouble(4, discount.getDiscount());
            ps.setString(5, discount.getStor_id());
            
           
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
    public boolean delete(Discounts discount) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM discounts WHERE stor_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, discount.getStor_id());
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
