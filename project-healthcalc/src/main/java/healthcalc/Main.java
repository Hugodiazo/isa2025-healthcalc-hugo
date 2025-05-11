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


            System.out.println("--- TEST STATS ---");
            HealthCalc statsCalc = new HealthCalcWithStats(HealthCalcImpl.getInstance());

            statsCalc.basalMetabolicRate(70f, 175, 25, 'M');
            statsCalc.basalMetabolicRate(65f, 160, 30, 'F');
            statsCalc.idealWeight(175, 'M');

            HealthStats stats = (HealthStats) statsCalc;
            System.out.println("Total pacientes: " + stats.totalPatients());
            System.out.println("Altura promedio: " + stats.averageHeight());
            System.out.println("Peso promedio: " + stats.averageWeight());
            System.out.println("Edad promedio: " + stats.averageAge());
            System.out.println("BMR promedio: " + stats.averageBMR());
            System.out.println("Cantidad de hombres: " + stats.countMale());
            System.out.println("Cantidad de mujeres: " + stats.countFemale());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
