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
public class ConsultasRoysched extends Conexion {
    public ArrayList<Roysched> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from roysched;";
        ArrayList<Roysched> royscheds = new ArrayList<Roysched>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Roysched roysched = new Roysched();
                roysched.setTitle_id(rs.getString("title_id"));
                roysched.setLorange(rs.getInt("lorange"));
                roysched.setHirange(rs.getInt("hirange"));
                roysched.setRoyalty(rs.getInt("royalty"));
                
                royscheds.add(roysched);
            }
            return royscheds;
        } catch (SQLException e) {
            System.err.println(e);
            return royscheds;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(Roysched roysched) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO roysched (title_id,lorange,hirange,royalty) values(?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, roysched.getTitle_id());
            ps.setInt(2, roysched.getLorange());
            ps.setInt(3, roysched.getHirange());
            ps.setInt(4,roysched.getRoyalty());
            
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

    
    public boolean put(Roysched roysched) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE roysched SET lorange = ?, hirange = ?, royalty= ?  WHERE title_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, roysched.getLorange());
            ps.setInt(2, roysched.getHirange());
            ps.setInt(3, roysched.getRoyalty());
            ps.setString(4, roysched.getTitle_id());
           
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
    public boolean delete(Authors author) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM roysched WHERE title_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, author.getAu_id());
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
