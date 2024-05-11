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
public class ConsultasJobs extends Conexion{
    public ArrayList<Jobs> get() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConnection();
        String sql = "select * from jobs;";
        ArrayList<Jobs> jobs = new ArrayList<Jobs>();
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Jobs job = new Jobs();
                job.setJobId(rs.getInt("job_id"));
                job.setJobDesc(rs.getString("job_desc"));
                job.setMinLvl(rs.getInt("min_lvl"));
                job.setMaxLvl(rs.getInt("max_lvl"));
                
                
                jobs.add(job);
            }
            return jobs;
        } catch (SQLException e) {
            System.err.println(e);
            return jobs;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    
    public boolean post(Jobs job) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "INSERT INTO jobs (job_id,job_desc,min_lvl,max_lvl) values(?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, job.getJobId());
            ps.setString(2, job.getJobDesc());
            ps.setInt(3, job.getMinLvl());
            ps.setInt(4,job.getMaxLvl());
            
            
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

    
    public boolean put(Jobs job) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "UPDATE jobs SET job_desc = ?, min_lvl = ?, max_lvl= ?  WHERE job_id = ?";
        

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, job.getJobDesc());
            ps.setInt(2, job.getMinLvl());
            ps.setInt(3, job.getMaxLvl());
            ps.setInt(4, job.getJobId());
            
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
    public boolean delete(Jobs job) {
        PreparedStatement ps = null;
        Connection conexion = getConnection();
        String sql = "DELETE FROM jobs WHERE job_id = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, job.getJobId());
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
