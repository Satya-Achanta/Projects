package performance;


public class VarArgsCheck
{

    public static void main( String[] args )
    {
        // TODO Auto-generated method stub
        long t = System.currentTimeMillis();
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        
        
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        
        
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        foo("x", "y", "z");
        System.out.println("Var Args ::: "+(System.currentTimeMillis() - t));
        
        t = System.currentTimeMillis();
        
        String temp = "X"+"Y"+"Z";
        
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        
        
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        
        
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        fab(temp);
        
        System.out.println("String Concatenation ::: "+(System.currentTimeMillis() - t));
        
        foo("x", new String[] {  "y", "z"});

    }
    
    
    public static void foo(String name1, String... names)
    {
        System.out.println(name1);
        for(String name : names){
            System.out.println(name);
            
        }
        
    }
    
    public static void fab(String name)
    {
        System.out.println(name);
        
    }
    
    

}
