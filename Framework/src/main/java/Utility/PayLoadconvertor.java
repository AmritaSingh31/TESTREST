package Utility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;

public class PayLoadconvertor {
//Basically to convert the body into string
	public static String generatepayloadString(String filename) throws IOException
	{
		//i want is the file name
		String filepath = "C:\\Users\\AmritaSinghChopra\\workspace\\Framework\\Resource\\" + filename;
		//String filepath=System.getProperty("uder.dir")+ \\resource\\" + filename"
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
	
}
