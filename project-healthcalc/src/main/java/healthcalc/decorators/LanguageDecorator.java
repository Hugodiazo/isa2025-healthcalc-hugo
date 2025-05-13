package healthcalc.decorators;


import healthcalc.HealthCalc;

public abstract class LanguageDecorator extends AbstractDecorator {

    public LanguageDecorator(HealthCalc innerCalc) {
        super(innerCalc);
    }

    public abstract void showBMRMessage(float height, float weight, float bmr);
}