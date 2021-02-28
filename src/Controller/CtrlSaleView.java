/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConsultSaleView;
import Model.Products;
import Model.Sale;
import Model.sale_products;
import View.SalesViewfrm;
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
public class CtrlSaleView implements ActionListener {
    sale_products sp;
    ConsultSaleView csv;
    SalesViewfrm saleviewfrm;
    DefaultTableModel modelo;

    public CtrlSaleView(sale_products sp, ConsultSaleView csv, SalesViewfrm saleviewfrm, DefaultTableModel modelo) {
        this.sp = sp;
        this.csv = csv;
        this.saleviewfrm = saleviewfrm;
        this.modelo = modelo;
        this.saleviewfrm.btnEliminar.addActionListener(this);
        
        listar(saleviewfrm.jSalesView);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== saleviewfrm.btnEliminar) {
            eliminar();
            limpiarTabla();
            listar(saleviewfrm.jSalesView);
        }
        
    }
    
   void limpiarTabla() {
        for (int i = 0; i < saleviewfrm.jSalesView.getRowCount(); i++) {
            modelo.removeRow(i);
            i=i-1;
        }
    }
    public void listar(JTable tabla){
        modelo=(DefaultTableModel)tabla.getModel();
        List <sale_products> lista = csv.Listar();
        
        
        Object [] object = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            object[0]= lista.get(i).getDate_sale();
            object[1]= lista.get(i).getId_sale_product();
            object[2]= lista.get(i).getClient_sale();
            object[3]= lista.get(i).getTotal_sale();
            modelo.addRow(object);
        }
        saleviewfrm.jSalesView.setModel(modelo);
    }
    public void eliminar() {
        int fila = saleviewfrm.jSalesView.getSelectedRow();   
        int id = Integer.parseInt((String)saleviewfrm.jSalesView.getValueAt(fila,1).toString());
        csv.delete(id);
        JOptionPane.showMessageDialog(saleviewfrm, "Registro eliminado");
        
    } 

    
}
