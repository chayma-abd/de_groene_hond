package model;

/**
 * Basis voor alle personen.
 */
public class Persoon {
    private String naam;
    private String adres;
    private String telefoon;
    private String email;

    public Persoon(String naam, String adres, String telefoon, String email) {
        this.naam = naam;
        this.adres = adres;
        this.telefoon = telefoon;
        this.email = email;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return naam + " - " + email;
    }
}