/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.hawhamburg.inf.mietenplatform.Model;

/**
 *
 * @author diiia
 */
public class Benutzer {
    private String id;
    private String kundname;
    private String fuehrerschein;
    private String geburtsdatum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKundname() {
        return kundname;
    }

    public void setKundname(String kundname) {
        this.kundname = kundname;
    }

    public String getFuehrerschein() {
        return fuehrerschein;
    }

    public void setFuehrerschein(String fuehrerschein) {
        this.fuehrerschein = fuehrerschein;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }
}
