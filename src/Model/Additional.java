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
public class Additional {
    private int id_additional;
    private String name_additional;
    private double price_additional;

    public Additional() {
    }

    public Additional(int id_additional, String name_additional, double price_additional) {
        this.id_additional = id_additional;
        this.name_additional = name_additional;
        this.price_additional = price_additional;
    }

    public int getId_additional() {
        return id_additional;
    }

    public void setId_additional(int id_additional) {
        this.id_additional = id_additional;
    }

    public String getName_additional() {
        return name_additional;
    }

    public void setName_additional(String name_additional) {
        this.name_additional = name_additional;
    }

    public double getPrice_additional() {
        return price_additional;
    }

    public void setPrice_additional(double price_additional) {
        this.price_additional = price_additional;
    }
    
    
}
