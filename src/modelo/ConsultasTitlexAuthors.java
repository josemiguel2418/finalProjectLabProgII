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
public class ConsultasTitlexAuthors extends Conexion{
     public ArrayList<String> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "SELECT authors.au_fname ,authors.au_lname , titles.title FROM titleauthor JOIN authors ON titleauthor.au_id = authors.au_id JOIN titles ON titleauthor.title_id = titles.title_id;";
        ArrayList<String> titlexAuthors = new ArrayList<String>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String titlexAuthor = rs.getString("au_fname") + " " +  rs.getString("au_lname") + " es el/la autor/a del libro " + rs.getString("title");   
                
                titlexAuthors.add(titlexAuthor);
            }
            return titlexAuthors;
        } catch (SQLException e) {
            System.err.println(e);
            return titlexAuthors;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }
}
