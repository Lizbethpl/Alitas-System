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
public class Sale {
    private int id;
    private String name_sproduct;
    private int lot_sproduct;
    private String description_sproduct;
    private Double total_sproduct;
    private int sales_id_sale;


    public Sale() {
    }

    public Sale(int id, String name_sproduct, int lot_sproduct, String description_sproduct, Double total_sproduct, int sales_id_sale) {
        this.id = id;
        this.name_sproduct = name_sproduct;
        this.lot_sproduct = lot_sproduct;
        this.description_sproduct = description_sproduct;
        this.total_sproduct = total_sproduct;
        this.sales_id_sale = sales_id_sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_sproduct() {
        return name_sproduct;
    }

    public void setName_sproduct(String name_sproduct) {
        this.name_sproduct = name_sproduct;
    }

    public int getLot_sproduct() {
        return lot_sproduct;
    }

    public void setLot_sproduct(int lot_sproduct) {
        this.lot_sproduct = lot_sproduct;
    }

    public String getDescription_sproduct() {
        return description_sproduct;
    }

    public void setDescription_sproduct(String description_sproduct) {
        this.description_sproduct = description_sproduct;
    }

    public Double getTotal_sproduct() {
        return total_sproduct;
    }

    public void setTotal_sproduct(Double total_sproduct) {
        this.total_sproduct = total_sproduct;
    }

    public int getSales_id_sale() {
        return sales_id_sale;
    }

    public void setSales_id_sale(int sales_id_sale) {
        this.sales_id_sale = sales_id_sale;
    }

    
    
}
