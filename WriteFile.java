package com.coding;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//Create the new file
public class WriteFile {
	
	public void write(Path targetFilePath) {
		Charset charset = Charset.forName("US-ASCII");
		Numbers number = new Numbers();		
		CodingEx read = new CodingEx();
		List<String> lines = read.getContent();
	    try(BufferedWriter writer = Files.newBufferedWriter(targetFilePath, charset)){
	    	int sum = number.calculateSum();		                                           	//call the calculateSum method from Numbers Class
	    	Iterator<String> iterator = lines.iterator();	                                   //loop through the file's lines
	        while (iterator.hasNext()) {
	        	String s = iterator.next();
	        	writer.append ("Total: "+Integer.toString(sum));     //Append to the new file the sum of the numbers calculated in the Numbers class
	        	writer.newLine();								
	        	String noNumbers = s.replaceAll("\\d{1,}", "");                              //replace all the numbers from the string
	            String[] str = noNumbers.split("");
	            if(noNumbers.length() != 0){		                                       	//if there is at least one char
	            Map<String, Long> map = Arrays.stream(str).collect(Collectors.groupingBy(c->c, Collectors.counting())); //count the number 
	            Set<String> keys = map.keySet();										    //of each char's occurrence and save it 
	            Iterator<String> iterator1 = keys.iterator();							    //into the key-value pair Map object where the key is 
	            while(iterator1.hasNext()){												    //the char 
	            	String key = iterator1.next();			                                //loop through the Map object created 
	                writer.append("Character [" + key + "] occurs: " + map.get(key));       //write to file  
	                writer.newLine(); 
	                }                            
	            }
	        }
	    }
	        catch(IOException e){
	            System.out.println(e.getMessage());
	        }
		} 
		
}
