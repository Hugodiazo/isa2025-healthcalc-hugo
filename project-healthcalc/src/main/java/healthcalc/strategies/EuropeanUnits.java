package healthcalc.strategies;

public class EuropeanUnits implements UnitStrategy {
    @Override
    public float convertHeight(float height) {
        return height * 100; // metros a cm
    }

    @Override
    public float convertWeight(float weight) {
        return weight / 1000; // gramos a kg
    }
}