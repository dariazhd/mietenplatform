/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.hawhamburg.inf.mietenplatform.Model;

/**
 *
 * @author diiia
 */
public class Mieten {
    private String auftragNum;
    private String datum;
    private String distanz;
    private String dauer;
    private String vinNummer;
    private String kundNummer;
    private String kundname;

    public String getAuftragNum() {
        return auftragNum;
    }

    public void setAuftragNum(String auftragNum) {
        this.auftragNum = auftragNum;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getDistanz() {
        return distanz;
    }

    public void setDistanz(String distanz) {
        this.distanz = distanz;
    }

    public String getDauer() {
        return dauer;
    }

    public void setDauer(String dauer) {
        this.dauer = dauer;
    }

    public String getVinNummer() {
        return vinNummer;
    }

    public void setVinNummer(String vinNummer) {
        this.vinNummer = vinNummer;
    }

    public String getKundNummer() {
        return kundNummer;
    }

    public void setKundNummer(String kundNummer) {
        this.kundNummer = kundNummer;
    }

    public String getKundname() {
        return kundname;
    }

    public void setKundname(String kundname) {
        this.kundname = kundname;
    }    
}
