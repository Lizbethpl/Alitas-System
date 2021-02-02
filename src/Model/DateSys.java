
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DateSys{
    
    public String getDateSys(){
        
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    java.util.Date date = new java.util.Date();
        
    
    return dateFormat.format(date);
    } 
    
}
