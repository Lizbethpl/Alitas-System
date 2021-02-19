
package Controller;

import Model.ConsultPackage;
import Model.ConsultProducts;
import Model.ConsultSale;
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
import Model.sale_products;
import View.Menufrm;
import View.SaleDetailsfrm;
import View.SalesMenufrm;

import javax.swing.DefaultListModel;

public class CtrlPrincipal {
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
    ConsultProducts modCP = new ConsultProducts();
    
    Package pack = new Package();
    Packagesfrm frmPack = new Packagesfrm();
    ConsultPackage modPack= new ConsultPackage();
    DefaultTableModel modelo = new DefaultTableModel();
    
    Sale sale = new Sale();
    Menufrm frmsale = new Menufrm();
    ConsultSale csale = new ConsultSale();
    DefaultTableModel modelos = new DefaultTableModel();
    
    sale_products salep = new sale_products();
    SaleDetailsfrm frmsaledetails = new SaleDetailsfrm();
    DefaultListModel modelolist = new DefaultListModel();
    
    
    public void Login(){
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
        
        CtrlPackage con = new CtrlPackage(pack,modPack,frmPack,modelo);
        frmPack.setVisible(true);
        frmPack.setLocationRelativeTo(null);
    }
    public void Sale(){
        
        CtrlSale con = new CtrlSale(sale,csale,frmsale,modelos);
        frmsale.setVisible(true);
        frmsale.setLocationRelativeTo(null);
    }
    public void SaleDetails(){      
        CtrlSaleDetails con = new CtrlSaleDetails(csale, frmsaledetails, salep,modelolist);
        frmsaledetails.setVisible(true);
        frmsaledetails.setLocationRelativeTo(null);
    }
    public void SalesMenu(){
        SalesMenufrm v = new SalesMenufrm();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }
    
    
    
    /*public void Package(){
        pack.setVisible(true);
        pack.setLocationRelativeTo(pack);
    }*/
    
    public static void main(String[] args) {
        CtrlPrincipal principal = new CtrlPrincipal();
        principal.Login();
               
        
    }
    
    
}
