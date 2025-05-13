package healthcalc.decorators;

import healthcalc.HealthCalc;

public abstract class RegionDecorator extends AbstractDecorator {
    public RegionDecorator(HealthCalc innerCalc) {
        super(innerCalc);
    }

    public abstract float convertHeight(float height);
    public abstract float convertWeight(float weight);
}