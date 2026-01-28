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
     * Controleert of een BTW-nummer geldig is (simpele versie).
     */
    public static boolean isGeldigBtwNummer(String btw) {
        return btw != null && btw.length() >= 6;
    }

    /**
     * Controleert of een telefoonnummer alleen cijfers bevat.
     */
    public static boolean isGeldigTelefoon(String telefoon) {
        return telefoon != null && telefoon.matches("\\d+");
    }
}