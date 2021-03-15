/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConsultProducts;
import Model.Products;
import View.Productsfrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class CtrlProducts implements ActionListener{
   /*Products p = new Products();
   ConsultProducts cp= new ConsultProducts();
   Productsfrm vista = new Productsfrm();
   DefaultTableModel modelo = new DefaultTableModel();*/
   Products p;
   ConsultProducts cp;
   Productsfrm vista;
   DefaultTableModel modelo;
    
  

    public CtrlProducts(Products p, ConsultProducts cp, DefaultTableModel modelo, Productsfrm vista) {
        this.p = p;
        this.cp = cp;
        this.vista = vista;
        this.modelo = modelo;
        
        
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        listar(vista.jProducts);
  
    }
   
   

    @Override
    public void actionPerformed(ActionEvent e) {       
        
        if (e.getSource()== vista.btnGuardar) {
            agregar();
            limpiarTabla();
            limpiarCajas();
            listar(vista.jProducts);
        }if (e.getSource()== vista.btnModificar) {
            actualizar();
            limpiarTabla();
            listar(vista.jProducts);
            limpiarCajas();
        }if (e.getSource()== vista.btnEliminar) {
            eliminar();
            limpiarTabla();
            listar(vista.jProducts); 
            limpiarCajas();
        }
    }
    void limpiarTabla() {
        for (int i = 0; i < vista.jProducts.getRowCount(); i++) {
            modelo.removeRow(i);
            i=i-1;
        }
    }
    void limpiarCajas(){
        vista.txtIdProduct.setText(null);
        vista.txtNameProduct.setText(null);
        vista.CbxCategoryProduct.setSelectedIndex(0);
        vista.txaFlavorProduct.setText(null);
        vista.txtPriceProduct.setText(null);
    }
    public void eliminar() {
        int fila = vista.jProducts.getSelectedRow();
            
            if (fila==1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un registro");
        } else {
                int id = Integer.parseInt((String)vista.jProducts.getValueAt(fila,0).toString());
                cp.delete(id);
                JOptionPane.showMessageDialog(vista, "Registro eliminado");
        }
    }    
    public void actualizar(){
        int id = Integer.parseInt(vista.txtIdProduct.getText());
        String name = vista.txtNameProduct.getText();
        String category = (String) vista.CbxCategoryProduct.getSelectedItem();
        String flavor = vista.txaFlavorProduct.getText();
        Double price = Double.parseDouble(vista.txtPriceProduct.getText());
        
        p.setIdProduct(id);
        p.setNameProduct(name);
        p.setCategoryProduct(category);
        p.setFlavorProduct(flavor);
        p.setPriceProduct(price);
        int r = cp.modify(p);
        if (r==1) {
            JOptionPane.showMessageDialog(vista, "Registro modificado!");
        }else{
            JOptionPane.showMessageDialog(vista, "Error");
        }
    }
    public void agregar(){
        String name = vista.txtNameProduct.getText();
        String category = (String) vista.CbxCategoryProduct.getSelectedItem();
        String flavor = vista.txaFlavorProduct.getText();
        Double price = Double.parseDouble(vista.txtPriceProduct.getText());
        p.setNameProduct(name);
        p.setCategoryProduct(category);
        p.setFlavorProduct(flavor);
        p.setPriceProduct(price);
        int r =cp.register(p);
        if (r==1) {
            JOptionPane.showMessageDialog(vista, "Registro agregado!");
        }else{
            JOptionPane.showMessageDialog(vista, "Error");
        }
    }
    public void listar(JTable tabla){
        modelo=(DefaultTableModel)tabla.getModel();
        List <Products> lista = cp.Listar();
        Object [] object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0]= lista.get(i).getIdProduct();
            object[1]= lista.get(i).getNameProduct();
            object[2]= lista.get(i).getCategoryProduct();
            object[3]= lista.get(i).getFlavorProduct();
            object[4]= lista.get(i).getPriceProduct();
            modelo.addRow(object);
        }
        vista.jProducts.setModel(modelo);
    }

    
}
