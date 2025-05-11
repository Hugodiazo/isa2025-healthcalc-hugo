package healthcalc.strategies;

public interface MessageStrategy {
    String buildBMRMessage(float height, float weight, float bmr);
}