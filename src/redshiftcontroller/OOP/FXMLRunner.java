/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redshiftcontroller.OOP;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author alex
 */
public abstract class FXMLRunner {
 
    public static void RunFXML(String Title,String FileName) throws MalformedURLException, IOException {
        URL url = Paths.get("src/redshiftcontroller/" + FileName +".fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle(Title);
        stage.setResizable(false);
        stage.showAndWait();
        
        
    }
}
