package versionControl;

public class VersionControlMechanism
{

    int[][] lenghtsArray = null;

    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

        String s1 = "BAD";
        String s2 = "GOOD";

        int l1 = s1.length();
        int l2 = s2.length();

        VersionControlMechanism vcm = new VersionControlMechanism();
        int lcs = vcm.lcsLength( s1,
                                 s2,
                                 l1,
                                 l2 );

        System.out.println( "LCS of " + s1 + " and " + s2 + " is " + lcs );
        System.out.println();

        for ( int i = 0; i <= s1.length(); i++ )
        {
            for ( int j = 0; j <= s2.length(); j++ )
            {
                System.out.print( " " + vcm.lenghtsArray[i][j] + " " );
            }

            System.out.println();
        }

        vcm.printDiff( s1,
                       s2,
                       l1,
                       l2 );

    }

    
    private int lcsLength( String s1,
                           String s2,
                           int l1,
                           int l2 )
    {

        lenghtsArray = new int[l1 + 1][l2 + 1];

        for ( int i = 0; i <= l1; i++ )
        {
            lenghtsArray[i][0] = 0;
        }

        for ( int j = 0; j <= l2; j++ )
        {
            lenghtsArray[0][j] = 0;
        }

        for ( int i = 1; i <= l1; i++ )
        {

            for ( int j = 1; j <= l2; j++ )
            {
                if ( s1.charAt( i - 1 ) == s2.charAt( j - 1 ) )
                {
                    lenghtsArray[i][j] = lenghtsArray[i - 1][j - 1] + 1;
                }
                else
                {
                    lenghtsArray[i][j] = Math.max( lenghtsArray[i][j - 1],
                                                   lenghtsArray[i - 1][j] );
                }
            }
        }
        return lenghtsArray[l1][l2];
    }


    
    private void printDiff( String s1,
                            String s2,
                            int i,
                            int j )
    {

        if ( i > 0 && j > 0 && s1.charAt( i - 1 ) == s2.charAt( j - 1 ) )
        {

            printDiff( s1,
                       s2,
                       i - 1,
                       j - 1 );
            System.out.println( " " + s1.charAt( i - 1 ) );
        }
        else if ( j > 0
                  && (i == 0 || (lenghtsArray[i][j - 1]) >= lenghtsArray[i - 1][j]) )
        {
            printDiff( s1,
                       s2,
                       i,
                       j - 1 );
            System.out.println( "+" + s2.charAt( j - 1 ) );
        }
        else if ( i > 0
                  && (j == 0 || (lenghtsArray[i][j - 1]) < lenghtsArray[i - 1][j]) )
        {
            printDiff( s1,
                       s2,
                       i - 1,
                       j );
            System.out.println( "-" + s1.charAt( i - 1 ) );
        }
        else
        {
            System.out.println();
        }

    }
}
