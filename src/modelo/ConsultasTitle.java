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
//100603475
public class ConsultasTitle extends Conexion{
    public ArrayList<Title> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from titles;";
        ArrayList<Title> titles = new ArrayList<Title>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Title title = new Title();
                title.setTitle_id(rs.getString("title_id"));
                title.setTitle(rs.getString("title"));
                title.setType(rs.getString("type"));
                title.setPud_id(rs.getString("pub_id"));
                title.setPrice(rs.getDouble("price"));
                title.setAdvance(rs.getDouble("advance"));
                title.setRoyalti(rs.getInt("royalty"));
                title.setYtd_sales(rs.getInt("ytd_sales"));
                title.setNotes(rs.getString("notes"));
                title.setPudDate(rs.getTimestamp("pubdate"));
                
                titles.add(title);
            }
            return titles;
        } catch (SQLException e) {
            System.err.println(e);
            return titles;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(Title title) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO titles (title_id,title,type,pub_id,price,advance,royalty,ytd_sales,notes,pubdate) values(?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, title.getTitle_id());
            ps.setString(2, title.getTitle());
            ps.setString(3, title.getType());
            ps.setString(4,title.getPud_id());
            ps.setDouble(5,title.getPrice());
            ps.setDouble(6,title.getAdvance());
            ps.setInt(7,title.getRoyalti());
            ps.setInt(8,title.getYtd_sales());
            ps.setString(9,title.getNotes());
            ps.setTimestamp(10,title.getPudDate());

            
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

    
    public boolean put(Title title) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE titles SET title = ?, type = ?, price= ?, advance = ?, royalty = ?, ytd_sales = ?, notes = ?  WHERE title_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, title.getTitle());
            ps.setString(2, title.getType());
            ps.setDouble(3, title.getPrice());
            ps.setDouble(4, title.getAdvance());
            ps.setInt(5, title.getRoyalti());
            ps.setInt(6, title.getYtd_sales());
            ps.setString(7, title.getNotes());
            ps.setString(8, title.getTitle_id());
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
    public boolean delete(Title title) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM titles WHERE title_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, title.getTitle_id());
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
