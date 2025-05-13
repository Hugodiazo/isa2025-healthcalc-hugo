package healthcalc.decorators;

import healthcalc.HealthCalc;

public class EnglishBMRDecorator extends LanguageDecorator {

    public EnglishBMRDecorator(HealthCalc innerCalc) {
        super(innerCalc);
    }

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws Exception {
        float bmr = innerCalc.basalMetabolicRate(weight, height, age, gender);

        float convertedWeight = weight;
        float convertedHeight = height;

        if (innerCalc instanceof RegionDecorator region) {
            convertedWeight = region.convertWeight(weight);
            convertedHeight = region.convertHeight(height);
        }

        showBMRMessage(convertedHeight, convertedWeight, bmr);
        return bmr;
    }

    @Override
    public void showBMRMessage(float height, float weight, float bmr) {
        float heightFeet = height / 30.48f;  // cm a pies
        float weightLb = weight * 2.20462f;  // kg a libras
        System.out.printf("The person with height %.2f ft and weight %.2f lb has a BMR of %.4f%n", heightFeet, weightLb, bmr);
    }
}