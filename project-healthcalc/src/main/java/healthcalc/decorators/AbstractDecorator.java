package healthcalc.decorators;

import healthcalc.HealthCalc;

public abstract class AbstractDecorator implements HealthCalc {
    protected HealthCalc innerCalc;

    public AbstractDecorator(HealthCalc innerCalc) {
        this.innerCalc = innerCalc;
    }

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        return innerCalc.idealWeight(height, gender);
    }

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws Exception {
        return innerCalc.basalMetabolicRate(weight, height, age, gender);
    }
}