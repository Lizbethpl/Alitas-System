/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.Doc;
import javax.print.ServiceUI;
import javax.print.attribute.*;

/**
 *
 * @author Pacman
 */
public class CtrlTicket {
    Font font = new Font("MONOSPACED", Font.BOLD, 9);
    //Ticket attribute content
    private String contentTicket = "             SNACKS \n "+
    "{{nameLocal}}\n" +    
    "Av. Zeus 300, Pachuca Hgo\n"+
    "Tel: 771 238 6930\n"+
    "=============================\n"+
    "Nombre: {{clientName}}\n"+
    "No. Orden:  {{ordNum}}\n" +
    "Hora de venta: {{dateTime}}\n"+
    "=============================\n"+
    "{{items}} \n"+
    "=============================\n"+
    "Total: {{total}}\n\n"+    
    "Recibido: {{recibo}}\n"+
    "Cambio: {{change}}\n\n"+
    "=============================\n"+
    "GRACIAS POR SU COMPRA...\n"+
    "ESPERAMOS SU VISITA NUEVAMENTE {{nameLocal}}\n"+
    "\n"+
    "\n"+
    "\n";

  //El constructor que setea los valores a la instancia
  CtrlTicket(String nameLocal, String clientName, String ordNum, String dateTime, String items, String total, String recibo, String change) {
    this.contentTicket = this.contentTicket.replace("{{nameLocal}}", String.format("%20s" , nameLocal));
    this.contentTicket = this.contentTicket.replace("{{clientName}}", clientName);
    this.contentTicket = this.contentTicket.replace("{{ordNum}}", ordNum);
    this.contentTicket = this.contentTicket.replace("{{dateTime}}", dateTime);
    this.contentTicket = this.contentTicket.replace("{{items}}", items);
    this.contentTicket = this.contentTicket.replace("{{total}}", total);
    this.contentTicket = this.contentTicket.replace("{{recibo}}", recibo);
    this.contentTicket = this.contentTicket.replace("{{change}}", change);
  }
    
  public void print() {
    //Especificamos el tipo de dato a imprimir
    //Tipo: bytes; Subtipo: autodetectado
    DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
    
    //Aca obtenemos el servicio de impresion por defatul
    //Si no quieres ver el dialogo de seleccionar impresora usa esto
    //PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
    
    
    //Con esto mostramos el dialogo para seleccionar impresora
    //Si quieres ver el dialogo de seleccionar impresora usalo
    //Solo mostrara las impresoras que soporte arreglo de bits
    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
    PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
    PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
    PrintService service = ServiceUI.printDialog(null, 700, 200, printService, defaultService, flavor, pras);
      
    //Creamos un arreglo de tipo byte
    byte[] bytes;

    //Aca convertimos el string(cuerpo del ticket) a bytes tal como
    //lo maneja la impresora(mas bien ticketera :p)
    bytes = this.contentTicket.getBytes();

    //Creamos un documento a imprimir, a el se le appendeara
    //el arreglo de bytes
    Doc doc = new SimpleDoc(bytes,flavor,null);
      
    //Creamos un trabajo de impresión
    DocPrintJob job = service.createPrintJob();

    //Imprimimos dentro de un try de a huevo
    try {
      //El metodo print imprime
      job.print(doc, null);
        System.out.println("impreso");
    } catch (Exception er) {
      JOptionPane.showMessageDialog(null,"Error al imprimir: " + er.getMessage());
    }
  }
}
