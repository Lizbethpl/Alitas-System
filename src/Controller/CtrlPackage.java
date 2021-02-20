
package Controller;

import Model.ConsultPackage;
import Model.Package;
import View.Packagesfrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class CtrlPackage implements ActionListener{
    Package pack = new Package();
    ConsultPackage cpack= new ConsultPackage();
    Packagesfrm vistapack = new Packagesfrm();
    DefaultTableModel modelo = new DefaultTableModel(); 
    
    public CtrlPackage(Package pack,ConsultPackage cpack,Packagesfrm vistapack,DefaultTableModel modelo) {
        this.pack = pack;
        this.cpack = cpack;
        this.vistapack = vistapack;
        this.modelo = modelo;
        
        this.vistapack.btnGuardar.addActionListener(this);
        this.vistapack.btnModificar.addActionListener(this);
        this.vistapack.btnEliminar.addActionListener(this);
        listar(vistapack.jPackages);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== vistapack.btnGuardar) {
            agregar();
            limpiarTabla();
            limpiarCajas();
            listar(vistapack.jPackages);
        }if (e.getSource()== vistapack.btnModificar) {
            actualizar();
            limpiarTabla();
            listar(vistapack.jPackages);
            limpiarCajas();
        }if (e.getSource()== vistapack.btnEliminar) {
            eliminar();
            limpiarTabla();
            listar(vistapack.jPackages); 
            limpiarCajas();
        }
    }
    void limpiarTabla() {
        for (int i = 0; i < vistapack.jPackages.getRowCount(); i++) {
            modelo.removeRow(i);
            i=i-1;
        }
    }
    void limpiarCajas(){
        vistapack.txtIdPackage.setText(null);
        vistapack.txtNamePackage.setText(null);
        vistapack.txtProductsPackage.setText(null);
        vistapack.txtPricePackage.setText(null);
    }
    public void eliminar() {
        int fila = vistapack.jPackages.getSelectedRow();
            
            if (fila==1) {
                JOptionPane.showMessageDialog(vistapack, "Debe seleccionar un registro");
        } else {
                int id = Integer.parseInt((String)vistapack.jPackages.getValueAt(fila,3).toString());
                cpack.delete(id);
                JOptionPane.showMessageDialog(vistapack, "Registro eliminado");
        }
    }    
    public void actualizar(){
        int id = Integer.parseInt(vistapack.txtIdPackage.getText());
        String name = vistapack.txtNamePackage.getText();
        String description = vistapack.txtProductsPackage.getText();
        Double price = Double.parseDouble(vistapack.txtPricePackage.getText());
        
        pack.setId_package(id);
        pack.setName_package(name);
        pack.setDescription_package(description);
        pack.setPrice_package(price);
        int r = cpack.modify(pack);
        if (r==1) {
            JOptionPane.showMessageDialog(vistapack, "Registro modificado!");
        }else{
            JOptionPane.showMessageDialog(vistapack, "Error");
        }
    }
    public void agregar(){
        String name = vistapack.txtNamePackage.getText();
        String description = vistapack.txtProductsPackage.getText();
        Double price = Double.parseDouble(vistapack.txtPricePackage.getText());
        pack.setName_package(name);
        pack.setDescription_package(description);
        pack.setPrice_package(price);
        int r =cpack.register(pack);
        if (r==1) {
            JOptionPane.showMessageDialog(vistapack, "Registro agregado!");
        }else{
            JOptionPane.showMessageDialog(vistapack, "Error");
        }
    }
    public void listar(JTable tabla){
        modelo=(DefaultTableModel)tabla.getModel();
        List <Package> lista = cpack.Listar();
        Object [] object = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            
            object[0]= lista.get(i).getName_package();
            object[1]= lista.get(i).getDescription_package();
            object[2]= lista.get(i).getPrice_package();
            object[3]= lista.get(i).getId_package();
            modelo.addRow(object);
        }
        vistapack.jPackages.setModel(modelo);
    }
}
