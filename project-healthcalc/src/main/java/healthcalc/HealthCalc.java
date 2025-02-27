package healthcalc;

public interface HealthCalc {
    float idealWeight(int height, char gender) throws Exception;
    float basalMetabolicRate(float weight, int height, int age, char gender) throws Exception;
}