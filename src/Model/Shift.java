/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dell
 */
public class Shift {
    private Double shift_s;
    private int id_sales_shift;

    public Shift() {
    }

    public Shift(Double shift_s, int id_sales_shift) {
        this.shift_s = shift_s;
        this.id_sales_shift = id_sales_shift;
    }

    public Double getShift_s() {
        return shift_s;
    }

    public void setShift_s(Double shift_s) {
        this.shift_s = shift_s;
    }

    public int getId_sales_shift() {
        return id_sales_shift;
    }

    public void setId_sales_shift(int id_sales_shift) {
        this.id_sales_shift = id_sales_shift;
    }
    
   
}
