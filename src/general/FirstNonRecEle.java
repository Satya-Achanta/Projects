package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstNonRecEle
{

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

        FirstNonRecEle obj = new FirstNonRecEle();
        List<String> inputList = obj.getInputList();

        //Alternative - for List creation
        //List<String> inputList1 = Arrays.asList("a","b", "c", "x","a","b", "c", "z","b", "c", "y","a","b", "c", "x");

        String firstNonRecurringelement = obj.getFirstNonRecurringElement( inputList );
        if ( firstNonRecurringelement.isEmpty() )
        {
            System.out.println( "Given list doesn't have a non-recurring element" );
        }
        else
        {
            System.out.println( "First non-recurring element in the given list is: "
                                + firstNonRecurringelement );
        }

        String mostRecurringelement = obj.getMostRecurringElement( inputList );
        System.out.println( "Most recurring element in the given list is: "
                            + mostRecurringelement );

    }

    private String getFirstNonRecurringElement( List<String> inputList )
    {

        Map<String, Integer> elementsMap = getElementCountMap( inputList );

        System.out.println( "Element and it's count : " + elementsMap );

        // Iterating through inputList to find the first occurrence of element
        // whose count is 1 (non recurring)
        for ( String element : inputList )
        {

            Integer count = elementsMap.get( element );

            if ( count == 1 )
            {

                return element;
            }

        }

        return "";

    }

    private String getMostRecurringElement( List<String> inputList )
    {

        Map<String, Integer> elementsMap = getElementCountMap( inputList );

        int max = 0;
        String mostRecurringEle = "";

        // Iterating through inputList to find the most recurring element
        for ( String element : inputList )
        {
            Integer count = elementsMap.get( element );

            if ( count > max )
            {
                max = count;
                mostRecurringEle = element;
            }
        }

        return mostRecurringEle;

    }

    private Map<String, Integer> getElementCountMap( List<String> inputList )
    {

        Map<String, Integer> elementsMap = new HashMap<String, Integer>();

        // Iterating through inputList to get the count of each element
        for ( String element : inputList )
        {

            Integer count = elementsMap.get( element );

            if ( count != null )
            {
                count++;
                elementsMap.put( element,
                                 count );
            }
            else
            {
                elementsMap.put( element,
                                 1 );
            }
        }

        return elementsMap;

    }

    public List<String> getInputList()
    {

        List<String> inputList = new ArrayList<String>();

        inputList.add( "a" );
        inputList.add( "b" );
        inputList.add( "c" );
        inputList.add( "x" );
        inputList.add( "a" );
        inputList.add( "b" );
        inputList.add( "c" );
        inputList.add( "y" );
        inputList.add( "b" );
        inputList.add( "c" );
        inputList.add( "z" );
        inputList.add( "a" );
        inputList.add( "b" );
        inputList.add( "c" );
        inputList.add( "x" );

        return inputList;
    }

}
