package com.coding;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
	int sum = 0;										
    boolean found = false;					
//Calculate the sum of the numbers
	public int calculateSum() {
		CodingEx read = new CodingEx();
		List<String> line = read.getContent();                              //save the file's content into a new Object 
		Pattern patternNumbers = Pattern.compile("\\d{1,}");	            //select all numbers and compile the pattern ( the regular expression) 
		Iterator<String> iterator = line.iterator();
		 while (iterator.hasNext()) {
			 String key = iterator.next(); 	                              	//loop through the List object
			 Matcher matcherNumbers = patternNumbers.matcher(key);	    	//The compiled pattern is used by the Matcher object  
			 while(matcherNumbers.find()) {							        //to find the numbers
				 sum += Integer.parseInt(matcherNumbers.group());		    //when a number is found is added to the sum 
		         found = true;														
		        }	
		      if(!found){				                                     //if there are no numbers in the file the sum will be 0
		    	  sum = 0;
		      }
		 }
		 return sum;
	}
}
