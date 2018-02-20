/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionquizfinal;

import Entities.Quiz;
import Helper.Validator;
import Services.ServicesQuiz;
import static gestionquizfinal.DisplayQuizAdminController.selectedQuiz;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aymen Yahmadi
 */
public class EditQuizAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private TextField txfQuestion;
    

    @FXML
    private Button btAdd;

    @FXML
    private Button btBack;

    @FXML
    void actionAddQUIZ(ActionEvent event) throws SQLException, IOException {
        
         
        if(Validator.validate( Validator.regexType.QUESTION, txfQuestion.getText()) == false){
            Alert alert = new Alert(Alert.AlertType.ERROR, 
                    "Verifiez vos donnees ", ButtonType.OK);
            alert.showAndWait(); }
        else {
        
        ServicesQuiz servicesQuiz = new ServicesQuiz();
         Quiz quiz = new Quiz(selectedQuiz.getId(),txfQuestion.getText());
      
        servicesQuiz.edit(quiz);
           Parent p1 = FXMLLoader.load(getClass().getResource("DisplayQuizAdmin.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();

    }}

    @FXML
    void actionBack(ActionEvent event) throws IOException {

        Parent p1 = FXMLLoader.load(getClass().getResource("DisplayQuizAdmin.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txfQuestion.setText(selectedQuiz.getQuestion());
        
        
        
    }    
    
}
