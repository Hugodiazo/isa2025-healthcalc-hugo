package healthcalc;

import healthcalc.decorators.*;

import healthcalc.person.DefaultPerson;
import healthcalc.person.Gender;
import healthcalc.person.Person;
import healthcalc.metrics.*;


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



            System.out.println("--- TEST STATS / PROXY ---");
            HealthCalcProxy proxy = new HealthCalcProxy(HealthCalcImpl.getInstance());
            proxy.basalMetabolicRate(70, 175, 25, 'M');
            proxy.idealWeight(175, 'M');
            
            System.out.println("Total pacientes: " + proxy.totalPatients());
            System.out.println("Altura promedio: " + proxy.averageHeight());
            System.out.println("Peso promedio: " + proxy.averageWeight());
            System.out.println("Edad promedio: " + proxy.averageAge());
            System.out.println("BMR promedio: " + proxy.averageBMR());
            System.out.println("Cantidad de hombres: " + proxy.countMale());
            System.out.println("Cantidad de mujeres: " + proxy.countFemale());
                     

            System.out.println("--- DECORADOR ---");
            // Entrada única
            float pesoGramos = 77000;
            int alturaCm = 180;
            int edad = 30;
            char genero = 'M';

            // Calculadora base con región europea (gramos a kg)
            HealthCalc baseCalc = new EuropeanRegionDecorator(HealthCalcImpl.getInstance());

            // Decoradores de idioma
            HealthCalc spanishCalc = new SpanishBMRDecorator(baseCalc);
            HealthCalc englishCalc = new EnglishBMRDecorator(baseCalc);

            // Cálculo e impresión en español
            System.out.println("--- SALIDA EN ESPAÑOL ---");
            spanishCalc.basalMetabolicRate(pesoGramos, alturaCm, edad, genero);

            // Cálculo e impresión en inglés (usa las mismas unidades internas, pero muestra en ft/lb)
            System.out.println("--- SALIDA EN INGLÉS ---");
            englishCalc.basalMetabolicRate(pesoGramos, alturaCm, edad, genero);


            System.out.println("--- PRACTICA 7 ---");
            Person person = new DefaultPerson(70f, 175f, 25, Gender.MALE);

            MetabolicMetrics mm = new MetabolicMetricsImpl();
            CardiovascularMetrics cm = new CardiovascularMetricsImpl();

            System.out.printf("Peso ideal: %.2f kg%n", cm.getIdealBodyWeight(person));
            System.out.printf("TMB: %.2f kcal/día%n", mm.basalMetabolicRate(person));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
