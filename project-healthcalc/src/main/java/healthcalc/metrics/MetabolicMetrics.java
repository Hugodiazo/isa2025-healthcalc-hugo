package healthcalc.metrics;

import healthcalc.person.Person;

public interface MetabolicMetrics {
    double basalMetabolicRate(Person person);
}