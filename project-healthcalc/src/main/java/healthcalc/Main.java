package healthcalc;
public class Main {
    public static void main(String[] args) {
        try {
            HealthCalc calc = HealthCalcImpl.getInstance();
            float bmr = calc.basalMetabolicRate(70f, 175, 25, 'M');
            float pesoIdeal = calc.idealWeight(175, 'M');

            System.out.println("BMR: " + bmr);
            System.out.println("Peso ideal: " + pesoIdeal);

            HealthHospital adapter = new HealthCalcAdapter();
            System.out.println("BMR adaptado: " + adapter.bmr('M', 25, 1.75f, 70000));
            System.out.println("Peso ideal adaptado: " + adapter.idealWeight('M', 1.75f));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
