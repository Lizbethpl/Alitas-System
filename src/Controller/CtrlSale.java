/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CargarComboCategory;
import Model.ConsultSale;
import Model.DateSys;
import Model.Products;
import Model.Sale;
import Model.sale_products;
import View.Menufrm;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class CtrlSale implements ActionListener {
    
    Sale sale = new Sale();
    ConsultSale csale= new ConsultSale();
    Menufrm frmsale = new Menufrm();
    DefaultTableModel modelo = new DefaultTableModel(); 
    sale_products salep = new sale_products();
    DateSys date= new DateSys();
    public CtrlSale(Sale sale, ConsultSale csale, Menufrm frmsale,DefaultTableModel modelo) {
        this.sale= sale;
        this.frmsale=frmsale;
        this.csale= csale;
        this.modelo=modelo;
        this.frmsale.btnAddAlitas.addActionListener(this);
        this.frmsale.btnAddBoneless.addActionListener(this);
        this.frmsale.btnAddBurger.addActionListener(this);
        this.frmsale.btnAddPotatoes.addActionListener(this);
        this.frmsale.btnAddDrink.addActionListener(this);
        this.frmsale.btnAddDesserts.addActionListener(this);
        this.frmsale.btnTotal.addActionListener(this);
        this.frmsale.btnLimpiar.addActionListener(this);
        //this.frmsale.btnAddPotatoesAdditional.addActionListener(this);
        //this.frmsale.btnAddPotatoesBurguer.addActionListener(this);
        this.frmsale.btnDeleteProduct.addActionListener(this);
        this.frmsale.btnAddPackages.addActionListener(this);
        this.frmsale.btnPagar.addActionListener(this);
        //listar(frmsale.jSale);
        listarOrden();
        frmsale.jSale.getColumnModel().getColumn(2).setMaxWidth(0);
        frmsale.jSale.getColumnModel().getColumn(2).setMinWidth(0);
        frmsale.jSale.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== frmsale.btnAddAlitas) {
            agregar();
            limpiarTabla();
            listar(frmsale.jSale);
            limpiarCajas();
            //frmsale.txtTotalPrice.setText(Double.toString(csale.totalPrice(Integer.parseInt(frmsale.txtNumOrder.getText()))));
        }
        if (e.getSource()== frmsale.btnAddBoneless) {
            agregarBoneless();
            limpiarTabla();
            listar(frmsale.jSale);
            limpiarCajas();
            
        }if (e.getSource()== frmsale.btnAddBurger) {
            agregarHamburguesa();
            limpiarTabla();
            listar(frmsale.jSale);
            limpiarCajas();
            
        }if (e.getSource()== frmsale.btnAddPotatoes) {
            agregarPapas();
            limpiarTabla();
            listar(frmsale.jSale);
            limpiarCajas();
            
        }if (e.getSource()== frmsale.btnAddDrink) {
            agregarBebidas();
            limpiarTabla();
            listar(frmsale.jSale);
            limpiarCajas();
            
        }if (e.getSource()== frmsale.btnAddDesserts) {
            agregarDesserts();
            limpiarTabla();
            listar(frmsale.jSale);
            limpiarCajas();
            
        }if (e.getSource()== frmsale.btnTotal) {
            frmsale.txtTotalPrice.setText(Double.toString(csale.totalPrice(Integer.parseInt(frmsale.txtNumOrder.getText()))));
            
        }if (e.getSource()== frmsale.btnLimpiar) {
            eliminar();
            limpiarTabla();
            listar(frmsale.jSale);
            limpiarCajas();
        }
        if (e.getSource()== frmsale.btnDeleteProduct) {
            eliminarProducto();
            limpiarTabla();
            listar(frmsale.jSale);
            limpiarCajas();
        }
//        if (e.getSource()== frmsale.btnAddPotatoesAdditional) {
//            agregarPapasExtra();
//            limpiarTabla();
//            listar(frmsale.jSale);}
//        if (e.getSource()== frmsale.btnAddPotatoesBurguer) {
//            agregarPapasExtra();
//            limpiarTabla();
//            listar(frmsale.jSale);
//        }
        if (e.getSource()== frmsale.btnAddPackages) {
            agregarPackages();
            limpiarTabla();
            listar(frmsale.jSale);
        }
        if (e.getSource()== frmsale.btnPagar) {
            agregarVentaProducto();
        }
    }
    void limpiarTabla() {
        for (int i = 0; i < frmsale.jSale.getRowCount(); i++) {
            modelo.removeRow(i);
            i=i-1;
        }
    }
//    void limpiarTabla() {
//        for (int i = 0; i < frmsale.jSale.getRowCount(); i++) {
//            modelo.removeRow(i);
//            i=i-1;
//        }
//    }
    void limpiarCajas(){
        frmsale.jcFlavorsAlitas.setSelectedIndex(0);
        frmsale.jSpLotAlitas.setValue(1);
        frmsale.txtDescriptionAlitas.setText(null);
        frmsale.jcFlavorsB.setSelectedIndex(0);
        frmsale.jsLotBoneless.setValue(1);
        frmsale.txtDescriptionBoneless.setText(null);
        frmsale.jcTypeBurger.setSelectedIndex(0);
        frmsale.JSLotBurger.setValue(1);
        frmsale.txtDescriptionBurger.setText(null);
        frmsale.jcPotatoes.setSelectedIndex(0);
        frmsale.jsLotPotatoes.setValue(1);
        frmsale.txtDescriptionPotatoes.setText(null);
        frmsale.jcDrinks.setSelectedIndex(0);
        frmsale.jSLotDrink.setValue(1);
        frmsale.txtDescriptionDrink.setText(null);
        frmsale.jcDesserts.setSelectedIndex(0);
        frmsale.jSLotDesserts.setValue(1);
        frmsale.txtDescriptionDesserts.setText(null);
        frmsale.jcPackages.setSelectedIndex(0);
        frmsale.jSLotPackages.setValue(1);
        frmsale.txtDescriptionPackages.setText(null);
        
        frmsale.txtTotalPrice.setText(null);
        frmsale.jrPapas.setSelected(false);
        frmsale.jPapasH.setSelected(false);
        
    }
    public void listar(JTable tabla){
        int id = Integer.parseInt(frmsale.txtNumOrder.getText());
        modelo=(DefaultTableModel)tabla.getModel();
        List <Sale> lista = csale.Listar(id);
        Object [] object = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            object[0]= lista.get(i).getName_sproduct();
            object[1]= lista.get(i).getTotal_sproduct();
            object[2]= lista.get(i).getId();
            modelo.addRow(object);
        }
        frmsale.jSale.setModel(modelo);
    }
    public void agregar(){
        Double price_alitas = csale.priceAlitas();
        String flavor = (String) frmsale.jcFlavorsAlitas.getSelectedItem();
        Integer lot = (Integer) frmsale.jSpLotAlitas.getValue();
        String description = frmsale.txtDescriptionAlitas.getText();
        //Double total = Double.parseDouble(price_alitas * lot);
        
        //JOptionPane.showInputDialog(frmsale, "Producto agregado!");
        
        Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
        sale.setName_sproduct("ALITAS " + flavor);
        sale.setLot_sproduct(lot);
        sale.setDescription_sproduct(description);
        sale.setTotal_sproduct(price_alitas * lot);
        sale.setSales_id_sale(sale_id);
        int r =csale.register(sale);
        if (r==1) {          
            JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
        }else{
            JOptionPane.showMessageDialog(frmsale, "Error");
        }
    }
    public void agregarBoneless(){
//        Sale est = (Sale) frmsale.jcFlavorsB.getSelectedItem();
//        Double price_boneless = est.getTotal_sproduct();
        Double price_boneless = csale.priceBoneless();
        String flavor = (String) frmsale.jcFlavorsB.getSelectedItem();
        Integer lot = (Integer) frmsale.jsLotBoneless.getValue();
        String description = frmsale.txtDescriptionBoneless.getText();
        //Double total = Double.parseDouble(price_alitas * lot);
        Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
        if(frmsale.jrPapas.isSelected()){
            sale.setName_sproduct("BONELESS "+flavor + " CON PAPAS ");
            sale.setLot_sproduct(lot);
            sale.setDescription_sproduct(description);
            sale.setTotal_sproduct((price_boneless * lot)+10);
            sale.setSales_id_sale(sale_id);
            int r =csale.register(sale);
            if (r==1) {
                JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
            }else{
                JOptionPane.showMessageDialog(frmsale, "Error");
            }
        }else{
                sale.setName_sproduct("BONELESS "+flavor);
            sale.setLot_sproduct(lot);
            sale.setDescription_sproduct(description);
            sale.setTotal_sproduct((price_boneless * lot));
            sale.setSales_id_sale(sale_id);
            int r =csale.register(sale);
            if (r==1) {
                JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
            }else{
                JOptionPane.showMessageDialog(frmsale, "Error");
            }
            }
        
        
        
    }
    public void agregarHamburguesa(){       
        String typeburger = (String) frmsale.jcTypeBurger.getSelectedItem();
        String Additionalburger = (String) frmsale.jcAdditionalBurguer.getSelectedItem();
        Double priceAdditional = 10.0;
        Double price_boneless = csale.priceBurger(typeburger);
        Integer lot = (Integer) frmsale.JSLotBurger.getValue();
        String description = frmsale.txtDescriptionBurger.getText();
        //Double total = Double.parseDouble(price_alitas * lot);  
        
        if(frmsale.jPapasH.isSelected()){
            if (Additionalburger.equals("EXTRAS")) {
            Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
            sale.setName_sproduct(typeburger + "CON PAPAS");
            sale.setLot_sproduct(lot);
            sale.setDescription_sproduct(description);
            sale.setTotal_sproduct((price_boneless * lot)+10);
            sale.setSales_id_sale(sale_id);
            int r =csale.register(sale);
            if (r==1) {
                JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
            }else{
                JOptionPane.showMessageDialog(frmsale, "Error");
            }
        }else{
            Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
            sale.setName_sproduct(typeburger + " "+Additionalburger + " CON PAPAS");
            sale.setLot_sproduct(lot);
            sale.setDescription_sproduct(description);
            sale.setTotal_sproduct(((price_boneless * lot)+ priceAdditional)+10);
            sale.setSales_id_sale(sale_id);
            int r =csale.register(sale);
            if (r==1) {
                JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
            }else{
                JOptionPane.showMessageDialog(frmsale, "Error");
            }
        } 
        }else {
            if (Additionalburger.equals("EXTRAS")) {
            Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
            sale.setName_sproduct(typeburger);
            sale.setLot_sproduct(lot);
            sale.setDescription_sproduct(description);
            sale.setTotal_sproduct(price_boneless * lot);
            sale.setSales_id_sale(sale_id);
            int r =csale.register(sale);
            if (r==1) {
                JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
            }else{
                JOptionPane.showMessageDialog(frmsale, "Error");
            }
        }else{
            Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
            sale.setName_sproduct(typeburger + " "+Additionalburger);
            sale.setLot_sproduct(lot);
            sale.setDescription_sproduct(description);
            sale.setTotal_sproduct((price_boneless * lot)+ priceAdditional);
            sale.setSales_id_sale(sale_id);
            int r =csale.register(sale);
            if (r==1) {
                JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
            }else{
                JOptionPane.showMessageDialog(frmsale, "Error");
            }
        } 
        }
              
    }
    public void agregarPapas(){       
        String typepotatoes = (String) frmsale.jcPotatoes.getSelectedItem();
        Double price_potatoes = csale.pricePotatoes(typepotatoes);
        Integer lot = (Integer) frmsale.jsLotPotatoes.getValue();
        String description = frmsale.txtDescriptionPotatoes.getText();
        //Double total = Double.parseDouble(price_alitas * lot);
        Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
        sale.setName_sproduct(typepotatoes);
        sale.setLot_sproduct(lot);
        sale.setDescription_sproduct(description);
        sale.setTotal_sproduct(price_potatoes * lot);
        sale.setSales_id_sale(sale_id);
        int r =csale.register(sale);
        if (r==1) {
            JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
        }else{
            JOptionPane.showMessageDialog(frmsale, "Error");
        }
    }
    public void agregarBebidas(){
        
        
        String typedrink = (String) frmsale.jcDrinks.getSelectedItem();
        Double price_potatoes = csale.priceDrink(typedrink);
        Integer lot = (Integer) frmsale.jSLotDrink.getValue();
        String description = frmsale.txtDescriptionDrink.getText();
        //Double total = Double.parseDouble(price_alitas * lot);
        Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
        sale.setName_sproduct(typedrink);
        sale.setLot_sproduct(lot);
        sale.setDescription_sproduct(description);
        sale.setTotal_sproduct(price_potatoes * lot);
        sale.setSales_id_sale(sale_id);
        int r =csale.register(sale);
        if (r==1) {
            JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
        }else{
            JOptionPane.showMessageDialog(frmsale, "Error");
        }
    }
    public void agregarDesserts(){
        String typeDesserts = (String) frmsale.jcDesserts.getSelectedItem();
        Double price_desserts = csale.priceDrink(typeDesserts);
        Integer lot = (Integer) frmsale.jSLotDesserts.getValue();
        String description = frmsale.txtDescriptionDesserts.getText();
        //Double total = Double.parseDouble(price_alitas * lot);
        Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
        sale.setName_sproduct(typeDesserts);
        sale.setLot_sproduct(lot);
        sale.setDescription_sproduct(description);
        sale.setTotal_sproduct(price_desserts * lot);
        sale.setSales_id_sale(sale_id);
        int r =csale.register(sale);
        if (r==1) {
            JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
        }else{
            JOptionPane.showMessageDialog(frmsale, "Error");
        }
    }
    public void agregarPackages(){
        String typePackages = (String) frmsale.jcPackages.getSelectedItem();
        Double price_packages = csale.pricePackages(typePackages);
        Integer lot = (Integer) frmsale.jSLotPackages.getValue();
        String description = frmsale.txtDescriptionPackages.getText();
        //Double total = Double.parseDouble(price_alitas * lot);
        Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
        sale.setName_sproduct(typePackages);
        sale.setLot_sproduct(lot);
        sale.setDescription_sproduct(description);
        sale.setTotal_sproduct(price_packages * lot);
        sale.setSales_id_sale(sale_id);
        int r =csale.register(sale);
        if (r==1) {
            JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
        }else{
            JOptionPane.showMessageDialog(frmsale, "Error");
        }
    }
    public void agregarPapasExtra(){    
        String name = "PAPAS EXTRA";
        Double price = 10.0;
        Integer lot = 1;
        String description = "";
        //Double total = Double.parseDouble(price_alitas * lot);
        Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
        sale.setName_sproduct(name);
        sale.setLot_sproduct(1);
        sale.setDescription_sproduct(description);
        sale.setTotal_sproduct(price);
        sale.setSales_id_sale(sale_id);
        int r =csale.register(sale);
        if (r==1) {
            JOptionPane.showMessageDialog(frmsale, "Producto agregado!");
        }else{
            JOptionPane.showMessageDialog(frmsale, "Error");
        }
    }
    public void eliminar() {
        
        int id = Integer.parseInt(frmsale.txtNumOrder.getText());
        csale.delete(id);
        JOptionPane.showMessageDialog(frmsale, "Productos eliminados");
        
    }
    public void eliminarProducto() {
        
        int fila = frmsale.jSale.getSelectedRow();
            
//            if (fila==0) {
//                JOptionPane.showMessageDialog(frmsale, "Debe seleccionar un registro");
//        } else {
                int id = Integer.parseInt((String)frmsale.jSale.getValueAt(fila,2).toString());
                csale.deleteProduct(id);
                JOptionPane.showMessageDialog(frmsale, "Registro eliminado");
        
//    }
    }
    public void agregarVentaProducto(){
     
        String fecha = (date.getDateSys());
        Double total = Double.parseDouble(frmsale.txtTotalPrice.getText());
        String cliente = frmsale.txtNameClient.getText();
        Integer sale_id = Integer.parseInt( frmsale.txtNumOrder.getText());
        
        salep.setDate_sale(fecha);
        salep.setTotal_sale(total);
        salep.setClient_sale(cliente);
        salep.setId_sale_product(sale_id);
        
        int r =csale.registerSale(salep);
        if (r==1) {
            JOptionPane.showMessageDialog(frmsale, "Venta agregada!");
        }else{
            JOptionPane.showMessageDialog(frmsale, "Error");
        }
    }
    public void listarOrden(){
 
        List <Sale> lista = csale.ListarOrden();
        int orden = lista.get(0).getSales_id_sale();
        orden = orden + 1;
        frmsale.txtNumOrder.setText(String.valueOf(orden));
        frmsale.txtNameClient.setText("Orden " + orden);
    }
}
