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
public class Products {
    private int idProduct;
    private String nameProduct;
    private String categoryProduct;
    private String flavorProduct;
    private Double priceProduct;

    public Products() {
    }

    public Products(int idProduct, String nameProduct, String categoryProduct, String flavorProduct, Double priceProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.categoryProduct = categoryProduct;
        this.flavorProduct = flavorProduct;
        this.priceProduct = priceProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(String categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public String getFlavorProduct() {
        return flavorProduct;
    }

    public void setFlavorProduct(String flavorProduct) {
        this.flavorProduct = flavorProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    
}
