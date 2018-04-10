package bodyByNumberz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DatabaseFile {
	private ArrayList<String> al = new ArrayList<String>();
	private ArrayList<String> pw = new ArrayList<String>();
	private ArrayList<String> user = new ArrayList<String>();
	public String line = null;
	   public String fileName = "db.txt";
	// The name of the file to open.
	public DatabaseFile() {
	
	}
	
	
	
	
    // This will reference one line at a time

  public void writeToFile(String username, String password) {
	  try {
          // Assume default encoding.
          FileWriter fileWriter =
              new FileWriter(fileName, true);

          // Always wrap FileWriter in BufferedWriter.
          BufferedWriter bufferedWriter =
              new BufferedWriter(fileWriter);

          // Note that write() does not automatically
          // append a newline character.
         
         
          bufferedWriter.append(username);
          bufferedWriter.append(",");
          bufferedWriter.append(password);
          //bufferedWriter.write(username);
          //bufferedWriter.write(password);
          
          bufferedWriter.newLine();

          // Always close files.
          bufferedWriter.close();
      }
      catch(IOException ex) {
          System.out.println(
              "Error writing to file '"
              + fileName + "'");
          // Or we could just do this:
          // ex.printStackTrace();
      }
  }

  
    
public void readFile() {
    try {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = 
            new FileReader(fileName);
        System.out.println("this is called");
        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
           // System.out.println(line);
        	al.add(line);
        	user.add(line.substring(0, line.indexOf(",")));
        	pw.add(line.substring(line.indexOf(",") +1, line.length()));
        	
        	
        }   
        System.out.println("This work?");
        // Always close files.
        bufferedReader.close();         
    }

    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to open file '" + 
            fileName + "'");                
    }
    catch(IOException ex1) {
        System.out.println(
            "Error reading file '" 
            + fileName + "'");                  
        // Or we could just do this: 
        // ex.printStackTrace();
    }
    
   
}

public ArrayList<String> getUser(){
	return user;
}
public ArrayList<String> getPassword(){
	return pw;
}

public ArrayList<String> getArrayList() {
	return al;
}
 

}
