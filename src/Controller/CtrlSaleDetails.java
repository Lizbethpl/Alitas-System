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
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
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
    DefaultListModel modelo = new DefaultListModel(); 
    Sale sale = new Sale();
    public CtrlSaleDetails(ConsultSale csale, SaleDetailsfrm frmsaledetails, sale_products salep,DefaultListModel modelo) {
        this.salep= salep;
        this.frmsaledetails=frmsaledetails;
        this.csale= csale;
        this.frmsale=frmsale;
        this.modelo=modelo;
        listarVenta();
        listarVentaProducto(frmsaledetails.jlistProducts);
    }
    public void listarVenta(){
        //Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
//        int id=0;
//        id = Integer.parseInt(frmsaledetails.jlOrder.getText());
//        modelo=(DefaultTableModel)tabla.getModel();
        int id = Integer.parseInt(frmsaledetails.jlOrder.getText());
        List <sale_products> lista = csale.ListarVentaDetalle(id);
        
        String nombre = lista.get(0).getClient_sale();
        frmsaledetails.jlClient.setText(nombre);
        frmsaledetails.jlPrice.setText("" +lista.get(0).getTotal_sale());
    }
    
    public void listarVentaProducto(JList listaP){
//        int id=0;
          int id = Integer.parseInt(frmsaledetails.jlOrder.getText());
//        modelo=(DefaultTableModel)tabla.getModel();
        
        
        DefaultListModel listModel = new DefaultListModel();
        List <Sale> lista = csale.ListarVentaProducto(id);
        
        for (int i = 0; i < lista.size(); i++) {
            listModel.addElement(lista.get(i).getName_sproduct()+"  "+ lista.get(i).getTotal_sproduct());
        }
        
        //listModel.addElement(lista.get(0).getTotal_sproduct());
        
        frmsaledetails.jlistProducts.setModel(listModel);
    }
 
}
