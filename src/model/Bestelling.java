package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representeert een bestelling van een klant.
 */
public class Bestelling {
    private Klant klant;
    private LocalDate bestelDatum;
    private List<Plant> planten;
    private boolean isAfgerond;

    /**
     * Maakt een nieuwe bestelling aan voor een klant.
     *
     * @param klant de klant die de bestelling plaatst
     */
    public Bestelling(Klant klant) {
        this.klant = klant;
        this.bestelDatum = LocalDate.now();
        this.planten = new ArrayList<>();
        this.isAfgerond = false;
    }

    /**
     * Voegt een plant toe aan de bestelling.
     *
     * @param plant de plant die toegevoegd moet worden
     */
    public void voegPlantToe(Plant plant) {
        if (!this.isAfgerond) {
            this.planten.add(plant);
        }
    }

    /**
     * Verwijderd een plant uit de bestelling.
     *
     * @param plant de plant die verwijderd moet worden
     */
    public void verwijderPlant(Plant plant) {
        if (!this.isAfgerond) {
            this.planten.remove(plant);
        }
    }

    /**
     * Berekent de totale prijs van de bestelling.
     *
     * @return de totale prijs als double
     */
    public double berekenTotaalPrijs() {
        double totaal = 0.0;

        for (Plant p : this.planten) {
            totaal += p.getPrijs();
        }

        return totaal;
    }

    // GETTERS (met minimale JavaDoc)

    /** @return het aantal planten in de bestelling */
    public int getAantalPlanten() {
        return this.planten.size();
    }

    /** @return de klant van deze bestelling */
    public Klant getKlant() {
        return this.klant;
    }

    /** @return de datum waarop de bestelling is geplaatst */
    public LocalDate getBestelDatum() {
        return this.bestelDatum;
    }

    /** @return een kopie van de lijst met planten */
    public List<Plant> getPlanten() {
        return new ArrayList<>(this.planten);
    }

    /** @return true als de bestelling is afgerond */
    public boolean isAfgerond() {
        return this.isAfgerond;
    }

    // SETTERS (zonder JavaDoc, vaak niet nodig)

    public void setAfgerond(boolean afgerond) {
        this.isAfgerond = afgerond;
    }

    /**
     * Geeft een stringrepresentatie van de bestelling.
     *
     * @return een string met bestellinggegevens
     */
    @Override
    public String toString() {
        return "Bestelling van " + this.klant.getNaam() + " - " +
                this.bestelDatum + " - Aantal planten: " +
                this.planten.size() + " - Totaal: €" +
                String.format("%.2f", this.berekenTotaalPrijs());
    }
}