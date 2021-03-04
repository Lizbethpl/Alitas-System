
package Controller;

import Model.Additional;
import Model.ConsultAdditional;
import Model.ConsultPackage;
import Model.ConsultProducts;
import Model.ConsultSale;
import Model.ConsultSaleView;
import Model.ConsultSaleViews;
import Model.ConsultUser;
import Model.DateSys;
import Model.Login;
import Model.Products;
import Model.User;
import View.FrmLogin;
import View.Packagesfrm;
import View.Productsfrm;
import View.Project_Menu;
import View.frmUsers;
import javax.swing.table.DefaultTableModel;
import Model.Package;
import Model.Sale;
import Model.Shift;
import Model.sale_products;
import View.Menufrm;
import View.SaleDetailsfrm;
import View.SalesMenufrm;
import View.SalesViewfrm;
import View.SalesViewsfrm;
import View.frmTicketSave;

import javax.swing.DefaultListModel;

/*class Us {
    User modUs = new User();
        ConsultUser modC = new ConsultUser();
        frmUsers frmUs = new frmUsers();
        DateSys datS = new DateSys();
        
    public void User() { 
     
        CtrlUser ctrl = new CtrlUser(modUs,modC,frmUs,datS);
        ctrl.iniciar();
        frmUs.setVisible(true);
    }
}*/

public class CtrlPrincipal{
    /*User modUs;
    Login modLog;   
    FrmLogin frmLog;*/
    Login modLog = new Login();
    User modUs = new User(); 
    FrmLogin frmLog = new FrmLogin();
    
    ConsultUser modC = new ConsultUser();
    DateSys datS = new DateSys();
    frmUsers frmUs = new frmUsers();
    
    
    Products modP = new Products();
    Productsfrm frmProduct = new Productsfrm();
    DefaultTableModel TbModelo = new DefaultTableModel();
    ConsultProducts modCP = new ConsultProducts(); //conexion no cerrada
    
    Package pack = new Package();
    Packagesfrm frmPack = new Packagesfrm();
    ConsultPackage modPack= new ConsultPackage(); //conexion no cerrada
    DefaultTableModel modelo = new DefaultTableModel();
    
    Sale sale = new Sale();
    Menufrm frmsale = new Menufrm();
    ConsultSale csale = new ConsultSale(); // conexion no cerrada
    DefaultTableModel modelos = new DefaultTableModel();
    
    sale_products salep = new sale_products();
    SaleDetailsfrm frmsaledetails = new SaleDetailsfrm(); // conexion no cerrada
    DefaultListModel modelolist = new DefaultListModel();
    Shift s = new Shift();
    
    sale_products spv = new sale_products();
    SalesViewfrm frmsaleview = new SalesViewfrm();
    ConsultSaleView csv = new ConsultSaleView(); // conexion no cerrada
    DefaultTableModel modelov = new DefaultTableModel();
    
    Sale sales = new Sale();
    ConsultSaleViews csvs = new ConsultSaleViews(); // conexion no cerrada, 2 conexiones abiertas
    SalesViewsfrm frmsaleviews = new SalesViewsfrm();
    DefaultTableModel modelovs = new DefaultTableModel();
    
    Additional add = new Additional();
    ConsultAdditional cadd= new ConsultAdditional(); //conexion no cerrada
    DefaultTableModel modeloadd = new DefaultTableModel();
    
    DefaultTableModel modTicket = new DefaultTableModel();
    frmTicketSave frmTicket = new frmTicketSave();
    
    //------------- Conexiones revisadas --------
    public void Login(){
        //Us us = new Us();
        //CtrlLogin ctrl = new CtrlLogin(modUs, modLog, frmLog, us);
        CtrlLogin ctrl = new CtrlLogin(modUs, modLog, frmLog);
        ctrl.iniciar();
        frmLog.setVisible(true);
    }
    
    public void User() {            
        CtrlUser ctrl = new CtrlUser(modUs,modC,frmUs,datS);
        ctrl.iniciar();
        frmUs.setVisible(true);
    }
    
    public void ProductMenu(){
        Project_Menu v = new Project_Menu();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }
    
    public void Product(){
        CtrlProducts con = new CtrlProducts(modP, modCP, TbModelo, frmProduct );
        frmProduct.setVisible(true);
        frmProduct.setLocationRelativeTo(null);       
    }
    
    public void Packages(){
        
        CtrlPackage con = new CtrlPackage(pack,modPack,frmPack,add,cadd,modelo,modeloadd);
        frmPack.setVisible(true);
        frmPack.setLocationRelativeTo(null);
    }
    public void Sale(){
        
        CtrlSale con = new CtrlSale(sale,csale,frmsale,modelos);
        frmsale.setVisible(true);
        frmsale.setLocationRelativeTo(null);
    }
    public void SaleDetails(){      
        CtrlSaleDetails con = new CtrlSaleDetails(salep,s,csale, frmsaledetails,modelolist);
        frmsaledetails.setVisible(true);
        frmsaledetails.setLocationRelativeTo(null);
    }
    public void SalesMenu(){
        SalesMenufrm v = new SalesMenufrm();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }
    
    public void SaleView(){
        CtrlSaleView con = new CtrlSaleView(spv,csv,frmsaleview,modelov);
        frmsaleview.setVisible(true);
        frmsaleview.setLocationRelativeTo(null);       
    }
    public void SaleViews(){
        CtrlSaleViews con = new CtrlSaleViews(sales,csvs,frmsaleviews,modelovs);
        frmsaleviews.setVisible(true);
        frmsaleviews.setLocationRelativeTo(null); 
    }
    public void printTicket(int numOrd, String clientName){
        CtrlTicket ctrlTick = new CtrlTicket(csale,numOrd, clientName);
        ctrlTick.listData();
        //ctrlTick.saveTicke();
    }
    
    public void printTicketC(int numOrd, String clientName){
        CtrlTicket ctrlTick = new CtrlTicket(csale,numOrd, clientName);
        ctrlTick.listDataC();
        //ctrlTick.saveTicke();
    }
    
    public void printTicketR(int numOrd, String clientName){
        CtrlTicket ctrlTick = new CtrlTicket(csale,numOrd, clientName);
        ctrlTick.listDataR();
        //ctrlTick.saveTicke();
    }
    
    
    public void saveTicket (){
        CtrlTicketSaved ctrlTickS = new CtrlTicketSaved(csale,modTicket,frmTicket); 
        ctrlTickS.listarTick();
        frmTicket.setVisible(true);
    }
    
    public void deleteTicket(int numOrd){
        CtrlTicketSaved ctrlTickS = new CtrlTicketSaved(csale,modTicket,frmTicket);
        ctrlTickS.deleteTick(numOrd);
      
  
    }
    
    public static void main(String[] args) {
        CtrlPrincipal principal = new CtrlPrincipal();
        principal.Login();
     
        
    }
    
    
}
