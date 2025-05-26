// HealthCalcProxy.java
package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class HealthCalcProxy implements HealthCalc, HealthStats {
    private final HealthCalc realCalc;
    private final List<Float> alturas = new ArrayList<>();
    private final List<Float> pesos = new ArrayList<>();
    private final List<Integer> edades = new ArrayList<>();
    private final List<Float> bmrs = new ArrayList<>();
    private int hombres = 0;
    private int mujeres = 0;

    public HealthCalcProxy(HealthCalc realCalc) {
        this.realCalc = realCalc;
    }

    @Override
    public float calculateIdealWeight(int height, char gender) throws Exception {
        if (gender == 'M') hombres++;
        else if (gender == 'F') mujeres++;

        alturas.add((float) height);
        return realCalc.calculateIdealWeight(height, gender);
    }

    @Override
    public float calculateBMR(float weight, int height, int age, char gender) throws Exception {
        pesos.add(weight);
        edades.add(age);

        float bmr = realCalc.calculateBMR(weight, height, age, gender);
        bmrs.add(bmr);

        return bmr;
    }

    // Métodos de HealthStats
    @Override
    public float averageHeight() {
        return promedio(alturas);
    }

    @Override
    public float averageWeight() {
        return promedio(pesos);
    }

    @Override
    public float averageAge() {
        return promedio(edades);
    }

    @Override
    public float averageBMR() {
        return promedio(bmrs);
    }

    @Override
    public int countMale() {
        return hombres;
    }

    @Override
    public int countFemale() {
        return mujeres;
    }

    @Override
    public int totalPatients() {
        return hombres + mujeres;
    }

    private float promedio(List<? extends Number> lista) {
        if (lista.isEmpty()) return 0;
        float suma = 0;
        for (Number n : lista) suma += n.floatValue();
        return suma / lista.size();
    }
}
