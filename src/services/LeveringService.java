package services;

import model.Bestelling;
import model.Plant;
import java.time.LocalDate;

/**
 * Berekent levering details.
 */
public class LeveringService {
    private static final double BESTELWAGEN_VOLUME = 3.7;
    private static final double BESTELWAGEN_LENGTE = 2.1;
    private static final double BESTELWAGEN_BREEDTE = 1.23;
    private static final double VRACHTWAGEN_VOLUME = 4.4 * 2.1 * 2.4;
    private static final double VRACHTWAGEN_LENGTE = 4.4;

    /**
     * Bepaalt welk voertuig nodig is.
     */
    public static String bepaalVoertuig(Bestelling bestelling) {
        double totaalVolume = 0;
        double maximaleLengte = 0;

        for (Plant p : bestelling.getPlanten()) {
            double radius = p.getDiameter() / 2;
            double volume = Math.PI * radius * radius * p.getHoogte();
            totaalVolume += volume;

            if (p.getHoogte() > maximaleLengte) {
                maximaleLengte = p.getHoogte();
            }
        }

        if (totaalVolume <= BESTELWAGEN_VOLUME && maximaleLengte <= BESTELWAGEN_LENGTE) {
            return "bestelwagen";
        } else if (totaalVolume <= VRACHTWAGEN_VOLUME && maximaleLengte <= VRACHTWAGEN_LENGTE) {
            return "vrachtwagen";
        } else {
            return "te groot voor beschikbare voertuigen";
        }
    }

    /**
     * Bereken leverdatum.
     */
    public static LocalDate berekenLeverdatum(Bestelling bestelling) {
        return LocalDate.now().plusDays(1);
    }
}