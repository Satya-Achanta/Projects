package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ListFilesInFolder
{

    public void listFiles( String path,
                           File tempFile )
    {

        BufferedWriter output = null;

        try
        {
            output = new BufferedWriter( new FileWriter( tempFile ) );

            File folder = new File( path );
            File[] listOfFiles = folder.listFiles();

            for ( int i = 0; i < listOfFiles.length; i++ )
            {
                if ( listOfFiles[i].isFile() )
                {
                    output.write( listOfFiles[i].getName() + "\n" );
                    // System.out.println( "File " + listOfFiles[i].getName() );
                }
                /*
                 * else if ( listOfFiles[i].isDirectory() ) { output.write(
                 * listOfFiles[i].getName() + "\n" ); // System.out.println(
                 * "Directory " + // listOfFiles[i].getName() ); }
                 */
            }
            output.flush();

        }
        catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void searchPatternInInstallScript( String filePath,
                                              File tempFile )
                                                             throws FileNotFoundException
    {
        System.out.println( "************************* Start of searchPattern() method. ****************************" );

        File f = new File( filePath );
        BufferedReader installReader = null;
        BufferedReader br = null;

        // String pattern = null;
        String pattern;
        String s = null;
        int count;

        try
        {

            br = new BufferedReader( new FileReader( tempFile ) );

            System.out.println( "Missing Patterns: \n=================================================" );
            while ( (pattern = br.readLine()) != null )
            {
                count = 0;
                installReader = new BufferedReader( new FileReader( f ) );
                // System.out.println( pattern );
                Pattern p = Pattern.compile( pattern );
                while ( (s = installReader.readLine()) != null )
                {

                    Matcher m = p.matcher( s );
                    if ( m.find() )
                    {
                        // System.out.println( "Line: " + s );
                        count++;
                    }

                }
                if ( count == 0 )
                {
                    System.out.println( pattern );

                }
                // System.out.println( count );
            }

        }
        catch ( IOException ex )
        {

            // if any error occurs
            ex.printStackTrace();
        }

    }

    public void generateScript( String path )
    {
        BufferedWriter output = null;
        BufferedWriter outputNodeVariables = null;
        String underscore = "__";
        try
        {
            output = new BufferedWriter( new FileWriter( "C:\\Workspaces\\sqlScript.txt" ) );

            outputNodeVariables = new BufferedWriter( new FileWriter( "C:\\Workspaces\\sqlNodeVariables.txt" ) );

            File folder = new File( path );
            File[] listOfFiles = folder.listFiles();

            for ( int i = 0; i < listOfFiles.length; i++ )
            {
                if ( listOfFiles[i].isFile() )
                {
                    String fileName = listOfFiles[i].getName();
                    String nodevariable = underscore
                                          + fileName.toUpperCase().replace( '.',
                                                                            '_' )
                                          + underscore;

                    String script = "\tif [ $"
                                    + nodevariable
                                    + " = \"Y\" ] || [ $"
                                    + nodevariable
                                    + " = \"y\" ]\n"
                                    + "\tthen\n"
                                    + "\t\ttemplate ' Calling rpaCustomChange to copy the "
                                    + fileName
                                    + " script '\n"
                                    + "\t\trpaCustomChange \"copyScriptToSql\" \""
                                    + fileName
                                    + "\"\n"
                                    + "\telse\n"
                                    + "\t\techo \" INFO: "
                                    + nodevariable
                                    + " parameter is set to N (or) wrong value \\n\"\n"
                                    + "\tfi\n";

                    output.write( "\n" + script + "\n" );
                    outputNodeVariables.write( nodevariable + "\n" );;

                }

            }
            output.flush();
            outputNodeVariables.flush();

        }
        catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void searchPattern()
                               throws IOException
    {
        System.out.println( "************************* Start of searchPattern() method. ****************************" );

        File folder = new File( "C:\\MRE_files\\RPA\\Batch\\bin" );
        File[] listOfFiles = folder.listFiles();
        String underscore = "__";

        /*
         * BufferedWriter output = new BufferedWriter( new FileWriter(
         * "C:\\Workspaces\\binCopyScript.txt" ) ); BufferedWriter
         * outputNodeVariables = new BufferedWriter( new FileWriter(
         * "C:\\Workspaces\\binCopyNodeVariables.txt" ) );
         * 
         * BufferedWriter outputModify = new BufferedWriter( new FileWriter(
         * "C:\\Workspaces\\binModifyScript.txt" ) ); BufferedWriter
         * outputNodeVariablesModify = new BufferedWriter( new FileWriter(
         * "C:\\Workspaces\\binModifyNodeVariables.txt" ) );
         */

        for ( int i = 0; i < listOfFiles.length; i++ )
        {
            if ( listOfFiles[i].isFile() )
            {
                File f = new File( listOfFiles[i].getAbsolutePath().replace( "\\",
                                                                             "\\\\" ) );

                String fileName = listOfFiles[i].getName();
                String nodevariable = underscore
                                      + fileName.toUpperCase().replace( '.',
                                                                        '_' )
                                      + underscore;

                String pattern = "/opt/app/rpa/rpascripts";
                String s = null;

                BufferedReader installReader = null;

                int count = 0;
                installReader = new BufferedReader( new FileReader( f ) );
                // System.out.println( pattern );
                Pattern p = Pattern.compile( pattern );

                int lineNo = 0;

                while ( (s = installReader.readLine()) != null )
                {
                    lineNo++;

                    Matcher m = p.matcher( s );
                    if ( m.find() )
                    {
                        // System.out.println( "Line: " + s );
                        count++;
                        if ( count == 1 )
                        {
                            System.out.println( listOfFiles[i].getName() );

                            String script = "\tif [ $"
                                            + nodevariable
                                            + " = \"Y\" ] || [ $"
                                            + nodevariable
                                            + " = \"y\" ]\n"
                                            + "\tthen\n"
                                            + "\t\ttemplate ' Calling changeProperty module to modify file $ROOTDIR/etc/"
                                            + fileName
                                            + " '\n"
                                            + "\t\tchangeProperty "
                                            + fileName
                                            + " rpa_batch_home.nodevariables bin\n"
                                            + "\telse\n"
                                            + "\t\techo \" INFO: "
                                            + nodevariable
                                            + " parameter is set to N (or) wrong value \\n\"\n"
                                            + "\tfi\n";

                            // outputModify.write( "\n" + script + "\n" );
                            // outputNodeVariablesModify.write( nodevariable +
                            // "\n" );;

                        }
                        System.out.println( "-------------Line:" + lineNo + " "
                                            + s );
                    }

                }

                if ( count == 0 )
                {

                    String script = "\tif [ $"
                                    + nodevariable
                                    + " = \"Y\" ] || [ $"
                                    + nodevariable
                                    + " = \"y\" ]\n"
                                    + "\tthen\n"
                                    + "\t\ttemplate ' Calling rpaCustomChange to copy the "
                                    + fileName
                                    + " script '\n"
                                    + "\t\trpaCustomChange \"copyScriptToBin\" \""
                                    + fileName
                                    + "\"\n"
                                    + "\telse\n"
                                    + "\t\techo \" INFO: "
                                    + nodevariable
                                    + " parameter is set to N (or) wrong value \\n\"\n"
                                    + "\tfi\n";

                    // output.write( "\n" + script + "\n" );
                    // outputNodeVariables.write( nodevariable + "\n" );;

                }

                installReader.close();

            }

        }

        /*
         * output.flush(); outputNodeVariables.flush();
         * 
         * outputModify.flush(); outputNodeVariablesModify.flush();
         * 
         * output.close(); outputNodeVariables.close();
         * 
         * outputModify.close(); outputNodeVariablesModify.close();
         */

    }

    public void searchPatternAndReplace()
                                         throws FileNotFoundException
    {
        System.out.println( "************************* Start of searchPatternAndReplace() method. ****************************" );

        File f = new File( "PropertyFile.properties" );
        BufferedReader br = null;
        BufferedWriter bw = null;

        // String pattern = null;
        String s = null;
        String line = null;

        Map<String, String> propertyRowCountMap = new HashMap<String, String>();

        propertyRowCountMap.put( "prop1",
                                 "xyz1" );
        propertyRowCountMap.put( "prop11",
                                 "abc" );
        propertyRowCountMap.put( "prop14",
                                 "xyz14" );

        try
        {

            bw = new BufferedWriter( new FileWriter( "temp.txt" ) );

            Set<String> keySet = propertyRowCountMap.keySet();
            br = new BufferedReader( new FileReader( f ) );
            while ( (line = br.readLine()) != null )
            {

                s = line.split( "=" )[0];

                if ( keySet.contains( s ) )
                {
                    bw.write( s + "=" + propertyRowCountMap.get( s ) + "\n" );

                }
                else
                {
                    bw.write( line + "\n" );
                }

            }

            bw.flush();

        }
        catch ( IOException ex )
        {

            // if any error occurs
            ex.printStackTrace();
        }

    }

    public static void main( String[] args )
                                            throws IOException

    {

        ListFilesInFolder listFilesInFolder = new ListFilesInFolder();

        listFilesInFolder.searchPatternAndReplace();

        File file = new File( "PropertyFile.properties" );

        /*
         * FileInputStream in = new FileInputStream("PropertyFile.properties");
         * Properties props = new Properties(); props.load(in); in.close();
         * 
         * FileOutputStream out = new
         * FileOutputStream("PropertyFile.properties");
         * props.setProperty("prop1", "india"); props.store(out, null);
         * out.close();
         */

        /*
         * Properties prop = new Properties(); InputStream input = null;
         * 
         * try {
         * 
         * input = new FileInputStream("PropertyFile.properties");
         * 
         * // load a properties file prop.load(input);
         * 
         * // get the property value and print it out
         * System.out.println(prop.getProperty("prop1"));
         * System.out.println(prop.getProperty("dbuser"));
         * System.out.println(prop.getProperty("dbpassword"));
         * 
         * } catch (IOException ex) { ex.printStackTrace(); }
         */

        /*
         * Properties prop = new Properties(); OutputStream output = null;
         * 
         * output = new FileOutputStream("PropertyFile.properties");
         * 
         * // set the properties value prop.setProperty("prop1", "20");
         * 
         * 
         * // save properties to project root folder prop.store(output, null);
         */

        /*
         * String line = null; BufferedReader br = null; br = new
         * BufferedReader(new FileReader("PropertyFile.txt"));
         * 
         * BufferedWriter bw = null; bw = new BufferedWriter(new
         * FileWriter("backup.txt"));
         * 
         * 
         * Set<String> keySet = new HashSet<String>(Arrays.asList("xyz", "b"));
         * 
         * while((line=br.readLine())!=null) { if(keySet.contains( line.split(
         * "=" )[0] )){
         * 
         * } else{
         * 
         * }
         * 
         * }
         * 
         * 
         * 
         * 
         * System.out.println(args[0].split( "=" )[0]);
         */

        // listFilesInFolder.searchPattern();
        // listFilesInFolder.generateScript("C:\\MRE_files\\RPA\\Batch\\sql");

        // File tempFile = new File( "C:\\Workspaces\\temp.txt" );
        // TODO Auto-generated method stub

        // listFilesInFolder.listFiles( args[0],tempFile );
        // listFilesInFolder.searchPatternInInstallScript( args[1],tempFile );

        /*
         * String underscore = "__"; String fileName = "setEnv.ksh"; String
         * nodevariable = underscore + fileName.toUpperCase().replace( '.', '_'
         * ) + underscore;
         * 
         * String binScript = "\tif [ $" + nodevariable + " = \"Y\" ] || [ $" +
         * nodevariable + " = \"y\" ]\n"+ "\tthen\n" +
         * "\t\ttemplate ' Calling rpaCustomChange to copy the " + fileName
         * +" script '\n" + "\t\trpaCustomChange \"copyScriptToBin\" \"" +
         * fileName +"\"\n" + "\telse\n"+ "\t\techo \" INFO: " + nodevariable +
         * " parameter is set to N (or) wrong value \\n\"\n"+ "\tfi\n";
         * 
         * 
         * System.out.println(binScript);
         */

        /*
         * File folder = new File( "C:\\MRE_files\\RPA\\Batch\\bin" ); File[]
         * listOfFiles = folder.listFiles();
         * 
         * for ( int i = 0; i < listOfFiles.length; i++ ) { if (
         * listOfFiles[i].isFile() ) {
         * System.out.println("Absolute Path: "+listOfFiles
         * [i].getAbsolutePath().replace("\\", "\\\\")); }
         * 
         * }
         */

    }

}
