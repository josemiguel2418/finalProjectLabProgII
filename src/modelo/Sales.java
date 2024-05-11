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
public class Sales {
	private String stor_id;
	private String ord_num;
	private Timestamp ord_date;
	private int qty;
	private String payterms;
	private String title_id;
	
	public String getStor_id() {
		return stor_id;
	}
	public void setStor_id(String stor_id) {
		this.stor_id = stor_id;
	}
	public String getOrd_num() {
		return ord_num;
	}
	public void setOrd_num(String ord_num) {
		this.ord_num = ord_num;
	}
	public Timestamp getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(Timestamp ord_date) {
		this.ord_date = ord_date;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getPayterms() {
		return payterms;
	}
	public void setPayterms(String payterms) {
		this.payterms = payterms;
	}
	public String getTitle_id() {
		return title_id;
	}
	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}    
}
