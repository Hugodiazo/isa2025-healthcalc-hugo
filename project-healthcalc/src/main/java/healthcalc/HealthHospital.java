package healthcalc;

public interface HealthHospital {
    double bmr(char gender, int age, float heightMeters, int weightGrams) throws Exception;
    int idealWeight(char gender, float heightMeters) throws Exception;
}