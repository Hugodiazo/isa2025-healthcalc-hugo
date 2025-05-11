package healthcalc.strategies;

public class SpanishMessages implements MessageStrategy {
    @Override
    public String buildBMRMessage(float height, float weight, float bmr) {
        return "La persona con altura " + height + " cm y " + weight + " kg tiene un BMR de " + bmr;
    }
}