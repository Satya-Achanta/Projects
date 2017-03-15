package general;

import java.util.ArrayList;
import java.util.List;



public class ArrayListAsArgument
{

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

        List<String> argList = new ArrayList<String>();
        
        for ( int i = 0; i < 7; i++ )
        {
            argList.add( "" );
        }
        
        argList.set(1,"ABC1");
        addValuesToArrayList(argList);
        argList.set(5,"ABC5");
        argList.set(6,"ABC6");
        System.out.println(argList);
        
    }
    
    public static void addValuesToArrayList(List<String> argList){
        
        argList.set(2,"ABC2");
        argList.set(3,"ABC3");
        argList.set(4,"ABC4");
        
    }

}
