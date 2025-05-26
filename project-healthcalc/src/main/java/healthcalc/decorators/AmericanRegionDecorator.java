package healthcalc.decorators;

import healthcalc.HealthCalc;

public class AmericanRegionDecorator extends RegionDecorator {

    public AmericanRegionDecorator(HealthCalc innerCalc) {
        super(innerCalc);
    }

    @Override
    public float calculateBMR(float weight, int height, int age, char gender) throws Exception {
        float weightKg = convertWeight(weight);
        float heightCm = convertHeight(height);
        return innerCalc.calculateBMR(weightKg, (int) heightCm, age, gender);
    }

    @Override
    public float convertHeight(float height) {
        return height * 30.48f; // pies a cm
    }

    @Override
    public float convertWeight(float weight) {
        return weight / 2.20462f; // libras a kg
    }
}