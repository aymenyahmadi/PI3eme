/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionquizfinal;

import Entities.Reponse;
import Services.ServiceReponse;
import static gestionquizfinal.DisplayQuizUserController.listReponses;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
public class MyQuiz2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btRetour;

    @FXML
    private TableView<Reponse> tableViewQuiz;

    @FXML
    private TableColumn<Reponse, String> colQuestion;

    @FXML
    private TableColumn<Reponse, String> colReponse;

    @FXML
    private TableColumn<Reponse, String> colTheme;
    
    int cultureScore = 0, hobieScore, 
        sportScore = 0, filmScore = 0,
        serieScore = 0, travelScore = 0;
    
        private void buldTableViewQuiz () throws SQLException{
        ServiceReponse sr = new ServiceReponse();
        
        colQuestion.setCellValueFactory(new PropertyValueFactory<>("question"));
        colTheme.setCellValueFactory(new PropertyValueFactory<>("theme"));
        colReponse.setCellValueFactory(new PropertyValueFactory<>("reponse"));
        
        
        ObservableList<Reponse> data = FXCollections.observableArrayList(listReponses) ;
        
        for(Reponse r : listReponses){
            
            switch(r.getTheme()){
                case "Culture":
                    cultureScore += (r.getReponse().equals("Oui") ? 1 : 0);
                    break;
                case "Film":
                    filmScore += (r.getReponse().equals("Oui") ? 1 : 0);
                    break;
                case "Hobies":
                    hobieScore += (r.getReponse().equals("Oui") ? 1 : 0);
                    break;
                case "Serie":
                    serieScore += (r.getReponse().equals("Oui") ? 1 : 0);
                    break;
                case "Sport":
                    sportScore += (r.getReponse().equals("Oui") ? 1 : 0);
                    break;
                case "Travel":
                    travelScore += (r.getReponse().equals("Oui") ? 1 : 0);
                    break;   
            }
        }
        
            System.out.println(String.format("Score : (%d),(%d),(%d),(%d),(%d),(%d)",
                    serieScore, sportScore, travelScore, 
                    hobieScore, cultureScore, filmScore));
            
            sr.addScore(1,    "Film",    (filmScore * 50));
            sr.addScore(1, "Culture", (cultureScore * 50));
            sr.addScore(1,   "Hobies",  (hobieScore * 50));
            sr.addScore(1,   "Serie",   (serieScore * 50));
            sr.addScore(1,   "Sport",   (sportScore * 50));
            sr.addScore(1,  "Travel",  (travelScore * 50));
            
        tableViewQuiz.setItems(data);
        }
        
        @FXML
    void retour(ActionEvent event) throws IOException {

        Parent p1 = FXMLLoader.load(getClass().getResource("AdminUser.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
    }
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            buldTableViewQuiz();
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(MyQuiz2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
