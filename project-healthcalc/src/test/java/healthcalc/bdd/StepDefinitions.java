package healthcalc.bdd;

import org.junit.jupiter.api.Assertions;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import healthcalc.HealthCalcImpl;

public class StepDefinitions {

    private HealthCalcImpl healthCalc;
    private float result;
    private boolean exceptionThrown;
    private String exceptionMessage;
    private char gender;
    private int height;

    @Before
    public void setup() {
        healthCalc = new HealthCalcImpl();
        result = 0;
        exceptionThrown = false;
        exceptionMessage = "";
        gender = ' ';
        height = 0;
    }

    @Dado("tengo una calculadora de salud")
    public void tengo_una_calculadora_de_salud() {
        healthCalc = new HealthCalcImpl();
    }

    @Y("un usuario de genero {string} con altura de {int} cm")
    public void un_usuario_de_genero_con_altura_de(String genero, Integer altura) {
        this.gender = genero.charAt(0);
        this.height = altura;
    }

    @Cuando("calcula su peso ideal")
    public void calcula_su_peso_ideal() {
        try {
            result = healthCalc.idealWeight(height, gender);
        } catch (Exception e) {
            exceptionThrown = true;
            exceptionMessage = e.getMessage();
        }
    }

    @Entonces("la calculadora retorna {float} kg")
    public void la_calculadora_retorna_kg(Float expectedWeight) {
        Assertions.assertEquals(expectedWeight, result, 0.1, "El peso ideal calculado no es correcto");
    }
}