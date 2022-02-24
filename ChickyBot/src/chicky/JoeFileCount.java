package chicky;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class JoeFileCount {
	
	public static File joe;
	
	public JoeFileCount() {
		joe = new File("C:/Users/mmmmm/Desktop/botgifs/joecount.txt/");
	}
	
	public void writeFile(int count) throws IOException {
		String value = String.valueOf(count);
	    FileOutputStream fos = new FileOutputStream(joe);
	    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
	    outStream.writeBytes(value);
	    outStream.close();

	}
	public String readFile(File file) throws IOException {
		String content = "";
		try{
		 DataInputStream dis = new DataInputStream (new FileInputStream (joe));     
		 byte[] datainBytes = new byte[dis.available()];
		 dis.readFully(datainBytes);
		 dis.close();
		       
		 content = new String(datainBytes, 0, datainBytes.length);
		 
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return content;
	}
}

