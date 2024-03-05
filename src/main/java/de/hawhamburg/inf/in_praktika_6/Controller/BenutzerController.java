/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.hawhamburg.inf.in_praktika_6.Controller;

import de.hawhamburg.inf.in_praktika_6.Model.Benutzer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author diiia
 */
public class BenutzerController {
    private Connection con;
    private void openConnection() {
        try {
            Class.forName ("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@oracle.informatik.haw-hamburg.de:1521/inf.informatik.haw-hamburg.de";
            con = DriverManager.getConnection(url, "", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
    
    public List<Benutzer> list() {
        List<Benutzer> benutzers = new ArrayList<>();
        openConnection();
        try {
            Statement statement = con.createStatement();
            String anfrage = "SELECT * FROM Benutzer ORDER BY KUNDNUM";
            ResultSet ergebnis = statement.executeQuery(anfrage);
            while (ergebnis.next()) {
                Benutzer benutzer = new Benutzer();
                benutzer.setId(ergebnis.getString(1));
                benutzer.setKundname(ergebnis.getString(2));
                benutzer.setFuehrerschein(ergebnis.getString(3));
                benutzer.setGeburtsdatum(ergebnis.getString(4).split(" ")[0]);
                benutzers.add(benutzer);
            }
            ergebnis.close();
            statement.close();  
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return benutzers;
    }
    
    public void save(Benutzer benutzer) {
        try {
            openConnection();
            Statement statement = con.createStatement();
            String anfrage = "INSERT INTO Benutzer "
                    + "(Kundname, Fuehrerschein, Geburtsdatum) VALUES "
                    + "('" + benutzer.getKundname() + "','" + benutzer.getFuehrerschein()+ "','"
                    + benutzer.getGeburtsdatum()+ "')";
            statement.executeUpdate(anfrage);
            statement.close();
            closeConnection();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
