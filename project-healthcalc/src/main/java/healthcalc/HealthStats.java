package healthcalc;

public interface HealthStats {
    float averageHeight();
    float averageWeight();
    float averageAge();
    float averageBMR();
    int countMale();
    int countFemale();
    int totalPatients();
}