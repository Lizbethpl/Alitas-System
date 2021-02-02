/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author toshiba
 */
public class Package {
    private int id_package;
    private String name_package;
    private String description_package;
    private double price_package;

    public Package() {
    }

    public Package(int id_package, String name_package, String description_package, double price_package) {
        this.id_package = id_package;
        this.name_package = name_package;
        this.description_package = description_package;
        this.price_package = price_package;
    }

    public int getId_package() {
        return id_package;
    }

    public void setId_package(int id_package) {
        this.id_package = id_package;
    }

    public String getName_package() {
        return name_package;
    }

    public void setName_package(String name_package) {
        this.name_package = name_package;
    }

    public String getDescription_package() {
        return description_package;
    }

    public void setDescription_package(String description_package) {
        this.description_package = description_package;
    }

    public double getPrice_package() {
        return price_package;
    }

    public void setPrice_package(double price_package) {
        this.price_package = price_package;
    }
    
    
}
