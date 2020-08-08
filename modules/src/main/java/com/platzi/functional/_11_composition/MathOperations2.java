package com.platzi.functional._11_composition;

import java.util.function.Function;

public class MathOperations2 {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyBy3 = x -> {
            System.out.println("Multiplicando x: " + x + " por 3.");
            return x * 3;
        };
        //El uso de compose nos permite generar una funcion que no podemos interferir pero si podemos interferir la lambda. Se ejecuta antes la lambda y luego el llamado de la funcion que invoca el compose.
        Function<Integer, Integer> add1MultiplyBy3 = multiplyBy3.compose(y -> {
                System.out.println("Le agregare 1 a: " + y);
                return y + 1;
            });

        //El uso de andThen nos permite generar una funcion que no podemos interferir pero si podemos interferir la lambda. Se ejecuta el llamado de la funcion que invoca el andThen y luego la lambda
        Function<Integer, Integer> andSquare = add1MultiplyBy3.andThen(x -> {
                System.out.println("Elevamos al cuadrado a: " + x);
                return x * x;
            });

        System.out.println("El resultado es: " + andSquare.apply(3));
    }

}
