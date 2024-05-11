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

/*
José Miguel Martínez
100603475
*/
public class ConsultasAuthors extends Conexion{
        public ArrayList<Authors> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from authors;";
        ArrayList<Authors> authors = new ArrayList<Authors>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Authors author = new Authors();
                author.setAu_id(rs.getString("au_id"));
                author.setAu_lname(rs.getString("au_lname"));
                author.setAu_fname(rs.getString("au_fname"));
                author.setPhone(rs.getString("phone"));
                author.setAddress(rs.getString("address"));
                author.setCity(rs.getString("city"));
                author.setState(rs.getString("state"));
                author.setZip(rs.getString("zip"));
                author.setContract(Byte.parseByte(rs.getString("contract")));
                
                authors.add(author);
            }
            return authors;
        } catch (SQLException e) {
            System.err.println(e);
            return authors;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(Authors author) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO authors (au_id,au_lname,au_fname,phone,address,city,state,zip,contract) values(?,?,?,?,?,?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, author.getAu_id());
            ps.setString(2, author.getAu_lname());
            ps.setString(3, author.getAu_fname());
            ps.setString(4,author.getPhone());
            ps.setString(5,author.getAddress());
            ps.setString(6,author.getCity());
            ps.setString(7,author.getState());
            ps.setString(8,author.getZip());
            ps.setByte(9,author.getContract());
            
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

    
    public boolean put(Authors author) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE authors SET au_lname = ?, au_fname = ?, phone= ?, address = ?, city = ?, state = ?, zip = ?, contract = ?  WHERE au_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, author.getAu_lname());
            ps.setString(2, author.getAu_fname());
            ps.setString(3, author.getPhone());
            ps.setString(4, author.getAddress());
            ps.setString(5, author.getCity());
            ps.setString(6, author.getState());
            ps.setString(7, author.getZip());
            ps.setByte(8, author.getContract());
            ps.setString(9, author.getAu_id());
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
        String sql = "DELETE FROM authors WHERE au_id = ?";
        
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
