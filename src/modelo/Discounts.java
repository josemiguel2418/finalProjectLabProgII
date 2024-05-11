/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jose Miguel
 */
//100603475
public class Discounts {
   
    private String discounttype;
    private String stor_id;
    private int lowqty;
    private int highqty;
    private double discount;

    public String getDiscounttype() {
        return discounttype;
    }

    public void setDiscounttype(String discounttype) {
        this.discounttype = discounttype;
    }

    public String getStor_id() {
        return stor_id;
    }

    public void setStor_id(String stor_id) {
        this.stor_id = stor_id;
    }

    public int getLowqty() {
        return lowqty;
    }

    public void setLowqty(int lowqty) {
        this.lowqty = lowqty;
    }

    public int getHighqty() {
        return highqty;
    }

    public void setHighqty(int highqty) {
        this.highqty = highqty;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    
    
}
