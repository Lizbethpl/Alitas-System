
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.ConsultUser;
import Model.User;
import View.frmUsers;
import Model.DateSys;  



public class CtrlUser implements ActionListener {

    private User modU;
    private ConsultUser modC;
    private frmUsers frmU;
    private DateSys datS;
    DefaultTableModel modelo = new DefaultTableModel();
    public CtrlUser(User modU, ConsultUser modC, frmUsers frmU,DateSys datS){
        System.out.println("Controlador usuarios");
        this.modU = modU;
        this.modC = modC;
        this.frmU = frmU;
        this.datS = datS;
        
        //this.frmU.btnSave.addActionListener(this);
        this.frmU.btnUpdate.addActionListener(this);
        this.frmU.btnAdd.addActionListener(this);
        this.frmU.btnDelete.addActionListener(this);
        //this.frmU.btnLogOut.addActionListener(this);
        listar(frmU.jUsers);
    }
    
    public void iniciar(){
        frmU.setTitle("User");
        frmU.setLocationRelativeTo(null);
    }
    public void listar(JTable tabla){
        modelo=(DefaultTableModel)tabla.getModel();
        List <User> lista = modC.Listar();
        Object [] object = new Object[9];
        for (int i = 0; i < lista.size(); i++) {
            object[0]= lista.get(i).getId();
            object[1]= lista.get(i).getName();
            object[2]= lista.get(i).getLastNameP();
            object[3]= lista.get(i).getLastNameM();
            object[4]= lista.get(i).getPhoneNumber();
            object[5]= lista.get(i).getGender();
            object[6]= lista.get(i).getDateRegister();
            object[7]= lista.get(i).getPassword();
            object[8]= lista.get(i).getId_Tipo();
            modelo.addRow(object);
        }
        frmU.jUsers.setModel(modelo);
    }
    void limpiarTabla() {
        for (int i = 0; i < frmU.jUsers.getRowCount(); i++) {
            modelo.removeRow(i);
            i=i-1;
        }
    }
    void limpiarCajas(){
        frmU.txtID.setText(null);
        frmU.txtName.setText(null);
        frmU.txtLastNameP.setText(null);
        frmU.txtLastNameM.setText(null);
        frmU.txtPhoneNumber.setText(null);
        frmU.txtPassword.setText(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmU.btnProducts){
            frmU.dispose();
        }
        
        if(e.getSource() == frmU.btnAdd){
            
          String tipo = (String) frmU.jcUsers.getSelectedItem();
            modU.setName(frmU.txtName.getText());
            modU.setLastNameP(frmU.txtLastNameP.getText());
            modU.setLastNameM(frmU.txtLastNameM.getText());
            modU.setPhoneNumber(frmU.txtPhoneNumber.getText());
            modU.setGender(frmU.gender());    
            modU.setDateRegister(datS.getDateSys());
            modU.setPassword(frmU.txtPassword.getText());
            modU.setId_Tipo(Integer.parseInt(tipo));
            
            try {
                if(modC.Register(modU)){
                    JOptionPane.showMessageDialog(null,"Registro Añadido");
                    limpiarTabla();
                    listar(frmU.jUsers);
                    limpiarCajas();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error al Añadido");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == frmU.btnUpdate){
            
            String tipo = (String) frmU.jcUsers.getSelectedItem();
            modU.setName(frmU.txtName.getText());
            modU.setLastNameP(frmU.txtLastNameP.getText());
            modU.setLastNameM(frmU.txtLastNameM.getText());
            modU.setPhoneNumber(frmU.txtPhoneNumber.getText());
            modU.setGender(frmU.gender());
            modU.setDateRegister(datS.getDateSys());
            modU.setPassword(frmU.txtPassword.getText());
            modU.setId_Tipo(Integer.parseInt(tipo));
            modU.setId(Integer.parseInt(frmU.txtID.getText()));
            
            if(modC.UpdateD(modU)){
                JOptionPane.showMessageDialog(null,"Registro Actualizado");
                limpiarTabla();
                listar(frmU.jUsers);
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null,"Error al Actualizar");
            }           
        }
        
        if(e.getSource() == frmU.btnDelete){
            modU.setId(Integer.parseInt(frmU.txtID.getText()));
                   
                if(modC.Delete(modU)){
                    JOptionPane.showMessageDialog(null,"Registro Eliminado");
                    limpiarTabla();
                    listar(frmU.jUsers);
                    limpiarCajas();
                }else{              
                    JOptionPane.showMessageDialog(null,"Error al Eliminar");               
            } 
        }
        
    }               
}
    
    
    

