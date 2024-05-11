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
public class ConsultasPublishers extends Conexion{
    public ArrayList<Publishers> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from publishers;";
        ArrayList<Publishers> publishers = new ArrayList<Publishers>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Publishers publisher = new Publishers();
                publisher.setPubId(rs.getString("pub_id"));
                publisher.setPubName(rs.getString("pub_name"));
                publisher.setCity(rs.getString("city"));
                publisher.setState(rs.getString("state"));
                publisher.setCountry(rs.getString("country"));     
                
                publishers.add(publisher);
            }
            return publishers;
        } catch (SQLException e) {
            System.err.println(e);
            return publishers;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(Publishers publisher) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO publishers (pub_id,pub_name,city,state,country) values(?,?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, publisher.getPubId());
            ps.setString(2, publisher.getPubName());
            ps.setString(3, publisher.getCity());
            ps.setString(4,publisher.getState());
            ps.setString(5,publisher.getCountry());
           
            
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

    
    public boolean put(Publishers publisher) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE publishers SET pub_name = ?, city= ?, state = ?, country = ?  WHERE pub_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, publisher.getPubName());
            ps.setString(2, publisher.getCity());
            ps.setString(3, publisher.getState());
            ps.setString(4, publisher.getCountry());
            ps.setString(5, publisher.getPubId());
            
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
    public boolean delete(Publishers publisher) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM publishers WHERE pub_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, publisher.getPubId());
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
