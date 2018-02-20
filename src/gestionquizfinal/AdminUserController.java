/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionquizfinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aymen Yahmadi
 */
public class AdminUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btAdmin;

    @FXML
    private Button btUser;

    @FXML
    void admin(ActionEvent event) throws IOException {

        Parent p1 = FXMLLoader.load(getClass().getResource("DisplayQuizAdmin.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
    }

    @FXML
    void user(ActionEvent event) throws IOException {
Parent p1 = FXMLLoader.load(getClass().getResource("DisplayQuizUser.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
