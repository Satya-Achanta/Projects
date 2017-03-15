package HackerRank;

import java.util.Scanner;


public class Kangaroos
{

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        
        Scanner sc = new Scanner(System.in);
        
        //velocity for each kangaroo
        System.out.print("Enter the velocity of 1st kangaroo : ");
        long v1 = sc.nextLong();
                
        System.out.print("Enter the velocity of 2nd kangaroo : ");
        long v2 = sc.nextLong();
        
        // starting distances
        System.out.print("Enter the start index of 1st kangaroo : ");
        long x1 = sc.nextLong();
        System.out.print("Enter the start index of 2nd kangaroo : ");
        long x2 = sc.nextLong();
        
        if(x2<x1){
            System.out.println("Data is invalid");
        }
        
        long gcd;
        
        if(v1<v2){
            System.out.println("Two kangaroos can never meet ;) ");
            return;
        }else{
            gcd = new Kangaroos().gcd( v1, v2 );
        }
        
        
        if(gcd%(x2-x1) == 0){
            System.out.println("Two Kangaroos can meet :) ");
        }else{
            System.out.println("Two kangaroos cannot meet at a common point :( ");
        }
        
    }
    
    //assuming a>b
    private long gcd(long a, long b){
        
        while (b > 0)
        {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private String xyz(){
        return "satya";
    }
    

}
