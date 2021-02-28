/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConsultSale;
import Model.DateSys;
import Model.Sale;
import Model.Shift;
import Model.sale_products;
import View.Menufrm;
import View.SaleDetailsfrm;
import static View.SaleDetailsfrm.cambiof;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public final class CtrlSaleDetails implements ActionListener{
    
    ConsultSale csale= new ConsultSale();
    SaleDetailsfrm frmsaledetails = new SaleDetailsfrm();
    sale_products salep = new sale_products();
    DateSys date= new DateSys();
    Menufrm frmsale = new Menufrm();
    DefaultListModel modelo = new DefaultListModel(); 
    Sale sale = new Sale();
    Shift s = new Shift();
    
    public CtrlSaleDetails(sale_products salep,Shift s,ConsultSale csale, SaleDetailsfrm frmsaledetails, DefaultListModel modelo ) {
        this.salep= salep;
        this.frmsaledetails=frmsaledetails;
        this.csale= csale;
        this.frmsale=frmsale;
        this.modelo=modelo;
        this.s=s;
        this.frmsaledetails.btnCancelar.addActionListener(this);
        //this.frmsaledetails.btnRealizar.addActionListener(this);
        listarVenta();
        listarVentaProducto(frmsaledetails.jlistProducts);
        //frmsaledetails.txtCambio.setText("65");
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== frmsaledetails.btnCancelar) {
            eliminar();
            
        } //if (e.getSource()== frmsaledetails.btnRealizar) {
//            
//            agregar();
//       }
        
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
            listModel.addElement(lista.get(i).getName_sproduct()+"  " + lista.get(i).getLot_sproduct()
            + "    "+ lista.get(i).getTotal_sproduct());
        }
        
        //listModel.addElement(lista.get(0).getTotal_sproduct());
        
        frmsaledetails.jlistProducts.setModel(listModel);
    }
    public void eliminar() {
//        int fila = saleviewfrm.jSalesView.getSelectedRow();   
//        int id = Integer.parseInt((String)saleviewfrm.jSalesView.getValueAt(fila,1).toString());
        int id = Integer.parseInt(frmsaledetails.jlOrder.getText().toString());
        csale.deleteSale(id);
        JOptionPane.showMessageDialog(frmsaledetails, "Registro eliminado");
        
    } 
//    public void Cambio(){
//       
////        String recibo = JOptionPane.showInputDialog("Recibo");
////        //System.out.println(recibo);
////        
////        String total = frmsaledetails.jlPrice.getText();
////        double cambio = Double.parseDouble(recibo) - Double.parseDouble(total);
////        frmsaledetails.jlCambio.setText(""+ cambio);
//        JOptionPane.showMessageDialog(null, "Registro eliminado");
//    }
        public void agregar(){
        //System.out.println(frmsaledetails.txtCambio.getText());
        Double cambios = Double.parseDouble(cambiof);
        Integer orden = Integer.parseInt(frmsaledetails.jlOrder.getText());
  
        s.setShift_s(cambios);
        s.setId_sales_shift(orden);
        
        int r =csale.registerShift(s);
//        if (r==1) {          
//            JOptionPane.showMessageDialog(frmsaledetails, "Producto agregado!");
//        }else{
//            JOptionPane.showMessageDialog(frmsaledetails, "Error");
//        }
    }
 
}
