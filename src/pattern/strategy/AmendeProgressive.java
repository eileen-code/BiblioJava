package pattern.strategy;

public class AmendeProgressive implements StrategieAmende {

    private double tarifBase;
    private int seuil1;
    private int seuil2;

    public AmendeProgressive(double tarifBase, int seuil1, int seuil2) {
        this.tarifBase = tarifBase;
        this.seuil1 = seuil1;
        this.seuil2 = seuil2;
    }

    @Override
    public double calculerAmende(int joursRetard) {

        if (joursRetard <= seuil1) {
            return joursRetard * tarifBase;
        } 
        else if (joursRetard <= seuil2) {
            return (seuil1 * tarifBase) + 
                   ((joursRetard - seuil1) * (tarifBase * 2));
        } 
        else {
            return (seuil1 * tarifBase)
                 + ((seuil2 - seuil1) * (tarifBase * 2))
                 + ((joursRetard - seuil2) * (tarifBase * 3));
        }
    }
}
