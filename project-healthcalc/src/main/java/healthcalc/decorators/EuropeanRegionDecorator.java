package healthcalc.decorators;

import healthcalc.HealthCalc;

public class EuropeanRegionDecorator extends RegionDecorator {

    public EuropeanRegionDecorator(HealthCalc innerCalc) {
        super(innerCalc);
    }

    @Override
    public float calculateBMR(float weight, int height, int age, char gender) throws Exception {
        float weightKg = convertWeight(weight);
        return innerCalc.calculateBMR(weightKg, height, age, gender);
    }

    @Override
    public float convertHeight(float height) {
        return height;
    }

    @Override
    public float convertWeight(float weight) {
        return weight / 1000f; // gramos a kilogramos
    }

}