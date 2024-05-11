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
public class Title {
    private String title_id;
	private String title;
	private String type;
	private String pud_id;
	private double price;
	private double advance;
	private int royalti;
	private int ytd_sales;
	private String notes;
	private Timestamp pudDate;
	
	public String getTitle_id() {
		return title_id;
	}
	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPud_id() {
		return pud_id;
	}
	public void setPud_id(String pud_id) {
		this.pud_id = pud_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAdvance() {
		return advance;
	}
	public void setAdvance(double advance) {
		this.advance = advance;
	}
	public int getRoyalti() {
		return royalti;
	}
	public void setRoyalti(int royalti) {
		this.royalti = royalti;
	}
	public int getYtd_sales() {
		return ytd_sales;
	}
	public void setYtd_sales(int ytd_sales) {
		this.ytd_sales = ytd_sales;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Timestamp getPudDate() {
		return pudDate;
	}
	public void setPudDate(Timestamp pudDate) {
		this.pudDate = pudDate;
	}
}
