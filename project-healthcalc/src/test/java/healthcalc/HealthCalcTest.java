package healthcalc;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {
	
    private final HealthCalc calc = new HealthCalcImpl();
    
    //‍ TESTS PARA PESO IDEAL (idealWeight)

	@Test
	@DisplayName("calculo para hombre")
	void testIdealWeightHombre() throws Exception {
		float resultado = calc.idealWeight(175, 'M');
        assertEquals(68.75f, resultado, 0.1, "el peso ideal debe ser 68.75 kg");
	}
	
	@Test
    @DisplayName("calculo para mujer")
    void testIdealWeightMujer() throws Exception {
        float resultado = calc.idealWeight(160, 'F');
        assertEquals(56f, resultado, 0.1, "el peso ideal debe ser 56 kg");
    }
	// 55.5 segun el chat y segun yo 56
	
	@Test
    @DisplayName("altura invalida (negativa)")
    void testAlturaInvalida() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.idealWeight(-50, 'M');
        });
        assertEquals("Altura no válida", exception.getMessage());
    }
	
	@Test
    @DisplayName("genero invalido")
    void testGeneroInvalido() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.idealWeight(170, 'X');
        });
        assertEquals("genero no valido", exception.getMessage());
    }
	
	
	 //  TESTS PARA METABOLISMO BASAL (basalMetabolicRate)
	
	@Test
    @DisplayName("calculo normal para hombre")
    void testBMRHombre() throws Exception {
        float resultado = calc.basalMetabolicRate(70, 175, 25, 'M');
        assertEquals(1724, resultado, 1, "el metabolismo basal debe ser 1724 kcal/día");
    }
	// a mi me dio 1724.052 y al chat le dio 1668

    @Test
    @DisplayName("calculo normal para mujer")
    void testBMRMujer() throws Exception {
        float resultado = calc.basalMetabolicRate(60, 165, 30, 'F');
        assertEquals(1383, resultado, 1, "el metabolismo basal debe ser 1383 kcal/día");
    }
    // a mi me dio 1383,683 y al chat le dio 1400

    @Test
    @DisplayName("peso invalido (muy bajo)")
    void testPesoInvalido() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.basalMetabolicRate(10, 170, 25, 'M');
        });
        assertEquals("peso no valido", exception.getMessage());
    }

    @Test
    @DisplayName("edad invalida")
    void testEdadInvalida() {
        Exception exception = assertThrows(Exception.class, () -> {
            calc.basalMetabolicRate(70, 175, -5, 'M');
        });
        assertEquals("edad no valida", exception.getMessage());
    }
    
	
}