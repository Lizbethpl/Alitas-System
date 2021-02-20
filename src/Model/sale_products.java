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
public class sale_products {
    private int id;
    private String date_sale;
    private Double total_sale;
    private String client_sale;
    private int id_sale_product;

    public sale_products() {
    }

    public sale_products(int id, String date_sale, Double total_sale, String client_sale, int id_sale_product) {
        this.id = id;
        this.date_sale = date_sale;
        this.total_sale = total_sale;
        this.client_sale = client_sale;
        this.id_sale_product = id_sale_product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_sale() {
        return date_sale;
    }

    public void setDate_sale(String date_sale) {
        this.date_sale = date_sale;
    }

    public Double getTotal_sale() {
        return total_sale;
    }

    public void setTotal_sale(Double total_sale) {
        this.total_sale = total_sale;
    }

    public String getClient_sale() {
        return client_sale;
    }

    public void setClient_sale(String client_sale) {
        this.client_sale = client_sale;
    }

    public int getId_sale_product() {
        return id_sale_product;
    }

    public void setId_sale_product(int id_sale_product) {
        this.id_sale_product = id_sale_product;
    }

    
    
}
