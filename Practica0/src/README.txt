Alumnos:
    Borrás Pablo Vianey Aileen
    316033619
    Prestegui Ramos Kevin Axel
    316201373

Práctica 0

I Escribe la representación en binario del número decimal 172

R = 010101100

II ¿Cuál es el número mínimo de bits requeridos para representar todos
los caracteres en un teclado que tiene nueve letras?

R= El número mínimo de bits son 4.

III ¿Cuál es el mínimo número de bits requerido para representar todos
los caracteres de un teclado de 22 teclas?

R= El número mínimo de bits son 5.


IV En general, ¿Es posible hacer la conversión entre una base n y una base
m? para cualquier n, m > 1 y n distinta de m.

Sí lo es. Ya tenemos algoritmos que dada una base n, se puedo convertir el número a su representación en base 10, y 
dado un número en base 10, obtener su representación en otra base m.
Lo único que se debería hacer es convertir el número a base 10 y después usar el algoritmo para convertir
el número a base m.

---------------------------------------------------------------------------
Decidimos modificar el orden de las carpetas para usar mvn como herramienta de manejo.
La estructura de carpetas quedó como sigue:

Practica0
|
-Pom.mx
|
-src
    |
    -readme.txt
    |
    -main
        |
        -java
            |
            -mx
               |
               -unam
                    |
                    -ciencias
                            |
                            -arquitectura
                                        |
                                        -ConvertidorDeBases.java
                                        |
                                        -Practica0.java    

Para correr el programa se necesita tener instalado Maven y correr el siguiente comando desde la carpeta Practica0:
$ mvn install
$ cd target
$ java -jar practica01.jar

Si no cuenta con mvn, se puede descargar aquí:
https://maven.apache.org

O correr el programa manualmente.