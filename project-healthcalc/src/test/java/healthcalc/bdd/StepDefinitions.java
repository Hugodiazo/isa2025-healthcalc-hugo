package healthcalc.bdd;

import org.junit.jupiter.api.Assertions;

import healthcalc.HealthCalcImpl;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class StepDefinitions {

    private HealthCalcImpl healthCalc;
    private float result;
    private boolean exceptionThrown;
    private String exceptionMessage;
    private char gender;
    private int height;
    private int age;
    private float weight;

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

    // ------------------------ PESO IDEAL ------------------------


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

    @Entonces("la calculadora lanza una excepcion: {string}")
    public void la_calculadora_lanza_una_excepcion(String mensajeEsperado) {
        Assertions.assertTrue(exceptionThrown, "Se esperaba una excepción pero no se lanzó ninguna.");
        Assertions.assertEquals(mensajeEsperado, exceptionMessage, "El mensaje de la excepción no es el esperado.");
    }

    @Entonces("la calculadora lanza una excepcion: altura no valida")
    public void la_calculadora_lanza_una_excepcion_altura_no_valida() {
        Assertions.assertTrue(exceptionThrown, "Se esperaba una excepción pero no se lanzó ninguna.");
        Assertions.assertEquals("altura no valida", exceptionMessage);
    }

    @Entonces("la calculadora lanza una excepcion: genero no valido")
    public void la_calculadora_lanza_una_excepcion_genero_no_valido() {
        Assertions.assertTrue(exceptionThrown, "Se esperaba una excepción pero no se lanzó ninguna.");
        Assertions.assertEquals("genero no valido", exceptionMessage);
    }


    // ------------------------ BMR (Tasa Metabólica Basal) ------------------------

    @Y("un usuario de genero {string} con peso {int} kg, altura {int} cm y edad {int} años")
    public void un_usuario_de_genero_con_peso_altura_y_edad(String genero, Integer peso, Integer altura, Integer edad) {
        this.gender = genero.charAt(0);
        this.weight = peso;
        this.height = altura;
        this.age = edad;
    }

    @Cuando("calcula su metabolismo basal")
    public void calcula_su_metabolismo_basal() {
        try {
            result = healthCalc.basalMetabolicRate(weight, height, age, gender);
        } catch (Exception e) {
            exceptionThrown = true;
            exceptionMessage = e.getMessage();
        }
    }

    @Entonces("la calculadora retorna {int} kcal-dia")
    public void la_calculadora_retorna_kcal_dia(Integer esperado) {
        Assertions.assertEquals(esperado, Math.round(result), 1, "El metabolismo basal no es correcto.");
    }

    @Entonces("la calculadora lanza una excepcion: peso no valido")
    public void la_calculadora_lanza_una_excepcion_peso_no_valido() {
        Assertions.assertTrue(exceptionThrown);
        Assertions.assertEquals("peso no valido", exceptionMessage);
    }

    @Entonces("la calculadora lanza una excepcion: edad no valida")
    public void la_calculadora_lanza_una_excepcion_edad_no_valida() {
        Assertions.assertTrue(exceptionThrown);
        Assertions.assertEquals("edad no valida", exceptionMessage);
    }

}