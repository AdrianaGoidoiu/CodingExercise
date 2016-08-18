package com.coding;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodingEx {
	
	static Path sourceFilePath = Paths.get("files/sampleInput.txt");  								//set the path of the source file
	static Path targetFilePath = Paths.get("files/sampleOutput.txt"); 								//set the path for the new file
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);								
		WriteFile targetFile = new WriteFile();
		if(Files.exists(getSourceFilePath())){													//if the path is correct and the file exists
			if(Files.exists(getTargetFilePath())){												//if the file you want to create already exist 
				System.out.println("The file already exists! Are you sure you want to continue? This will overwrite wour file. (yes/no) ");
				String answer = in.next(); 														//save the user's answer
				in.close();
				if(answer.equalsIgnoreCase("yes")){ 											//if the answer is yes call the method write()
					targetFile.write(targetFilePath);											// to overwrite the file with the new content
					System.out.println("The file was successfully overwritten.");
				} else if(answer.equalsIgnoreCase("no")){  										//if the user does'n want to overwrite, exit
					return;
				} else {
					System.out.println("Soory the \""+ answer + "\" option doesn't exist.");	//if the users answer is not the right format
				}
			}else{
				targetFile.write(targetFilePath);								//call the method write to create the file if it doesn't exist yet
				if(Files.exists(getTargetFilePath())){
					System.out.println("The file was successfully created");
				}
			}
		} else {
			System.out.println("Sorry the file you try to test doesn't exist!");
		}
	}
		
//Read the file	
	public List<String> getContent() {		
		Charset charset = Charset.forName("US-ASCII");
        List<String> lines = new ArrayList<>();														//create a List object to each store of the file 
        try(
        		BufferedReader reader = Files.newBufferedReader(sourceFilePath, charset)
        		){
        	String line = null;
            while ((line = reader.readLine()) !=null ) {	
            	lines.add(line);											    			//add each line of the file until the end of the document
            }
        } catch(IOException e){
            System.out.println(e.getMessage());		
        } 
		return lines;
	}
	
	public static Path getSourceFilePath(){  
		return sourceFilePath;
	}
	public static Path getTargetFilePath(){
		return targetFilePath;
	}
}
