/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionquizfinal;

import Entities.Quiz;
import Entities.Reponse;
import Services.ServiceReponse;
import Services.ServicesQuiz;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aymen Yahmadi
 */
public class DisplayQuizUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    static List<Reponse> listReponses;
    
     @FXML
    private Button btSubmit;

    @FXML
    private Button btRetour;

    @FXML
    private RadioButton rbSport2;

    @FXML
    private RadioButton rbSport1;

    @FXML
    private Label lbSport2;

    @FXML
    private RadioButton rbSport4;

    @FXML
    private RadioButton rbSport3;

    @FXML
    private RadioButton rbCulture2;

    @FXML
    private RadioButton rbCulture1;

    @FXML
    private Label lbCulture1;

    @FXML
    private Label lbCulture2;

    @FXML
    private RadioButton rbCulture4;

    @FXML
    private RadioButton rbCulture3;

    @FXML
    private RadioButton rbFilm2;

    @FXML
    private RadioButton rbFilm1;

    @FXML
    private Label lbFilm1;

    @FXML
    private Label lbFilm2;

    @FXML
    private RadioButton rbFilm4;

    @FXML
    private RadioButton rbFilm3;

    @FXML
    private RadioButton rbSerie2;

    @FXML
    private RadioButton rbSerie1;

    @FXML
    private Label lbSerie1;

    @FXML
    private Label lbSerie2;

    @FXML
    private RadioButton rbSerie4;

    @FXML
    private RadioButton rbSerie3;

    @FXML
    private RadioButton rbTravel2;

    @FXML
    private RadioButton rbTravel1;

    @FXML
    private Label lbTravel1;

    @FXML
    private Label lbTravel2;

    @FXML
    private RadioButton rbTravel4;

    @FXML
    private RadioButton rbTravel3;

    @FXML
    private RadioButton rbHobie2;

    @FXML
    private RadioButton rbHobie1;

    @FXML
    private Label lbHobies1;

    @FXML
    private Label lbHobies2;

    @FXML
    private RadioButton rbHobie4;

    @FXML
    private RadioButton rbHobie3;

    @FXML
    private Label lbSport1;

    @FXML
    void Retour(ActionEvent event) {

    }

    @FXML
    void Submit(ActionEvent event) throws SQLException, IOException {
        
        ServiceReponse sr = new ServiceReponse();
        listReponses = new ArrayList<>();
        String reponse ="Non";
       
        
        int id = (new Random().nextInt(500));
        
        
        if(rbCulture1.isSelected()){ reponse = "Oui"; rbCulture2.setSelected(false); }
        if(rbCulture2.isSelected()){ reponse = "Non"; rbCulture1.setSelected(false);}
        listReponses.add(new Reponse(lbCulture1.getText(), reponse, "Culture", id));
        
        if(rbCulture3.isSelected()){ reponse = "Oui"; rbCulture4.setSelected(false);}
        if(rbCulture4.isSelected()){ reponse = "Non"; rbCulture3.setSelected(false);}
        listReponses.add(new Reponse(lbCulture2.getText(), reponse, "Culture", id));
        
        
        
        if(rbFilm1.isSelected()){ reponse = "Oui"; rbFilm2.setSelected(false);}
        if(rbFilm2.isSelected()){ reponse = "Non"; rbFilm1.setSelected(false);}
        listReponses.add(new Reponse(lbFilm1.getText(), reponse, "Film", id));
        
        if(rbFilm3.isSelected()){ reponse = "Oui"; rbFilm4.setSelected(false);}
        if(rbFilm4.isSelected()){ reponse = "Non"; rbFilm3.setSelected(false);}
        listReponses.add(new Reponse(lbFilm2.getText(), reponse, "Film", id));
        
        if(rbHobie1.isSelected()){ reponse = "Oui"; rbHobie2.setSelected(false);}
        if(rbHobie2.isSelected()){ reponse = "Non"; rbHobie1.setSelected(false);}
        listReponses.add(new Reponse(lbHobies1.getText(), reponse, "Hobies", id));
        
        if(rbHobie3.isSelected()){ reponse = "Oui"; rbHobie4.setSelected(false);}
        if(rbHobie4.isSelected()){ reponse = "Non"; rbHobie3.setSelected(false);}
        listReponses.add(new Reponse(lbHobies2.getText(), reponse, "Hobies", id));
        
        if(rbSerie1.isSelected()){ reponse = "Oui"; rbSerie2.setSelected(false);}
        if(rbSerie2.isSelected()){ reponse = "Non"; rbSerie1.setSelected(false);}
        listReponses.add(new Reponse(lbSerie1.getText(), reponse, "Serie", id));
        
        if(rbSerie3.isSelected()){ reponse = "Oui"; rbSerie4.setSelected(false);}
        if(rbSerie4.isSelected()){ reponse = "Non"; rbSerie3.setSelected(false);}
        listReponses.add(new Reponse(lbSerie2.getText(), reponse, "Serie", id));
        
        if(rbSport1.isSelected()){ reponse = "Oui"; rbSport2.setSelected(false);}
        if(rbSport2.isSelected()){ reponse = "Non"; rbSport1.setSelected(false);}
        listReponses.add(new Reponse(lbSport1.getText(), reponse, "Sport", id));
        
        if(rbSport3.isSelected()){ reponse = "Oui"; rbSport4.setSelected(false);}
        if(rbSport4.isSelected()){ reponse = "Non"; rbSport3.setSelected(false);}
        listReponses.add(new Reponse(lbSport2.getText(), reponse, "Sport", id));
        
        
        if(rbTravel1.isSelected()){ reponse = "Oui";rbTravel2.setSelected(false); }
        if(rbTravel2.isSelected()){ reponse = "Non";rbTravel1.setSelected(false); }
        listReponses.add(new Reponse(lbTravel1.getText(), reponse, "Travel", id));
        
        if(rbTravel3.isSelected()){ reponse = "Oui";rbTravel4.setSelected(false); }
        if(rbTravel4.isSelected()){ reponse = "Non";rbTravel3.setSelected(false); }
        listReponses.add(new Reponse(lbTravel1.getText(), reponse, "Travel", id));
        if(!rbCulture1.isSelected() & !rbCulture2.isSelected() || 
           !rbCulture3.isSelected() & !rbCulture4.isSelected() ||
           !rbTravel1.isSelected() & !rbTravel2.isSelected() || 
           !rbTravel3.isSelected() & !rbTravel4.isSelected() ||
           !rbSerie1.isSelected() & !rbSerie2.isSelected() || 
           !rbSerie3.isSelected() & !rbSerie4.isSelected() ||
           !rbSport1.isSelected() & !rbSport2.isSelected() || 
           !rbSport3.isSelected() & !rbSport4.isSelected() ||
           !rbHobie1.isSelected() & !rbHobie2.isSelected() || 
           !rbHobie3.isSelected() & !rbHobie4.isSelected() ||
           !rbFilm1.isSelected() & !rbFilm2.isSelected() || 
           !rbFilm3.isSelected() & !rbFilm4.isSelected()){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                    "Please fill all answers!", ButtonType.OK);
            alert.showAndWait();
        }else{
        sr.addReponses(listReponses);
        
        Parent p1 = FXMLLoader.load(getClass().getResource("MyQuiz2.fxml"));
               Scene test1 = new Scene(p1);
               Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
               App1.setScene(test1);
               App1.show();
               
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             
              ToggleGroup cultureGroup1 = new ToggleGroup(), cultureGroup2 = new ToggleGroup(), 
                    sportGroup1  = new ToggleGroup(),  sportGroup2  = new ToggleGroup(),
                    filmGroup1   = new ToggleGroup(),  filmGroup2   = new ToggleGroup(), 
                    serieGroup1  = new ToggleGroup(),  serieGroup2  = new ToggleGroup(),
                    tavelGroup1  = new ToggleGroup(),  tavelGroup2  = new ToggleGroup(), 
                    hobieGroup1   = new ToggleGroup(), hobieGroup2   = new ToggleGroup();
        
            rbCulture1.setToggleGroup(cultureGroup1);
            rbCulture2.setToggleGroup(cultureGroup1);
            rbCulture3.setToggleGroup(cultureGroup2);
            rbCulture4.setToggleGroup(cultureGroup2);

            rbSport1.setToggleGroup(sportGroup1);
            rbSport2.setToggleGroup(sportGroup1);
            rbSport3.setToggleGroup(sportGroup2);
            rbSport4.setToggleGroup(sportGroup2);

            rbFilm1.setToggleGroup(filmGroup1);
            rbFilm2.setToggleGroup(filmGroup1);
            rbFilm3.setToggleGroup(filmGroup2);
            rbFilm4.setToggleGroup(filmGroup2);

            rbSerie1.setToggleGroup(serieGroup1);
            rbSerie2.setToggleGroup(serieGroup1);
            rbSerie3.setToggleGroup(serieGroup2);
            rbSerie4.setToggleGroup(serieGroup2);

            rbHobie1.setToggleGroup(hobieGroup1);
            rbHobie2.setToggleGroup(hobieGroup1);
            rbHobie3.setToggleGroup(hobieGroup2);
            rbHobie4.setToggleGroup(hobieGroup2);

            rbTravel1.setToggleGroup(tavelGroup1);
            rbTravel2.setToggleGroup(tavelGroup1);
            rbTravel3.setToggleGroup(tavelGroup2);
            rbTravel4.setToggleGroup(tavelGroup2);
             // TODO
             ServicesQuiz sq = new ServicesQuiz();
            
             List<Quiz> questionFilm = sq.getQuestionsByTheme("Film");
              List<Quiz> questionSport = sq.getQuestionsByTheme("Sport");
             List<Quiz> questionCulture = sq.getQuestionsByTheme("Culture");
             List<Quiz> questionSerie = sq.getQuestionsByTheme("Serie");
             List<Quiz> questionTravel = sq.getQuestionsByTheme("Travel");
             List<Quiz> questionHobies = sq.getQuestionsByTheme("Hobies");
             
             lbCulture1.setText("Question 1:  "+ questionCulture.get(new Random().nextInt(questionCulture.size())).getQuestion());
             lbCulture2.setText("Question 2:  "+ questionCulture.get(new Random().nextInt(questionCulture.size())).getQuestion());

             lbFilm1.setText("Question 1:  "+ questionFilm.get(new Random().nextInt(questionFilm.size())).getQuestion());
             lbFilm2.setText("Question 2:  "+ questionFilm.get(new Random().nextInt(questionFilm.size())).getQuestion());

             lbHobies1.setText("Question 1:  "+ questionHobies.get(new Random().nextInt(questionHobies.size())).getQuestion());
             lbHobies2.setText("Question 2:  "+ questionHobies.get(new Random().nextInt(questionHobies.size())).getQuestion());
             
             lbSerie1.setText("Question 1:  "+ questionSerie.get(new Random().nextInt(questionSerie.size())).getQuestion());
             lbSerie2.setText("Question 2:  "+ questionSerie.get(new Random().nextInt(questionSerie.size())).getQuestion());
             
             lbTravel1.setText("Question 1:  "+ questionTravel.get(new Random().nextInt(questionTravel.size())).getQuestion());
             lbTravel2.setText("Question 2:  "+ questionTravel.get(new Random().nextInt(questionTravel.size())).getQuestion());
             
             lbSport1.setText("Question 1:  "+ questionSport.get(new Random().nextInt(questionSport.size())).getQuestion());
             lbSport2.setText("Question 2:  "+ questionSport.get(new Random().nextInt(questionSport.size())).getQuestion());

         } catch (SQLException ex) {
             Logger.getLogger(DisplayQuizUserController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    
}
