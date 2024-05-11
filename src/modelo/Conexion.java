/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Jose Miguel
 */

/*
José Miguel Martínez
100603475
*/

public class Conexion {
    
    
    public static final String CONFIG_FILE = "C:\\Users\\Jose Miguel\\Desktop\\config.txt";
    public static final String BASE = "pubs"; 
    private static String USERNAME = "";
    private static String PASSWORD = "";
    private static String URL = "jdbc:mysql://localhost:3306/" + BASE;
    private Connection connection = null;
    
    static {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CONFIG_FILE));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("=");
                if (partes.length == 2) {
                    if (partes[0].equals("USERNAME")) {
                        USERNAME = partes[1];
                    } else if (partes[0].equals("PASSWORD")) {
                        PASSWORD = partes[1];
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de configuración: " + e.getMessage());
        }
    }
    
    public Connection getConnection(){
        try{
            connection = DriverManager.getConnection(this.URL,this.USERNAME,this.PASSWORD);
        }catch(SQLException e){
            System.err.println(e);
        }
        return connection;
    }
}
