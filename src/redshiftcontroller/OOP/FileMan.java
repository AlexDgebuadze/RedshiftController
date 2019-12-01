/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redshiftcontroller.OOP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public abstract class FileMan {
    
    public static void CreateAndWrite(String FileName,String Encoding,String content){
     try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName), Encoding))) {
         writer.write(content);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
  public static List<String> ReadValues(String File,String spKey) throws FileNotFoundException, IOException{
  File file = new File(File);
  BufferedReader br = new BufferedReader(new FileReader(file));
  List<String> s = new ArrayList<>();
  short i=0;
  String st; 
  while ((st = br.readLine()) != null) {
     if(st.contains(":")){
         s.add( st.substring(st.indexOf(":")+1));
     }  
  }
  return s;
  
    }
    
    
}
