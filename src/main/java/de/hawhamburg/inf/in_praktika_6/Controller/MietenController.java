/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.hawhamburg.inf.in_praktika_6.Controller;

import de.hawhamburg.inf.in_praktika_6.Model.Mieten;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diiia
 */
public class MietenController {
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
    
    public List<Mieten> list(String vinNumber) {
        List<Mieten> mietens = new ArrayList<>();
        openConnection();
        try {
            Statement statement = con.createStatement();
            String anfrage = "SELECT MIETEN.*, BENUTZER.KUNDNAME "
                    + "from MIETEN LEFT OUTER JOIN BENUTZER ON "
                    + "BENUTZER.KUNDNUM = MIETEN.KUNDNUMMER "
                    + "WHERE MIETEN.VIN_NUMMER='" + vinNumber + "'";
            ResultSet ergebnis = statement.executeQuery(anfrage);
            while (ergebnis.next()) {
                Mieten m = new Mieten();
                m.setAuftragNum(ergebnis.getString(1));
                m.setDatum(ergebnis.getString(2).split(" ")[0]);
                m.setDistanz(ergebnis.getString(3));
                m.setDauer(ergebnis.getString(4));
                m.setVinNummer(ergebnis.getString(5));
                m.setKundNummer(ergebnis.getString(6));
                m.setKundname(ergebnis.getString(7));
                mietens.add(m);
            }
            ergebnis.close();
            statement.close();  
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return mietens;
    }   
    
}
