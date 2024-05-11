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
public class ConsultasPubMenu extends Conexion{
    public ArrayList<PubMenu> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from pub_menu;";
        ArrayList<PubMenu> pubMenus = new ArrayList<PubMenu>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                PubMenu pubMenu = new PubMenu();
                pubMenu.setMnuNum(rs.getInt("mnu_num"));
                pubMenu.setMnuMaster(rs.getInt("mnu_master"));
                pubMenu.setMnuName(rs.getString("MNU_NAME"));
                
                
                pubMenus.add(pubMenu);
            }
            return pubMenus;
        } catch (SQLException e) {
            System.err.println(e);
            return pubMenus;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(PubMenu pubMenu) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO pub_menu (mnu_num,mnu_master,MNU_NAME) values(?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, pubMenu.getMnuNum());
            ps.setInt(2, pubMenu.getMnuMaster());
            ps.setString(3, pubMenu.getMnuName());
            
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

    
    public boolean put(PubMenu pubMenu) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE pub_menu SET mnu_master = ?, MNU_NAME = ?  WHERE mnu_num = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, pubMenu.getMnuMaster());
            ps.setString(2, pubMenu.getMnuName());
            ps.setInt(3, pubMenu.getMnuNum());
           
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
    public boolean delete(PubMenu pubMenu) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM pub_menu WHERE mnu_num = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, pubMenu.getMnuNum());
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
