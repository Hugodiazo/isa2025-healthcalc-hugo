Feature: Calculo de la Tasa Metabolica Basal (bmr)
  Como usuario de la calculadora de salud
  Quiero poder calcular mi tasa metabolica basal
  Para conocer cuantas calorias necesita mi cuerpo

  @bmr @hombre
  Scenario Outline: Calculo del metabolismo basal para un hombre
    Given tengo una calculadora de salud
    And un usuario de genero "M" con peso <peso> kg, altura <altura> cm y edad <edad> años
    When calcula su metabolismo basal
    Then la calculadora retorna <r> kcal-dia

    Examples:
      | peso | altura | edad |    r      |
      | 70   | 175    | 25   | 1724      |

  @bmr @mujer
  Scenario Outline: Calculo del metabolismo basal para una mujer
    Given tengo una calculadora de salud
    And un usuario de genero "F" con peso <peso> kg, altura <altura> cm y edad <edad> años
    When calcula su metabolismo basal
    Then la calculadora retorna <r> kcal-dia

    Examples:
      | peso | altura | edad |    r      |
      | 60   | 165    | 30   | 1383      |

  @bmr @error
  Scenario: Calculo del metabolismo basal con peso invalido
    Given tengo una calculadora de salud
    And un usuario de genero "M" con peso 0 kg, altura 170 cm y edad 25 años
    When calcula su metabolismo basal
    Then la calculadora lanza una excepcion: peso no valido

  @bmr @error
  Scenario: Calculo del metabolismo basal con edad invalida
    Given tengo una calculadora de salud
    And un usuario de genero "M" con peso 70 kg, altura 175 cm y edad -5 años
    When calcula su metabolismo basal
    Then la calculadora lanza una excepcion: edad no valida

  @bmr @error
  Scenario: Calculo del metabolismo basal con genero invalido
    Given tengo una calculadora de salud
    And un usuario de genero "X" con peso 70 kg, altura 175 cm y edad 25 años
    When calcula su metabolismo basal
    Then la calculadora lanza una excepcion: genero no valido

  @bmr @error
  Scenario: Calculo del metabolismo basal con altura invalida
    Given tengo una calculadora de salud
    And un usuario de genero "M" con peso 70 kg, altura -160 cm y edad 25 años
    When calcula su metabolismo basal
    Then la calculadora lanza una excepcion: altura no valida      