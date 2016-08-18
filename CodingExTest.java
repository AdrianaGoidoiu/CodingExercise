package com.coding;
import static org.junit.Assert.*;

import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class CodingExTest {

	@Test
	public void testFileExistsAndEmpty() {  //test if the source and the target file are set 
		assertTrue(Files.exists(CodingEx.getSourceFilePath()));
		assertTrue(Files.exists(CodingEx.getTargetFilePath()));
	}
	
	@Test
	public void testFileRead(){  //test if the file was read
		CodingEx read = new CodingEx();
		assertTrue(read.getContent().size() > 0);
	}

	@Test
	public void testWriteFileCreated(){  //test if the file was created
		assertTrue(Files.exists(CodingEx.getTargetFilePath()));	
	}
	
	@Test
	public void testNumbers(){			// test if the sum is computed and the returned number is not null
		Numbers number = new Numbers();
		assertNotNull(number.calculateSum());
	}
	@Test
	public void testWrite(){
		CodingEx test = new CodingEx();
		List<String> lines= test.getContent();
		Iterator<String> iterator = lines.iterator();	
		String s = iterator.next();
		String noNumbers = s.replaceAll("\\d{1,}", "");  
		assertTrue(noNumbers.length()>0);
	}
	

}
