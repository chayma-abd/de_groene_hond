package services;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import util.ValidatieUtil;

/**
 * Hoofdmenu voor de applicatie.
 */
public class MenuService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Klant> klanten = new ArrayList<>();
    private static List<Plant> planten = new ArrayList<>();
    private static Bestelling huidigeBestelling = null;

    static {
        // Testdata
        klanten.add(new Klant("Goston Hallemans", "Straat 1", "0123456789",
                "goston@mail.com", "BE123", false));
        planten.add(new Plant("P001", 1.5, 0.3, 24.99, "Groen", PlantSoort.BOOM));
        planten.add(new Plant("P002", 0.5, 0.2, 12.50, "Rood", PlantSoort.STRUIK));
    }

    public static void toonHoofdmenu() {
        while (true) {
            System.out.println("\n=== DEN GROENEN HOND ===");
            System.out.println("1. Klant aanmaken");
            System.out.println("2. Bestelling starten");
            System.out.println("3. Plant toevoegen");
            System.out.println("4. Bestelling afronden");
            System.out.println("5. Toon klanten");
            System.out.println("0. Afsluiten");
            System.out.print("Keuze: ");

            int keuze = scanner.nextInt();
            scanner.nextLine();

            switch (keuze) {
                case 1: maakKlant(); break;
                case 2: startBestelling(); break;
                case 3: voegPlantToe(); break;
                case 4: rondBestellingAf(); break;
                case 5: toonKlanten(); break;
                case 0: return;
                default: System.out.println("Ongeldig!");
            }
        }
    }

    private static void maakKlant() {
        System.out.print("Naam: ");
        String naam = scanner.nextLine();

        if (!ValidatieUtil.isNietLeeg(naam)) {
            System.out.println("Naam mag niet leeg zijn!");
            return;
        }

        System.out.print("BTW: ");
        String btw = scanner.nextLine();

        if (!ValidatieUtil.isGeldigBtwNummer(btw)) {
            System.out.println("BTW moet minstens 6 tekens hebben!");
            return;
        }

        System.out.print("Telefoon: ");
        String telefoon = scanner.nextLine();

        if (!ValidatieUtil.isGeldigTelefoon(telefoon)) {
            System.out.println("Telefoon moet alleen cijfers zijn!");
            return;
        }

        Klant klant = new Klant(naam, "adres", telefoon, "email", btw, false);
        klanten.add(klant);
        System.out.println("Klant toegevoegd: " + klant.getNaam());
    }

    private static void startBestelling() {
        if (klanten.isEmpty()) {
            System.out.println("Eerst klant maken!");
            return;
        }

        toonKlanten();
        System.out.print("Kies klant (1-" + klanten.size() + "): ");
        int keuze = scanner.nextInt() - 1;
        scanner.nextLine();

        if (keuze >= 0 && keuze < klanten.size()) {
            huidigeBestelling = new Bestelling(klanten.get(keuze));
            System.out.println("Bestelling gestart!");
        }
    }

    private static void voegPlantToe() {
        if (huidigeBestelling == null) {
            System.out.println("Eerst bestelling starten!");
            return;
        }

        for (int i = 0; i < planten.size(); i++) {
            System.out.println((i+1) + ". " + planten.get(i));
        }

        System.out.print("Kies plant: ");
        int keuze = scanner.nextInt() - 1;
        scanner.nextLine();

        if (keuze >= 0 && keuze < planten.size()) {
            huidigeBestelling.voegPlantToe(planten.get(keuze));
            System.out.println("Plant toegevoegd!");
        }
    }

    private static void rondBestellingAf() {
        if (huidigeBestelling == null) {
            System.out.println("Geen actieve bestelling!");
            return;
        }

        String voertuig = LeveringService.bepaalVoertuig(huidigeBestelling);
        String datum = LeveringService.berekenLeverdatum(huidigeBestelling).toString();

        FileService.schrijfBestelbon(huidigeBestelling, voertuig, datum);
        System.out.println("Bestelbon gemaakt!");
        huidigeBestelling = null;
    }

    private static void toonKlanten() {
        for (Klant k : klanten) {
            System.out.println(k);
        }
    }
}