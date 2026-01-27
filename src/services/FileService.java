package services;

import model.Bestelling;
import model.plant;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class FileService {

    public static void schrijfBestelbon(Bestelling bestelling, String voertuig, String leverdatum) {
        String bestandsnaam = maakBestandsnaam(bestelling);

        try (FileWriter writer = new FileWriter(bestandsnaam)) {
            writer.write("=== DEN GROENEN HOND - BESTELBON ===\n\n");
            writer.write("Klant: " + bestelling.getKlant().getNaam() + "\n");
            writer.write("Besteldatum: " + bestelling.getBestelDatum() + "\n");
            writer.write("------------------------------------\n\n");

            writer.write("BESTELDE PLANTEN:\n");
            int teller = 1;
            for (plant p : bestelling.getPlanten()) {
                writer.write(teller + ". " + p.getArtikelnummer() + " - " +
                        p.getSoort() + " - " + p.getKleur() +
                        " - €" + String.format("%.2f", p.getPrijs()) + "\n");
                teller++;
            }

            writer.write("\n------------------------------------\n");
            writer.write("TOTAAL: €" + String.format("%.2f", bestelling.berekenTotaalPrijs()) + "\n");
            writer.write("Voertuig: " + voertuig + "\n");
            writer.write("Leverdatum: " + leverdatum + "\n");
            writer.write("====================================\n");

            System.out.println("Bestelbon opgeslagen als: " + bestandsnaam);

        } catch (IOException e) {
            System.err.println("Fout bij opslaan bestelbon: " + e.getMessage());
        }
    }

    private static String maakBestandsnaam(Bestelling bestelling) {
        // "<naam van de klant>-<besteldatum>.txt"
        String klantNaam = bestelling.getKlant().getNaam().toLowerCase()
                .replace(" ", ".")
                .replaceAll("[^a-zA-Z0-9.-]", "");
        String datum = bestelling.getBestelDatum().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return klantNaam + "-" + datum + ".txt";
    }
}