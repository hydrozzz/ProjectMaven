package zz;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import com.opencsv.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App myApp = new App();
    	
        System.out.println( "Hello World!" );
        System.out.println("Je fais quelques modifications.");
        System.out.println("Max : " + myApp.max(4,5));
    
        int monmax = 0;
        

        try {
        	CSVReader reader = new CSVReader (new FileReader ("data.csv"));
        	CSVWriter writer = new CSVWriter (new FileWriter ("data_filtered.csv"));

        	try {
        		List<String []> myEntries = reader.readAll();
                for(String[] entries : myEntries) {
                	
    		    	List<String> list = Arrays.asList(entries);
    		    	Vector<String> out = new Vector<String>();
    		    	CollectionUtils.select(list, new Predicate<String>(){

						@Override
						public boolean evaluate(String arg0) {
							// TODO Auto-generated method stub
							int tutu = Integer.parseInt(arg0);
							if (tutu<50){
								return true;
							}
							else return false;
						}

	
    		    	}, out);
    		    	System.out.println("OUT:" + out);
    		    	
    		    	writer.writeNext(out.toArray(new String[0]));
    		    	
    		    	for (String i : entries) {
        		    	monmax=myApp.max(monmax, Integer.parseInt(i));
        		    }
        		}
        	}
        	catch(IOException e) {
        		System.out.println("Problème readall()");
        	}
        	
        	reader.close();
        	writer.close();
        }
       	catch(FileNotFoundException e) {
       		System.out.println(e.getMessage());
       	} 
        catch (IOException e) {
			e.printStackTrace();
		}
        
        System.out.println("Nombre max trouvé : " + monmax);
    
    }
    
    public int max(int a, int b)
    {
    	return a > b ? a : b;
    }
}
