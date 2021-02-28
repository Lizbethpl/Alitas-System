/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConsultSaleView;
import Model.ConsultSaleViews;
import Model.Products;
import Model.Sale;
import Model.sale_products;
import View.SalesViewfrm;
import View.SalesViewsfrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class CtrlSaleViews implements ActionListener {
    Sale sp;
    ConsultSaleViews csvs;
    SalesViewsfrm saleviewsfrm;
    DefaultTableModel modelo;

    public CtrlSaleViews(Sale sp, ConsultSaleViews csvs, SalesViewsfrm saleviewsfrm, DefaultTableModel modelo) {
        this.sp = sp;
        this.csvs = csvs;
        this.saleviewsfrm = saleviewsfrm;
        this.modelo = modelo;
        listar(saleviewsfrm.jSalesViewProduct);
    }
    
   
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }
  
    public void listar(JTable tabla){
        int id = Integer.parseInt(saleviewsfrm.jlOrden.getText());
        modelo=(DefaultTableModel)tabla.getModel();
        
        List <Sale> lista = csvs.Listar(id);
        
        
        Object [] object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0]= lista.get(i).getSales_id_sale();
            object[1]= lista.get(i).getName_sproduct();
            object[2]= lista.get(i).getLot_sproduct();
            object[3]= lista.get(i).getDescription_sproduct();
            object[4]= lista.get(i).getTotal_sproduct();
            modelo.addRow(object);
        }
        saleviewsfrm.jSalesViewProduct.setModel(modelo);
    }

    
}
