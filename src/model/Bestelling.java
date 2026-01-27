package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Bestelling van een klant.
 */
public class Bestelling {
    private Klant klant;
    private LocalDate bestelDatum;
    private List<plant> planten;
    private boolean isAfgerond;

    /**
     * Start nieuwe bestelling.
     */
    public Bestelling(Klant klant) {
        this.klant = klant;
        this.bestelDatum = LocalDate.now();
        this.planten = new ArrayList<>();
        this.isAfgerond = false;
    }

    /**
     * Voegt plant toe aan bestelling.
     */
    public void voegPlantToe(plant plant) {
        if (!isAfgerond) {
            planten.add(plant);
        }
    }

    /**
     * Bereken totaalprijs.
     */
    public double berekenTotaalPrijs() {
        double totaal = 0;
        for (plant p : planten) {
            totaal += p.getPrijs();  // getPrijs() moet bestaan in plant klasse
        }
        return totaal;
    }

    // Getters en setters
    public Klant getKlant() {
        return klant;
    }

    public LocalDate getBestelDatum() {
        return bestelDatum;
    }

    public List<plant> getPlanten() {
        return new ArrayList<>(planten);
    }

    public boolean isAfgerond() {
        return isAfgerond;
    }

    public void setAfgerond(boolean afgerond) {
        isAfgerond = afgerond;
    }

    public int getAantalPlanten() {
        return planten.size();
    }

    @Override
    public String toString() {
        return "Bestelling van " + klant.getNaam() + " - " + bestelDatum +
                " - Aantal: " + planten.size() + " - Totaal: €" +
                String.format("%.2f", berekenTotaalPrijs());  // berekenTotaalPrijs() niet perekenotaalprijs
    }
}