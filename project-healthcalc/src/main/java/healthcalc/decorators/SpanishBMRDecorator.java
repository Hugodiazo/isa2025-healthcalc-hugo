package healthcalc.decorators;

import healthcalc.HealthCalc;

public class SpanishBMRDecorator extends LanguageDecorator {

    public SpanishBMRDecorator(HealthCalc innerCalc) {
        super(innerCalc);
    }

    @Override
    public float calculateBMR(float weight, int height, int age, char gender) throws Exception {
        float bmr = innerCalc.calculateBMR(weight, height, age, gender);

        // Aplicamos mensaje con valores YA CONVERTIDOS (porque vienen desde RegionDecorator)
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
        System.out.printf("La persona con altura %.2f cm y peso %.2f kg tiene una TMB de %.4f%n", height, weight, bmr);
    }
}