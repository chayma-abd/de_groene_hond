package util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Hulpfuncties voor validatie.
 */
public class ValidatieUtil {

    /**
     * Controleert of een string niet leeg is.
     */
    public static boolean isNietLeeg(String tekst) {
        return tekst != null && !tekst.trim().isEmpty();
    }

    /**
     * Controleert of een getal positief is.
     */
    public static boolean isPositief(double getal) {
        return getal > 0;
    }

    /**
     * Controleert of een BTW-nummer geldig is (simpele versie).
     */
    public static boolean isGeldigBtwNummer(String btw) {
        return btw != null && btw.length() >= 6;
    }

    /**
     * Controleert of een datum geldig is.
     */
    public static boolean isGeldigeDatum(String datum) {
        try {
            LocalDate.parse(datum);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Controleert of een telefoonnummer alleen cijfers bevat.
     */
    public static boolean isGeldigTelefoon(String telefoon) {
        return telefoon != null && telefoon.matches("\\d+");
    }
}