/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jose Miguel
 */

/*
José Miguel Martínez
100603475
*/
public class ConsultasPubInfo extends Conexion{
    public ArrayList<PubInfo> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from pub_info;";
        ArrayList<PubInfo> pubInfos = new ArrayList<PubInfo>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                PubInfo pubInfo = new PubInfo();
                pubInfo.setPub_id(rs.getString("pub_id"));
                pubInfo.setPrInfo(rs.getString("pr_info"));
                
                pubInfos.add(pubInfo);
            }
            return pubInfos;
        } catch (SQLException e) {
            System.err.println(e);
            return pubInfos;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(PubInfo pubInfo) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO pub_info (pub_id,pr_info) values(?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pubInfo.getPub_id());
            ps.setString(2, pubInfo.getPrInfo());
            
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

    
    public boolean put(PubInfo pubInfo) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE pub_info SET pr_info = ?  WHERE pub_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pubInfo.getPrInfo());
            ps.setString(2, pubInfo.getPub_id());
            
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
    public boolean delete(PubInfo pubInfo) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM pub_info WHERE pub_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pubInfo.getPub_id());
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
