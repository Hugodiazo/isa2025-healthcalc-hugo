package healthcalc.decorators;

import healthcalc.HealthCalc;

public abstract class AbstractDecorator implements HealthCalc {
    protected HealthCalc innerCalc;

    public AbstractDecorator(HealthCalc innerCalc) {
        this.innerCalc = innerCalc;
    }

    @Override
    public float calculateIdealWeight(int height, char gender) throws Exception {
        return innerCalc.calculateIdealWeight(height, gender);
    }

    @Override
    public float calculateBMR(float weight, int height, int age, char gender) throws Exception {
        return innerCalc.calculateBMR(weight, height, age, gender);
    }
}