package model;

/**
 * Representeert een plant in het plantcentrum.
 */
public class Plant {
    private String artikelnummer;
    private double hoogte;
    private double diameter;
    private double prijs;
    private String kleur;
    private PlantSoort soort;

    /**
     * Constructor voor een Plant object.
     *
     * @param artikelnummer het unieke artikelnummer
     * @param hoogte        de hoogte in meters
     * @param diameter      de diameter in meters
     * @param prijs         de prijs in euro
     * @param kleur         de kleur van de plant
     * @param soort         het soort plant uit de PlantSoort enum
     */
    public Plant(String artikelnummer, double hoogte, double diameter,
                 double prijs, String kleur, PlantSoort soort) {
        this.artikelnummer = artikelnummer;
        this.hoogte = hoogte;
        this.diameter = diameter;
        this.prijs = prijs;
        this.kleur = kleur;
        this.soort = soort;
    }

    // GETTERS MET JAVADOC
    /**
     * @return het artikelnummer
     */
    public String getArtikelnummer() {
        return artikelnummer;
    }

    /**
     * @return de hoogte in meters
     */
    public double getHoogte() {
        return hoogte;
    }

    /**
     * @return de diameter in meters
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * @return de prijs in euro
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * @return de kleur van de plant
     */
    public String getKleur() {
        return kleur;
    }

    /**
     * @return het soort plant
     */
    public PlantSoort getSoort() {
        return soort;
    }

    // SETTERS ZONDER JAVADOC (optioneel, vaak niet nodig in schoolopdrachten)
    public void setArtikelnummer(String artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public void setHoogte(double hoogte) {
        this.hoogte = hoogte;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public void setSoort(PlantSoort soort) {
        this.soort = soort;
    }

    /**
     * Geeft een stringrepresentatie van de plant.
     *
     * @return een string met plantgegevens
     */
    @Override
    public String toString() {
        return artikelnummer + " - " + soort + " - " + kleur + " - €" + String.format("%.2f", prijs);
    }
}