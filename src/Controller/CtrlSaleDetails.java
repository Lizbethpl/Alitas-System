/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConsultSale;
import Model.DateSys;
import Model.Sale;
import Model.sale_products;
import View.Menufrm;
import View.SaleDetailsfrm;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public final class CtrlSaleDetails {
    
    ConsultSale csale= new ConsultSale();
    SaleDetailsfrm frmsaledetails = new SaleDetailsfrm();
    sale_products salep = new sale_products();
    DateSys date= new DateSys();
    Menufrm frmsale = new Menufrm();
    public CtrlSaleDetails(ConsultSale csale, SaleDetailsfrm frmsaledetails, sale_products salep, Menufrm frmsale) {
        this.salep= salep;
        this.frmsaledetails=frmsaledetails;
        this.csale= csale;
        this.frmsale=frmsale;
        listar();
    }
    public void listar(){
        //int id = Integer.parseInt(frmsale.txtNumOrder.getText());
//        modelo=(DefaultTableModel)tabla.getModel();
        List <sale_products> lista = csale.ListarVentaDetalle(10);
        
        String nombre = lista.get(0).getClient_sale();
        frmsaledetails.jLabel8.setText(nombre);
        frmsaledetails.jLabel9.setText("ID: " + lista.get(0).getTotal_sale());
//        Object [] object = new Object[3];
//        for (int i = 0; i < lista.size(); i++) {
//            object[0]= lista.get(i).getName_sproduct();
//            object[1]= lista.get(i).getTotal_sproduct();
//            object[2]= lista.get(i).getId();
//            modelo.addRow(object);
//        }
//        frmsale.jSale.setModel(modelo);
    }
    public static void main(String[] args) {
        
        ;
    }
}
