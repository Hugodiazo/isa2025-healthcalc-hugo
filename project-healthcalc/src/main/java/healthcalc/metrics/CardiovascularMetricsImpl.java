package healthcalc.metrics;

import healthcalc.person.Person;
import healthcalc.person.Gender;

public class CardiovascularMetricsImpl implements CardiovascularMetrics {

    @Override
    public double getIdealBodyWeight(Person person) {
        float height = person.height();
        Gender gender = person.gender();

        return (gender == Gender.MALE)
            ? height - 100 - (height - 150) / 4.0
            : height - 100 - (height - 150) / 2.5;
    }
}