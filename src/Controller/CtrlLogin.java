package Controller;

import Model.DateSys;
import Model.Login;
import Model.User;
import View.FrmLogin;
import View.frmUsers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Controller.CtrlPrincipal;



public class CtrlLogin implements ActionListener{
    /*private User modU;*/

    private User modUs;
    private Login modLog ;
    private FrmLogin frmLog;
    frmUsers frmUs = new frmUsers();
    DateSys datS = new DateSys();
    CtrlPrincipal principal = new CtrlPrincipal();
    
    

    
    public CtrlLogin(User modUs,Login modLog, FrmLogin frmLog){
        this.modUs = modUs;
        this.modLog = modLog;
        this.frmLog = frmLog;
        
        
        this.frmLog.btnInto.addActionListener(this);
        this.frmLog.btnCancel.addActionListener(this);
        System.out.println("Ec");
    }
    
    public void iniciar(){
        frmLog.setTitle("User");
        frmLog.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {  
        if(e.getSource() == frmLog.btnInto){
            modUs.setName(frmLog.txtUser.getText());           
            modUs.setPassword(String.valueOf(frmLog.txtPassword.getPassword())); 
            if(modLog.log(modUs)){               
                frmLog.dispose();
                principal.User();
                /*frmUs.setVisible(true); */            
                
                JOptionPane.showMessageDialog(null,"Ingreso exitoso");
                
            }else{
                JOptionPane.showMessageDialog(null, "Error al ingresar");
            }    
                       
        }           
        
        if(e.getSource() == frmLog.btnCancel){ 
            int result = JOptionPane.showConfirmDialog(frmLog,"¿Deseas salir?","¡Alerta!",JOptionPane.YES_NO_OPTION);
            System.out.println(result);
            if (result == 0){
                System.exit(0);
            }
        }
        
    }
}
    


