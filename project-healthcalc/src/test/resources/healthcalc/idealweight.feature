@tag
Feature: Peso Ideal
  Como usuario quiero conocer mi peso ideal para poder saber si estoy saludable

  @tag1
  Scenario: Calculo del peso ideal para un hombre
    Given tengo una calculadora de salud
    And un usuario de genero "M" con altura de 175 cm
    When calcula su peso ideal
    Then la calculadora retorna 68.75 kg
    
  @tag2
  Scenario Outline: Calculo del peso ideal para una mujer
    Given tengo una calculadora de salud
    And un usuario de genero "F" con altura de <n> cm
    When calcula su peso ideal
    Then la calculadora retorna <value> kg
   
    	Examples: 
      |   n    |    value    |
      | 160    | 56          |
      | 170    | 62          |
      | 180    | 68          |

	