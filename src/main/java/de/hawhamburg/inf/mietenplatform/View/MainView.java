package de.hawhamburg.inf.mietenplatform.View;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author diiia
 */
public class MainView extends Application {
    public static void launchView() {
        launch();
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(getScene(primaryStage));
        primaryStage.show();
    }
    
    
    public Scene getScene(Stage primaryStage){
        primaryStage.setTitle("JDBC");
        Button btn = new Button();
        btn.setText("Benutzer");
        btn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                BenutzerView benutzerView = new BenutzerView(primaryStage);       
                primaryStage.setScene(benutzerView.getView());
                primaryStage.show();
            }
        });
        
        Button btn1 = new Button();
        btn1.setText("Mieten");
        btn1.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                MietenView mietenView = new MietenView(primaryStage);       
                primaryStage.setScene(mietenView.getView());
                primaryStage.show();
            }
        });
        
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10); 
        gridPane.setHgap(5);
        gridPane.add(btn, 0, 0); 
        gridPane.add(btn1, 1, 0);
        gridPane.setAlignment(Pos.CENTER);
        return new Scene(gridPane, 300, 250);
    }    
}
