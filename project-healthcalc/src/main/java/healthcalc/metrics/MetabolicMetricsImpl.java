package healthcalc.metrics;

import healthcalc.person.Person;
import healthcalc.person.Gender;

public class MetabolicMetricsImpl implements MetabolicMetrics {

    @Override
    public double basalMetabolicRate(Person person) {
        float weight = person.weight();
        float height = person.height();
        int age = person.age();
        Gender gender = person.gender();

        return (gender == Gender.MALE)
            ? 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)
            : 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
    }
}