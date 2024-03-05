/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.hawhamburg.inf.in_praktika_6.View;

import de.hawhamburg.inf.in_praktika_6.Controller.MietenController;
import de.hawhamburg.inf.in_praktika_6.Model.Mieten;
import de.hawhamburg.inf.in_praktika_6.Model.Benutzer;
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
public class MietenView {
    private Scene scene; 
    private Stage stage;
    
    private TableView tableView = new TableView();
    private TextField vinNummerTextField;
    private Text vinNummerText;
    
    MietenController mietenController = new MietenController();
    
    public MietenView(Stage stage) {
        this.stage = stage;
    }
    
    public Scene getView() {
        stage.setTitle("Suche");
        vinNummerText = new Text("VIN nummer");
        vinNummerTextField = new TextField();
        
        Button button = new Button("Laden");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {               
                tableView.getItems().clear();  
                for (Mieten e : mietenController.list(vinNummerTextField.getText())) {
                    tableView.getItems().add(e);
                }
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
        
        TableColumn<Mieten, String> column1 = 
        new TableColumn<>("Auftragsnummer");    
        column1.setCellValueFactory(
            new PropertyValueFactory<>("auftragNum"));

        TableColumn<Mieten, String> column2 = 
        new TableColumn<>("Datum");    
        column2.setCellValueFactory(
            new PropertyValueFactory<>("datum"));

        TableColumn<Mieten, String> column3 = 
        new TableColumn<>("Distanz");    
        column3.setCellValueFactory(
            new PropertyValueFactory<>("distanz"));
        
        TableColumn<Mieten, String> column4 = 
        new TableColumn<>("Dauer");    
        column4.setCellValueFactory(
            new PropertyValueFactory<>("dauer"));
        
        TableColumn<Mieten, String> column5 = 
        new TableColumn<>("vinNummer");    
        column5.setCellValueFactory(
            new PropertyValueFactory<>("vinNummer"));
        
        TableColumn<Mieten, String> column6 = 
        new TableColumn<>("Kundennummer");    
        column6.setCellValueFactory(
            new PropertyValueFactory<>("kundNummer"));
        
        TableColumn<Mieten, String> column7 = 
        new TableColumn<>("Kundenname");    
        column7.setCellValueFactory(
            new PropertyValueFactory<>("kundname"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        tableView.prefHeightProperty().bind(stage.heightProperty());
        tableView.prefWidthProperty().bind(stage.widthProperty());
        
        GridPane gridPaneMain = new GridPane();
        gridPaneMain.setPadding(new Insets(10, 10, 10, 10)); 
        gridPaneMain.setVgap(5); 
        gridPaneMain.setHgap(100);       
        gridPaneMain.setAlignment(Pos.TOP_LEFT);
        
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10); 
        gridPane.setHgap(5);
        gridPane.add(vinNummerText, 0, 0); 
        gridPane.add(vinNummerTextField, 1, 0);
        gridPane.add(button, 1, 1);
        
        gridPaneMain.add(gridPane, 0, 1);        
        gridPaneMain.add(tableView, 0, 2);
        gridPaneMain.add(backButton, 0, 3);       
        
        scene = new Scene(gridPaneMain, 800, 600);
        return scene;  
    }
}
