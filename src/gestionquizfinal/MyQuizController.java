/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionquizfinal;

import Entities.Quiz;
import Entities.Reponse;
import Services.ServicesQuiz;
import static gestionquizfinal.DisplayQuizUserController.listReponses;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Aymen Yahmadi
 */
public class MyQuizController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btRetour;

//    @FXML
//    private TableView<Reponse> tableViewQuiz;
//
//    @FXML
//    private TableColumn<Reponse, String> colQuestion;
//
//    @FXML
//    private TableColumn<Reponse, String> colReponse;
//
//    @FXML
//    private TableColumn<Reponse, String> colTheme;

    @FXML
    void Retour(ActionEvent event) {

    }
    
//    private void buldTableViewQuiz () throws SQLException{
//        
//        colQuestion.setCellValueFactory(new PropertyValueFactory<>("question"));
//        colTheme.setCellValueFactory(new PropertyValueFactory<>("theme"));
//        colReponse.setCellValueFactory(new PropertyValueFactory<>("reponse"));
//        
//        ObservableList<Reponse> data = (ObservableList<Reponse>) listReponses;
//        
//        tableViewQuiz.setItems(data);
//        
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
