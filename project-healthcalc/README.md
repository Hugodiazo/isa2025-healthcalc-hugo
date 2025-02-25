# isa2025-healthcalc
Health calculator used in Ingeniería del Software Avanzada.

Vamos a desarrollar una calculadora que permita estimar varios parámetros de salud de una persona,
como su peso ideal o su tasa metabólica basal (TMB).

Practica 1

Con la altura y el género de una persona como entrada, obtenemos como salida su peso ideal.
Con el peso, altura, género y edad de una persona como entrada, obtenemos como salida su metabolismo basal.

Despues de leer el capitulo “A Self-Assessment Test” del libro “The art of software testing”, entendemos como las pruebas de software se volvieron más complejas debido a la diversidad de tecnologías, pero también más fáciles gracias a todas las nuevas herramientas; como asi tambien la importancia que tienen las mismas.


Test para peso ideal:

1.	Calculo normal para hombre
Entrada: height = 175, gender = 'M'
Salida esperada: 68.75 kg
2.	Calculo normal para mujer
Entrada: height = 160, gender = 'F'
Salida esperada: 55.5 kg
3.	Altura invalida (negativa o irreal)
Entrada: height = -50, gender = 'M'
Salida esperada: Excepción indicando que la altura no es válida.
4.	Genero invalido
Entrada: height = 170, gender = 'X'
Salida esperada: Excepción indicando que el genero solo puede ser ‘M’ o ‘F’.

Test para metabolismo basal:

5.	Calculo normal para hombre
Entrada: weight = 70, height = 175, age = 25, gender = 'M'
Salida esperada: 1668 kcal/día
6.	Calculo normal para mujer
Entrada: weight = 60, height = 165, age = 30, gender = 'F'
Salida esperada: 1400 kcal/día
7.	Peso invalido (muy bajo o muy alto)
Entrada: weight = 10, height = 170, age = 25, gender = 'M'
Salida esperada: Excepción indicando que el peso no es válido.
8.	Edad invalida (menor a 0 o mayor a 120 años)
Entrada: weight = 70, height = 175, age = -5, gender = 'M'
Salida esperada: Excepción indicando que la edad no es válida.