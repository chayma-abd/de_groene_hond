import model.plant;
import model.PlantSoort;
import model.Persoon;
import model.Klant;
import model.Personeelslid;
import model.Bestelling;
import services.LeveringService;
import services.FileService;
import services.MenuService;

public class Main {
    public static void main(String[] args) {
        // Kies 1 van de 2 opties hieronder:

        // OPTIE 1: TEST ALLES AUTOMATISCH (voor demo)
        // runAlleTesten();

        // OPTIE 2: TOON MENU (voor eindgebruiker)
        System.out.println("=== DEN GROENEN HOND - PLANTENCENTRUM ===");
        System.out.println("Project: Bestellingen en Leveringen\n");
        MenuService.toonHoofdmenu();
    }

    private static void runAlleTesten() {
        System.out.println("=== START ALLE TESTEN ===\n");

        // Test 1: Plant
        plant plant1 = new plant("P001", 1.5, 0.3, 24.99, "Groen", PlantSoort.BOOM);
        System.out.println("Test 1 - Plant: " + plant1);

        // Test 2: Persoon
        Persoon persoon1 = new Persoon("Jan Janssen", "Straat 1", "0123456789", "jan@mail.com");
        System.out.println("\nTest 2 - Persoon: " + persoon1);

        // Test 3: Klant
        Klant klant1 = new Klant("Boomkwekerij De Groene", "Bosweg 10", "0987654321",
                "info@boomkwekerij.nl", "BE0123.456.789", true);
        System.out.println("\nTest 3 - Klant: " + klant1);

        // Test 4: Personeelslid
        Personeelslid werknemer = new Personeelslid("Karel De Bezorger", "Leverstraat 5",
                "011223344", "karel@hond.nl");
        werknemer.voegVaardigheidToe("Rijbewijs bestelwagen");
        werknemer.voegVaardigheidToe("Veiligheidsopleiding");
        System.out.println("\nTest 4 - Personeelslid: " + werknemer);

        // Test 5: Bestelling
        Klant testKlant = new Klant("Test Klant", "Straat 1", "000", "test@test.nl", "BE000", false);
        Bestelling bestelling = new Bestelling(testKlant);

        plant plant2 = new plant("P002", 0.8, 0.2, 12.50, "Rood", PlantSoort.STRUIK);
        plant plant3 = new plant("P003", 2.0, 0.5, 45.00, "Geel", PlantSoort.BOOM);

        bestelling.voegPlantToe(plant1);
        bestelling.voegPlantToe(plant2);
        bestelling.voegPlantToe(plant3);

        System.out.println("\nTest 5 - Bestelling: " + bestelling);
        System.out.println("Totaalprijs: €" + bestelling.berekenTotaalPrijs());

        // Test 6: Levering berekeningen
        System.out.println("\nTest 6 - Levering Berekeningen:");
        System.out.println("Voertuig nodig: " + LeveringService.bepaalVoertuig(bestelling));
        System.out.println("Leverdatum: " + LeveringService.berekenLeverdatum(bestelling));

        // Test 7: Grote bestelling
        Bestelling groteBestelling = new Bestelling(testKlant);
        plant grotePlant = new plant("P004", 3.0, 1.0, 100.00, "Groen", PlantSoort.BOOM);
        groteBestelling.voegPlantToe(grotePlant);
        System.out.println("\nTest 7 - Grote bestelling:");
        System.out.println("Voertuig nodig: " + LeveringService.bepaalVoertuig(groteBestelling));

        // Test 8: Bestelbon schrijven
        System.out.println("\nTest 8 - Bestelbon maken:");
        String voertuig = LeveringService.bepaalVoertuig(bestelling);
        String leverdatum = LeveringService.berekenLeverdatum(bestelling).toString();
        FileService.schrijfBestelbon(bestelling, voertuig, leverdatum);

        System.out.println("\n=== ALLE TESTEN VOLTOOID ===");
    }
}