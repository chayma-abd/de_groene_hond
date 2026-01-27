package model;

/**
 * Plant met alle gegevens.
 */
public class plant {
    private String artikelnummer;
    private double hoogte;
    private double diameter;
    private double prijs;
    private String kleur;
    private PlantSoort soort;

    public plant(String artikelnummer, double hoogte, double diameter,
                 double prijs, String kleur, PlantSoort soort) {
        this.artikelnummer = artikelnummer;
        this.hoogte = hoogte;
        this.diameter = diameter;
        this.prijs = prijs;
        this.kleur = kleur;
        this.soort = soort;
    }

    public String getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(String artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public double getHoogte() {
        return hoogte;
    }

    public void setHoogte(double hoogte) {
        this.hoogte = hoogte;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public PlantSoort getSoort() {
        return soort;
    }

    public void setSoort(PlantSoort soort) {
        this.soort = soort;
    }

    @Override
    public String toString() {
        return artikelnummer + " - " + soort + " - " + kleur + " - €" + String.format("%.2f", prijs);
    }
}