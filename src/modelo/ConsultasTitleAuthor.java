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
public class ConsultasTitleAuthor extends Conexion{
    public ArrayList<TitleAuthor> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from titleauthor;";
        ArrayList<TitleAuthor> titleAuthors = new ArrayList<TitleAuthor>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                TitleAuthor titleAuthor = new TitleAuthor();
                titleAuthor.setAu_id(rs.getString("au_id"));
                titleAuthor.setTitle_id(rs.getString("title_id"));
                titleAuthor.setAu_ord(rs.getInt("au_ord"));
                titleAuthor.setRoyaltyper(rs.getInt("royaltyper"));
                
                
                titleAuthors.add(titleAuthor);
            }
            return titleAuthors;
        } catch (SQLException e) {
            System.err.println(e);
            return titleAuthors;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(TitleAuthor titleAuthor) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO titleauthor (au_id,title_id,au_ord,royaltyper) values(?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, titleAuthor.getAu_id());
            ps.setString(2, titleAuthor.getTitle_id());
            ps.setInt(3, titleAuthor.getAu_ord());
            ps.setInt(4,titleAuthor.getRoyaltyper());
            
            
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

    
    public boolean put(TitleAuthor titleAuthor) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE titleauthor SET au_ord = ?, royaltyper = ? WHERE au_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, titleAuthor.getAu_ord());
            ps.setInt(2, titleAuthor.getRoyaltyper());
            ps.setString(3, titleAuthor.getAu_id());
            
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
    public boolean delete(TitleAuthor titleAuthor) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM titleauthor WHERE au_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, titleAuthor.getAu_id());
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
