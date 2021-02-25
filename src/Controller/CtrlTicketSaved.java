package Controller;

import Model.ConsultSale;
import Model.Sale;
import Model.sale_products;
import View.frmTicketSave;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CtrlTicketSaved {
    int numOrd;
    ConsultSale csale;
    DefaultTableModel modTicket;
    frmTicketSave frmTicket;
    
    public CtrlTicketSaved (ConsultSale csale,DefaultTableModel modTicket,frmTicketSave frmTicket){
        this.csale = csale;
      
        this.modTicket = modTicket;
        this.frmTicket = frmTicket;
    }
    
    public void listarTick(){
        // pasar numero de orden, inner añadir dato en consulta, nombre cliente
        modTicket=(DefaultTableModel)frmTicket.jTicket.getModel();
        List <sale_products> lista = csale.ListUser();
        Object [] object = new Object[2];
        for (int i = 0; i < lista.size(); i++) {
            object[0]= lista.get(i).getClient_sale();
            object[1]= lista.get(i).getId_sale_product();
            modTicket.addRow(object);
        }
        frmTicket.jTicket.setModel(modTicket);
    }
}
