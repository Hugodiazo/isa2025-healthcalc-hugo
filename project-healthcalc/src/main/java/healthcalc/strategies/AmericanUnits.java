package healthcalc.strategies;

public class AmericanUnits implements UnitStrategy {
    @Override
    public float convertHeight(float height) {
        return height * 30.48f; // pies a cm
    }

    @Override
    public float convertWeight(float weight) {
        return weight * 0.453592f; // libras a kg
    }
}