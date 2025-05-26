package healthcalc;

public class HealthCalcAdapter implements HealthHospital {

    private final HealthCalc calculator = HealthCalcImpl.getInstance();

    @Override
    public double bmr(char gender, int age, float heightMeters, int weightGrams) throws Exception {
        float heightCm = heightMeters * 100;
        float weightKg = weightGrams / 1000f;
        return calculator.calculateBMR(weightKg, (int) heightCm, age, gender);
    }

    @Override
    public int calculateIdealWeight(char gender, float heightMeters) throws Exception {
        int heightCm = Math.round(heightMeters * 100);
        return Math.round(calculator.calculateIdealWeight(heightCm, gender));
    }
}