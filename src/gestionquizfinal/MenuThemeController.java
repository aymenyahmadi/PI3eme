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
public class MenuThemeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    static String theme ="";
    
        @FXML
    private Button btSport;

    @FXML
    private Button btFilm;

    @FXML
    private Button btCulture;

    @FXML
    private Button btSerie;

    @FXML
    private Button btTravel;

    @FXML
    private Button btHobies;
    
    @FXML
    private Button btBack;

    @FXML
    void actionBack(ActionEvent event) throws IOException {
        
                Parent p1 = FXMLLoader.load(getClass().getResource("DisplayQuizAdmin.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
    }


    @FXML
    void actionCulture(ActionEvent event) throws IOException {
        theme = "Culture";
        
        Parent p1 = FXMLLoader.load(getClass().getResource("AddQuiz.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();

    }

    @FXML
    void actionFilm(ActionEvent event) throws IOException {
        theme = "Film";
        
        Parent p1 = FXMLLoader.load(getClass().getResource("AddQuiz.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();

    }

    @FXML
    void actionHobies(ActionEvent event) throws IOException {
        theme = "Hobies";
        Parent p1 = FXMLLoader.load(getClass().getResource("AddQuiz.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();

    }

    @FXML
    void actionSerie(ActionEvent event) throws IOException {
        theme = "Serie";
        Parent p1 = FXMLLoader.load(getClass().getResource("AddQuiz.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();

    }

    @FXML
    void actionSport(ActionEvent event) throws IOException {
        
        theme = "Sport";

        Parent p1 = FXMLLoader.load(getClass().getResource("AddQuiz.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
    }

    @FXML
    void actionTravel(ActionEvent event) throws IOException {
        theme = "Travel";
        
        Parent p1 = FXMLLoader.load(getClass().getResource("AddQuiz.fxml"));
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
