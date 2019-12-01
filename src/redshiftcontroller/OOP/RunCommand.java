/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redshiftcontroller.OOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.scene.control.Alert;
/**
 *
 * @author alex
 */
public abstract class RunCommand {
    
    public static void RunMyCommandExec(String command) throws IOException, InterruptedException{
       
        Process proc = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
        }

        proc.waitFor();   
    }
   public static void RunCommandpb(String Terminal,String Command) throws IOException{
    
         ProcessBuilder processBuilder = new ProcessBuilder();
 //   processBuilder.command("gnome-terminal", "-e", "sudo sh -c 'echo 500 > /sys/class/backlight/intel_backlight/brightness'");
         processBuilder.command(Terminal, "-e", Command);
    try {
		Process process = processBuilder.start();
//                if(Formtitle.length()!=0 && Form.length()!=0){
//                   FXMLRunner.RunFXML(Formtitle, Form);}
		StringBuilder output = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
		}
		int exitVal = process.waitFor();
		if (exitVal == 0) {
			System.out.println("Success!");
			System.out.println(output);
			System.exit(0);
		} else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Error , problem with command");
                    alert.setContentText("something went wrong with running command : " + Command);
                }

	} catch (IOException | InterruptedException e) {
		e.printStackTrace();
	}
        
    
    
    }
    
    
}
