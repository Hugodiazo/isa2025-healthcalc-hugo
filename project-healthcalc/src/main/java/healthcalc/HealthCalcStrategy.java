package healthcalc;

import healthcalc.strategies.MessageStrategy;
import healthcalc.strategies.UnitStrategy;

public class HealthCalcStrategy {
    private UnitStrategy unitStrategy;
    private MessageStrategy messageStrategy;
    private final HealthCalc calculator;

    public HealthCalcStrategy(HealthCalc calculator) {
        this.calculator = calculator;
    }

    public void setUnitStrategy(UnitStrategy unitStrategy) {
        this.unitStrategy = unitStrategy;
    }

    public void setMessageStrategy(MessageStrategy messageStrategy) {
        this.messageStrategy = messageStrategy;
    }

    public void calculateBMR(float inputHeight, float inputWeight, int age, char gender) throws Exception {
        float heightCm = unitStrategy.convertHeight(inputHeight);
        float weightKg = unitStrategy.convertWeight(inputWeight);
        float bmr = calculator.basalMetabolicRate(weightKg, (int) heightCm, age, gender);
        System.out.println(messageStrategy.buildBMRMessage(heightCm, weightKg, bmr));
    }
}