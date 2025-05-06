package healthcalc;
public class Main {
    public static void main(String[] args) {
        try {
            HealthCalc calc = HealthCalcImpl.getInstance();
            float bmr = calc.basalMetabolicRate(70f, 175, 25, 'M');
            float pesoIdeal = calc.idealWeight(175, 'M');

            System.out.println("BMR: " + bmr);
            System.out.println("Peso ideal: " + pesoIdeal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
