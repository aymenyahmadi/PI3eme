/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataBase.DBConnect;
import Entities.Quiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Aymen Yahmadi
 */
public class ServicesQuiz {
    
    private Connection connection;
    private PreparedStatement ps;

    public ServicesQuiz() throws SQLException {
        DBConnect dBConnect = new DBConnect();
        connection = dBConnect.connect();
    }
    
    public void addQuiz(Quiz quiz) throws SQLException{
        String req = "insert into quiz (question,theme) values (?,?)";
        ps = connection.prepareStatement(req);
        ps.setString(1, quiz.getQuestion());        
        ps.setString(2, quiz.getTheme());        
        ps.executeUpdate();
    }
    
    public ObservableList<Quiz> displayQuiz (){
        ObservableList<Quiz> quizLIst =  FXCollections.observableArrayList();
        ResultSet rs; 
        String req = "SELECT * FROM quiz ";
       
        try {
            ps = connection.prepareStatement(req);
             rs = ps.executeQuery(req);
            
            while (rs.next()) {
               Quiz e = 
                          new Quiz(rs.getInt("id"),rs.getString("question"), rs.getString("theme"));
               
                quizLIst.add(e);
            }
            return quizLIst;
        } catch (SQLException ex) {
            Logger.getLogger(ServicesQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return quizLIst;
        
    }
    
    public void deleteQuiz (int id) throws SQLException{
        
        String req = "delete from quiz where id=?";
        ps = connection.prepareStatement(req);
        ps.setInt(1, id);
        
        ps.executeUpdate();
        
    }
    
    public void edit(Quiz quiz){
        
        
         String req="UPDATE quiz SET question='"+quiz.getQuestion()+"'WHERE id="+String.valueOf(quiz.getId());
         
        
        try {
            ps = connection.prepareStatement(req);
           
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public List<Quiz> getQuestionsByTheme (String theme){
        List<Quiz> quizLIst =  new ArrayList<>();
        ResultSet rs; 
        String req = "SELECT * FROM quiz WHERE theme='"+theme+"'";
       
        try {
            ps = connection.prepareStatement(req);
             rs = ps.executeQuery(req);
            
            while (rs.next()) {
               Quiz e = 
                          new Quiz(rs.getInt("id"),rs.getString("question"), rs.getString("theme"));
               
                quizLIst.add(e);
            }
            return quizLIst;
        } catch (SQLException ex) {
            Logger.getLogger(ServicesQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return quizLIst;
        
    }
    
}
