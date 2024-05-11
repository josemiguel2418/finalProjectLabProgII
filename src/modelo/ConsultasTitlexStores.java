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
public class ConsultasTitlexStores extends Conexion{
    public ArrayList<String> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "SELECT titles.title, stores.stor_name, sales.qty,sales.ord_date FROM sales JOIN stores ON sales.stor_id = stores.stor_id JOIN titles ON sales.title_id = titles.title_id ;";
        ArrayList<String> titlexStores = new ArrayList<String>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String titlexStore = rs.getInt("qty") + " libros llamados " + rs.getString("title") + " fueron vendidos en la tienda " + rs.getString("stor_name") + " en la fecha " + rs.getTimestamp("ord_date");   
                
                titlexStores.add(titlexStore);
            }
            return titlexStores;
        } catch (SQLException e) {
            System.err.println(e);
            return titlexStores;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }
}
