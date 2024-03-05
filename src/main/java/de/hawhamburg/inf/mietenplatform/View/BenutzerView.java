/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.hawhamburg.inf.mietenplatform.View;

import de.hawhamburg.inf.mietenplatform.Controller.BenutzerController;
import de.hawhamburg.inf.mietenplatform.Model.Benutzer;

import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author diiia
 */
public class BenutzerView {
    private Scene scene; 
    private Stage stage;
    private TableView tableView = new TableView();
    private TextField kundnameTextField;
    private Text kundnameText;
    private TextField fuehrerscheinTextField;
    private Text fuehrerscheinText;
    private TextField geburtsdatumTextField;
    private Text geburtsdatumText;
   
    BenutzerController benutzerController = new BenutzerController();
    
    public BenutzerView(Stage stage) {
        this.stage = stage;
    }    
   
    public Scene getView() {
        stage.setTitle("Benutzer");
        kundnameText = new Text("Kundname");
        kundnameTextField = new TextField();
        
        fuehrerscheinText = new Text("Fuehrerschein");
        fuehrerscheinTextField = new TextField();
        
        geburtsdatumText = new Text("Geburtsdatum");
        geburtsdatumTextField = new TextField();
        
        Button button = new Button("Laden");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Benutzer benutzer = new Benutzer();
                benutzer.setKundname(kundnameTextField.getText());
                benutzer.setFuehrerschein(fuehrerscheinTextField.getText());                
                benutzer.setGeburtsdatum(geburtsdatumTextField.getText());
                benutzerController.save(benutzer);
                
                tableView.getItems().clear();  
                for (Benutzer e : benutzerController.list()) {
                    tableView.getItems().add(e);
                }
                
                kundnameTextField.clear();
                fuehrerscheinTextField.clear();
                geburtsdatumTextField.clear();
            }
        }); 
        
        Button backButton = new Button("Back");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {               
                MainView mainView = new MainView();       
                stage.setScene(mainView.getScene(stage));
                stage.show();
            }
        });
        
        TableColumn<Benutzer, String> column1 = 
        new TableColumn<>("Kundnum");    
        column1.setCellValueFactory(
            new PropertyValueFactory<>("id"));

        TableColumn<Benutzer, String> column2 = 
        new TableColumn<>("Kundname");    
        column2.setCellValueFactory(
            new PropertyValueFactory<>("kundname"));

        TableColumn<Benutzer, String> column3 = 
        new TableColumn<>("Fuehrerschein");    
        column3.setCellValueFactory(
            new PropertyValueFactory<>("fuehrerschein"));
        
        TableColumn<Benutzer, String> column4 = 
        new TableColumn<>("Geburtsdatum");    
        column4.setCellValueFactory(
            new PropertyValueFactory<>("geburtsdatum"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        
        tableView.prefHeightProperty().bind(stage.heightProperty());
        tableView.prefWidthProperty().bind(stage.widthProperty());
        
        for (Benutzer e : benutzerController.list()) {
            tableView.getItems().add(e);
        }
        
        GridPane gridPaneMain = new GridPane();
        gridPaneMain.setPadding(new Insets(10, 10, 10, 10)); 
        gridPaneMain.setVgap(5); 
        gridPaneMain.setHgap(100);       
        gridPaneMain.setAlignment(Pos.TOP_LEFT);
        
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10); 
        gridPane.setHgap(5);
        gridPane.add(kundnameText, 0, 0); 
        gridPane.add(kundnameTextField, 1, 0);
        
        gridPane.add(fuehrerscheinText, 0, 1);
        gridPane.add(fuehrerscheinTextField, 1, 1);
        gridPane.add(geburtsdatumText, 0, 2);
        gridPane.add(geburtsdatumTextField, 1, 2);
        gridPane.add(button, 1, 3);
                
        gridPaneMain.add(gridPane, 0, 1);        
        gridPaneMain.add(tableView, 0, 2);
        gridPaneMain.add(backButton, 0, 3);        
        
        scene = new Scene(gridPaneMain, 800, 600);
        return scene;  
    }
}
