package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        if (height <= 0) throw new Exception("altura no valida");
        if (gender != 'M' && gender != 'F') throw new Exception("genero no valido");

        return (gender == 'M') ? 
            height - 100 - (height - 150) / 4.0f :
            height - 100 - (height - 150) / 2.5f;
    }

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws Exception {
        if (weight <= 0) throw new Exception("peso no valido");
        if (age <= 0) throw new Exception("edad no valida");
        if (gender != 'M' && gender != 'F') throw new Exception("genero no valido");

        return (gender == 'M') ? 
            88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age) :
            447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
    }
}