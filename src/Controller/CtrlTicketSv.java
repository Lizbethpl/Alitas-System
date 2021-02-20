package Controller;
import View.frmTicketSave;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CtrlTicketSv implements ActionListener {
    frmTicketSave frmTicket = new frmTicketSave();
    List tick = new ArrayList();
    
    public CtrlTicketSv(){
        this.frmTicket.btnPrint.addActionListener(this);
    }
    
    public void print(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
