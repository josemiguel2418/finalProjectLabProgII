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
public class ConsultasStores extends Conexion{
    public ArrayList<Stores> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from stores;";
        ArrayList<Stores> stores = new ArrayList<Stores>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Stores store = new Stores();
                store.setStor_id(rs.getString("stor_id"));
                store.setStor_name(rs.getString("stor_name"));
                store.setStor_address(rs.getString("stor_address"));
                store.setCity(rs.getString("city"));
                store.setState(rs.getString("state"));
                store.setZip(rs.getString("zip"));
                
                
                stores.add(store);
            }
            return stores;
        } catch (SQLException e) {
            System.err.println(e);
            return stores;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(Stores store) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO stores (stor_id,stor_name,stor_address,city,state,zip) values(?,?,?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, store.getStor_id());
            ps.setString(2, store.getStor_name());
            ps.setString(3, store.getStor_address());
            ps.setString(4,store.getCity());
            ps.setString(5,store.getState());
            ps.setString(6,store.getZip());
            
            
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

    
    public boolean put(Stores store) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE stores SET stor_name = ?, stor_address = ?, city= ?, state = ?, zip = ?  WHERE stor_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, store.getStor_name());
            ps.setString(2, store.getStor_address());
            ps.setString(3, store.getCity());
            ps.setString(4, store.getState());
            ps.setString(5, store.getZip());
            ps.setString(6, store.getStor_id());
            
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
    public boolean delete(Stores store) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM stores WHERE stor_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, store.getStor_id());
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
