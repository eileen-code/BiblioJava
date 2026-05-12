package pattern.strategy;

public class AmendeStandard implements StrategieAmende {

    private double tarifJour;

    public AmendeStandard(double tarifJour) {
        this.tarifJour = tarifJour;
    }

    @Override
    public double calculerAmende(int joursRetard) {
        return joursRetard * tarifJour;
    }
}
