
package Controller;

import Model.ConsultSale;
import Model.Sale;
import Model.sale_products;
import View.Menufrm;
import View.SaleDetailsfrm;
import View.frmTicketSave;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class CtrlTicket{
    private ConsultSale csale;
    private sale_products salep;
    private DefaultTableModel modTicket;
    int NumOrd;
    String printData = "";
    String printPrice = "";
    String valueFinal;
    List myList = new ArrayList();
    List mySecondList = new ArrayList();
    List myListP = new ArrayList();
    List mySecondListP = new ArrayList();
    
    public CtrlTicket(ConsultSale csale,sale_products salep,DefaultTableModel modTicketn,int numOrd){
        this.csale = csale;
        this.salep = salep;
        this.modTicket = modTicket;
        this.NumOrd = numOrd;
       
    } 
    
    public void completeArray(List<String> lista){
        
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).length() <= 22){
                int result = 22 - lista.get(i).length();   
                for(int x =0; result > x; x++){
                printData += " ";               
                }              
            }     
            //valueFinal += lista.get(i) + printData;           
            myListP.add(lista.get(i) + printData);
            valueFinal= "";
            printData = "";
        }     
    }
    
    public String listDat(List<String> listas){       
        String printDat = "";
        int resulte = 0;
        for (int i = 0; i < myListP.size(); i++) {
            if(listas.get(i).length() < 7){
                resulte = 7 - listas.get(i).length();            
            }
  
            for(int x =0; resulte > 0; resulte--){
                printDat += " ";
            }
            //valueFinal += carsNew.get(i) + "    " + printData + "$" + price.get(i) + "\n";         
            mySecondListP.add(printDat + "$" + mySecondList.get(i));
            printDat = "";           
        }
        
        System.out.println(valueFinal.length());
        
        
        return valueFinal;
    }
    
    public void print(){
        CtrlPrintTicket tick = new CtrlPrintTicket("A LAS ALITAS","Juan","Orden 13","18-02-2021",printData,
                    "3","100","200");
            tick.print();
    }
    
    public void listData(){
        int id = NumOrd;
            List <Sale> lista = csale.Listar(id);
            
            
            for (int i = 0; i < lista.size(); i++) {
                myList.add(lista.get(i).getName_sproduct());
                mySecondList.add(Double.toString(lista.get(i).getTotal_sproduct()));
            }
            
            completeArray(myList);
            listDat(mySecondList);
            System.out.println(myListP);
            System.out.println(mySecondListP);
            for (int i = 0; i < lista.size(); i++) {
                printData += myListP.get(i) +""+ mySecondListP.get(i) +"\n";
                
            }
            print();
    }  
}
