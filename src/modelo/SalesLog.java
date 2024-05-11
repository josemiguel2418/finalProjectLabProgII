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
public class SalesLog {
    
    private int salesLogId;
    private String stor_id;
    private String ordNum;
    private String titleId;
    private String auId;
    private Timestamp logFecha;
    private double price;
    private int quantity;

    public int getSalesLogId() {
        return salesLogId;
    }

    public void setSalesLogId(int salesLogId) {
        this.salesLogId = salesLogId;
    }

    public String getStor_id() {
        return stor_id;
    }

    public void setStor_id(String stor_id) {
        this.stor_id = stor_id;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getAuId() {
        return auId;
    }

    public void setAuId(String auId) {
        this.auId = auId;
    }

    public Timestamp getLogFecha() {
        return logFecha;
    }

    public void setLogFecha(Timestamp logFecha) {
        this.logFecha = logFecha;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
