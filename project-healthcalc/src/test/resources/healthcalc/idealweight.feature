@tag
Feature: Peso Ideal
  Como usuario de la calculadora de salud
  quiero conocer mi peso ideal 
  para poder saber si estoy saludable

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


	@tag3
  Scenario Outline: Calculo del peso ideal con altura invalida
    Given tengo una calculadora de salud
    And un usuario de genero <g> con altura de <a> cm
    When calcula su peso ideal
    Then la calculadora lanza una excepcion: <msj>

    Examples:
      |   g    |    a   |    msj           |
      | "M"    | -160   | altura no valida |
      | "F"    | -1     | altura no valida |


  @tag4
  Scenario Outline: Calculo del peso ideal con genero invalido
    Given tengo una calculadora de salud
    And un usuario de genero <g> con altura de <a> cm
    When calcula su peso ideal
    Then la calculadora lanza una excepcion: <msj>

    Examples:
      |   g    |    a   |    msj            |
      | "X"    | 170    | genero no valido  |
      | "Z"    | 160    | genero no valido  |    