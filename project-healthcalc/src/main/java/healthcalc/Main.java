package healthcalc;

import healthcalc.strategies.AmericanUnits;
import healthcalc.strategies.EnglishMessages;


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
            HealthCalcProxy proxy = new HealthCalcProxy(HealthCalcImpl.getInstance());
            proxy.basalMetabolicRate(70, 175, 25, 'M');
            proxy.idealWeight(175, 'M');
            
            System.out.println("--- TEST STATS ---");
            System.out.println("Total pacientes: " + proxy.totalPatients());
            System.out.println("Altura promedio: " + proxy.averageHeight());
            System.out.println("Peso promedio: " + proxy.averageWeight());
            System.out.println("Edad promedio: " + proxy.averageAge());
            System.out.println("BMR promedio: " + proxy.averageBMR());
            System.out.println("Cantidad de hombres: " + proxy.countMale());
            System.out.println("Cantidad de mujeres: " + proxy.countFemale());
            


            HealthCalcStrategy strategyCalc = new HealthCalcStrategy(HealthCalcImpl.getInstance());

            strategyCalc.setUnitStrategy(new AmericanUnits());  // o EuropeanUnits
            strategyCalc.setMessageStrategy(new EnglishMessages());  // o SpanishMessages
            strategyCalc.calculateBMR(5.8f, 170f, 30, 'M');  // Altura en pies, peso en libras

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
