package model;

/**
 * Representeert een klant van het plantencentrum.
 * Kan zowel een particulier als een bedrijf zijn.
 */
public class Klant extends Persoon {
    private String btwNummer;
    private boolean isBedrijf;

    /**
     * Constructor voor het aanmaken van een nieuwe klant.
     *
     * @param naam Naam van de klant (persoon of bedrijfsnaam)
     * @param adres Adres van de klant
     * @param telefoon Telefoonnummer van de klant
     * @param email E-mailadres van de klant
     * @param btwNummer BTW-nummer van de klant
     * @param isBedrijf Indicatie of het een bedrijf is
     */
    public Klant(String naam, String adres, String telefoon, String email,
                 String btwNummer, boolean isBedrijf) {
        super(naam, adres, telefoon, email);
        this.btwNummer = btwNummer;
        this.isBedrijf = isBedrijf;
    }

    // Getters en setters zonder javadoc

    /**
     * Geeft een stringrepresentatie van de klant.
     *
     * @return String met klantgegevens en type
     */
    @Override
    public String toString() {
        String type = isBedrijf ? "Bedrijf" : "Particulier";
        return getNaam() + " (" + type + ") - BTW: " + btwNummer;
    }
}