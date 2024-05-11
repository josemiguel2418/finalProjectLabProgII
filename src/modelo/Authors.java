/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jose Miguel
 */

/*
José Miguel Martínez
100603475
*/
public class Authors {
    private String au_id;
    private String au_lname;
    private String au_fname;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private byte contract;
	
    public String getAu_id() {
	return au_id;
    }
    public void setAu_id(String au_id) {
	this.au_id = au_id;
    }
    public String getAu_lname() {
	return au_lname;
    }
    public void setAu_lname(String au_lname) {
	this.au_lname = au_lname;
    }
    public String getAu_fname() {
	return au_fname;
    }
    public void setAu_fname(String au_fname) {
        this.au_fname = au_fname;
    }
    public String getPhone() {
    	return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
	return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public byte getContract() {
        return contract;
    }
    public void setContract(byte contract) {
        this.contract = contract;
    }
}
