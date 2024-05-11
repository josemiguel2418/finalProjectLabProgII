/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Timestamp;

/**
 *
 * @author Jose Miguel
 */
//100603475
public class Employees {
    private String emp_id;
    private String fname;
    private String minit;
    private String lname;
    private int job_id;
    private int job_lvl;
    private String pub_id;
    private Timestamp hire_date;
    
    public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMinit() {
		return minit;
	}
	public void setMinit(String minit) {
		this.minit = minit;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public int getJob_lvl() {
		return job_lvl;
	}
	public void setJob_lvl(int job_lvl) {
		this.job_lvl = job_lvl;
	}
	public String getPub_id() {
		return pub_id;
	}
	public void setPub_id(String pub_id) {
		this.pub_id = pub_id;
	}
	public Timestamp getHire_date() {
		return hire_date;
	}
	public void setHire_date(Timestamp hire_date) {
		this.hire_date = hire_date;
	}
}
