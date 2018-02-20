/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionquizfinal;

import Entities.Quiz;
import Services.ServicesQuiz;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aymen Yahmadi
 */
public class DisplayQuizAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    static int  id;
    static Quiz selectedQuiz;
    
     @FXML
    private TableView<Quiz> tableViewQuiz;

    

    @FXML
    private TableColumn<Quiz, String> colTheme;
    
    @FXML
    private TableColumn<Quiz, String> colQuestion;
    
    @FXML
    private Button btAddQuiz;

    @FXML
    private Button btEditQuiz;

    @FXML
    private Button btDeleteQuiz;
    
    @FXML
    private Button btStats;

    @FXML
    void actionAddQuiz(ActionEvent event) throws IOException {

         Parent p1 = FXMLLoader.load(getClass().getResource("MenuTheme.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
    }
    
    @FXML
    void showStats(ActionEvent event) throws IOException{
        Parent p1 = FXMLLoader.load(getClass().getResource("StatsFXML.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
    }

    @FXML
    void actionDeleteQuiz(ActionEvent event) throws SQLException {

         ServicesQuiz servicesQuiz = new ServicesQuiz();
         servicesQuiz.deleteQuiz(id);
         buldTableViewQuiz ();
    }

    @FXML
    void actionEditQuiz(ActionEvent event) throws IOException {
        
        Parent p1 = FXMLLoader.load(getClass().getResource("editQuizAdmin.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();

    }
    
    
    private void buldTableViewQuiz () throws SQLException{
        
        colQuestion.setCellValueFactory(new PropertyValueFactory<>("question"));
        colTheme.setCellValueFactory(new PropertyValueFactory<>("theme"));
        
        ServicesQuiz servicesQuiz = new ServicesQuiz();
        ObservableList<Quiz> data = servicesQuiz.displayQuiz();
        
        tableViewQuiz.setItems(data);
        
    }
    
    private void EventGetData() {
        tableViewQuiz.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Quiz> observable,
                Quiz oldValue,
                Quiz newValue) -> {
            if (newValue == null) {
             
                
                
               
                return;
            }
            
            id = newValue.getId();
           selectedQuiz = newValue;
            
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             // TODO
             selectedQuiz = new Quiz();
             buldTableViewQuiz ();
             EventGetData();
         } catch (SQLException ex) {
             Logger.getLogger(DisplayQuizAdminController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    
}
