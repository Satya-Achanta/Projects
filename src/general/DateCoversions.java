package general;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateCoversions
{

    /**
     * @param args
     * @throws ParseException 
     */
    public static void main( String[] args ) throws ParseException
    {
        // TODO Auto-generated method stub
        
/*        
        String startDate = "2016-05-04";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) df.parse(startDate);
        System.out.println("start date "+date);*/
        
 
        
        
       /* String dateStr = "Wed May 04 00:00:00 IST 2016";
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date = (Date)formatter.parse(dateStr);
        System.out.println(date);    */    

       
/*        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                                          String dateInString = "01/01/2015";
                                                          try{
                                                          Date date = formatter.parse(dateInString);
                                                          System.out.println(date);*/
        
String dateStr = "Wed May 04 00:00:00 IST 2016";
        
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date curDate = (Date)formatter.parse(dateStr);


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(curDate);
        
        Date date = (Date)df.parse( s );
        
        System.out.println(s);
        System.out.println(date);


        
       
    }

}
