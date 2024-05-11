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
public class ConsultasEmployees extends Conexion{
    public ArrayList<Employees> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from employee;";
        ArrayList<Employees> employees = new ArrayList<Employees>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Employees employee = new Employees();
                employee.setEmp_id(rs.getString("emp_id"));
                employee.setFname(rs.getString("fname"));
                employee.setMinit(rs.getString("minit"));
                employee.setLname(rs.getString("lname"));
                employee.setJob_id(rs.getInt("job_id"));
                employee.setJob_lvl(rs.getInt("job_lvl"));
                employee.setPub_id(rs.getString("pub_id"));
                employee.setHire_date(rs.getTimestamp("hire_date"));
               
                
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            System.err.println(e);
            return employees;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(Employees employee) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO employee (emp_id,fname,minit,lname,job_id,job_lvl,pub_id,hire_date) values(?,?,?,?,?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, employee.getEmp_id());
            ps.setString(2, employee.getFname());
            ps.setString(3, employee.getMinit());
            ps.setString(4,employee.getLname());
            ps.setInt(5,employee.getJob_id());
            ps.setInt(6,employee.getJob_lvl());
            ps.setString(7,employee.getPub_id());
            ps.setTimestamp(8,employee.getHire_date());
            
            
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

    
    public boolean put(Employees employee) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE employee SET fname = ?, lname = ?  WHERE emp_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, employee.getFname());
            ps.setString(2, employee.getLname());
            ps.setString(3, employee.getEmp_id());
            
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
    public boolean delete(Employees employee) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM employee WHERE emp_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, employee.getEmp_id());
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
