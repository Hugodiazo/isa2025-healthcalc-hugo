package healthcalc;

public interface HealthCalc {
    float calculateIdealWeight(int height, char gender) throws Exception;
    float calculateBMR(float weight, int height, int age, char gender) throws Exception;
}