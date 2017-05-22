import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

	public static final String fileSeparator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");
	
	
	public Object readObject(String filename){
		
		Object output = null;
		FileInputStream fis;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
			
			output = ois.readObject();
			
			return output;
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(ois != null){
					ois.close();
				}
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public void writeObject(String filename, Object data ){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(data);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(oos != null){
					oos.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
				
			}
		}
	

	public ArrayList<String> readFile(String filename){
		
		ArrayList<String> output = new ArrayList<String>();
		FileReader reader;
		Scanner in = null;
		try {
			reader = new FileReader(filename);
			in = new Scanner(reader);
			while(in.hasNextLine()){
				String input = in.nextLine();
				output.add(input);
			}
			
			in.close();
			return output;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(in != null){
				in.close();
			}
		}
		
		return null;
	}
	
	

	public void writeFile(ArrayList<String> data, String filename ){
		FileWriter writer = null;
		try {
			writer = new FileWriter(filename);
			for( String e: data){
				writer.write(e + lineSeparator);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(writer != null){
				try {
					writer.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	
}







