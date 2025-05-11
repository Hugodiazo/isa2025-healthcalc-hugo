package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class HealthCalcWithStats implements HealthCalc, HealthStats {
    private final HealthCalc innerCalc;
    private final List<PatientData> patients = new ArrayList<>();

    public HealthCalcWithStats(HealthCalc calc) {
        this.innerCalc = calc;
    }

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        float result = innerCalc.idealWeight(height, gender);
        record(gender, height, 0, 0f, result);
        return result;
    }

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws Exception {
        float bmr = innerCalc.basalMetabolicRate(weight, height, age, gender);
        record(gender, height, age, weight, bmr);
        return bmr;
    }

    private void record(char gender, int height, int age, float weight, float bmr) {
        patients.add(new PatientData(gender, height, age, weight, bmr));
    }

    // Métodos de HealthStats

    @Override
    public float averageHeight() {
        return (float) patients.stream().mapToInt(p -> p.height).average().orElse(0);
    }

    @Override
    public float averageWeight() {
        return (float) patients.stream().mapToDouble(p -> p.weight).average().orElse(0);
    }

    @Override
    public float averageAge() {
        return (float) patients.stream().mapToInt(p -> p.age).average().orElse(0);
    }

    @Override
    public float averageBMR() {
        return (float) patients.stream().mapToDouble(p -> p.bmr).average().orElse(0);
    }

    @Override
    public int countMale() {
        return (int) patients.stream().filter(p -> p.gender == 'M').count();
    }

    @Override
    public int countFemale() {
        return (int) patients.stream().filter(p -> p.gender == 'F').count();
    }

    @Override
    public int totalPatients() {
        return patients.size();
    }

    private static class PatientData {
        char gender;
        int height;
        int age;
        float weight;
        float bmr;

        PatientData(char gender, int height, int age, float weight, float bmr) {
            this.gender = gender;
            this.height = height;
            this.age = age;
            this.weight = weight;
            this.bmr = bmr;
        }
    }
}