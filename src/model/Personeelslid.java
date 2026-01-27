package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Werknemer met vaardigheden.
 */
public class Personeelslid extends Persoon {
    private Set<String> vaardigheden;

    public Personeelslid(String naam, String adres, String telefoon, String email) {
        super(naam, adres, telefoon, email);
        this.vaardigheden = new HashSet<>();
    }

    /**
     * Voeg vaardigheid toe.
     */
    public void voegVaardigheidToe(String vaardigheid) {
        vaardigheden.add(vaardigheid);
    }

    /**
     * Verwijder vaardigheid.
     */
    public void verwijderVaardigheid(String vaardigheid) {
        vaardigheden.remove(vaardigheid);
    }

    /**
     * Controleer vaardigheid.
     */
    public boolean heeftVaardigheid(String vaardigheid) {
        return vaardigheden.contains(vaardigheid);
    }

    public Set<String> getVaardigheden() {
        return new HashSet<>(vaardigheden);
    }

    @Override
    public String toString() {
        return getNaam() + " - Vaardigheden: " + String.join(", ", vaardigheden);
    }
}