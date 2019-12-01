/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redshiftcontroller;

import redshiftcontroller.OOP.FXMLRunner;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 *
 * @author alex
 */


public class PanelController implements Initializable {
    
    @FXML
    private Label ColorK;
    @FXML
    private Slider slide;
    @FXML
    private Button Ok;
    
    
    
    
    @FXML
    public void onSliderChanged() {
     slide.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
         String val = Integer.toString(new_val.intValue());
         ColorK.setText(val + "K");
         String command = "redshift -O " + val;
         try {
             Process pr = Runtime.getRuntime().exec(command);
         } catch (IOException ex) {
             Logger.getLogger(PanelController.class.getName()).log(Level.SEVERE, null, ex);
         }
      });
    
}
    
    @FXML
    public void BattaryAction() throws IOException{   
    FXMLRunner.RunFXML("Battary Panel", "BattaryFXML");
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
    
}
