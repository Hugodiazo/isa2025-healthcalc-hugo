package healthcalc.strategies;

public class EnglishMessages implements MessageStrategy {
    @Override
    public String buildBMRMessage(float height, float weight, float bmr) {
        return "The person with height " + height + " cm and weight " + weight + " kg has a BMR of " + bmr;
    }
}