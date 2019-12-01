/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redshiftcontroller;

import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import redshiftcontroller.OOP.FXMLRunner;
import redshiftcontroller.OOP.FileMan;
import redshiftcontroller.OOP.RunCommand;

/**
 * FXML Controller class
 *
 * @author alex
 */
public class BattaryFXMLController implements Initializable {

    @FXML
    private CheckBox SaveCheck;
    @FXML
    private TextField Directory;
    @FXML
    private TextField terminal;
    @FXML
    private TextField var;
    @FXML 
    private Stage stage;
    
    
    String SavedTerminal  = "";
    String SavedDirectory = "";
    
    @FXML
    private void OpenDirs(){
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open Resource File");
      File file = fileChooser.showOpenDialog(stage);
      Directory.setText(file.getPath());
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Be Careful!");
        alert.setContentText("Make sure you choosed right one!!");
    }
    @FXML
    private void setBattary() throws IOException, InterruptedException{
      String command = "sudo sudo sh -c 'echo "+ Integer.parseInt(var.getText())+ " > " + Directory.getText() + " '";
        if(SaveCheck.isSelected()){          
          SavedDirectory = Directory.getText();
          SavedTerminal = terminal.getText();
          FileMan.CreateAndWrite("/home/"+System.getProperty("user.name")+"/Desktop/RedshiftController_Log.txt", "utf-8", "Terminal:" + SavedTerminal + "\n" + "Directory:" + SavedDirectory);
      }
    //  RunCommand.RunCommandpb(terminal.getText(), command,"Controller" , "Panel");
     RunCommand.RunCommandpb(terminal.getText(), command);
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File tempFile = new File("/home/"+System.getProperty("user.name")+"/Desktop/RedshiftController_Log.txt");
        if(tempFile.exists()){
            
            try {
                List<String> s = FileMan.ReadValues("/home/"+System.getProperty("user.name")+"/Desktop/RedshiftController_Log.txt", ":");
                terminal.setText(s.get(0));
                Directory.setText(s.get(1));
            } catch (IOException ex) {
                Logger.getLogger(BattaryFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
