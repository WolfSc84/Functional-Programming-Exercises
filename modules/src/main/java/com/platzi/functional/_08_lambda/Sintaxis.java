package com.platzi.functional._08_lambda;

import com.platzi.functional._06_reference_operator.NombreUtil;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintaxis {

    public static void main(String[] args) {
        List<String> cursos = NombreUtil.getList("Panocho", "Marumba", "Toto", "Niky", "Java", "Functional");

        //Ejemplo de funcion lambda que recibe algo y devuelve algo
        cursos.forEach(curso -> System.out.println(curso));

        //Funcion lambda que no recibe algo pero si devuelve algo. Se definio una High Funcion previamente
        usarZero(() -> 2);

        //Funcion lambda que recibe algo y devuelve algo. Se definio una High Funcion previamente
        usarPredicado(text-> text.isEmpty());


        //Funcion lambda que recibe dos elementos y devuelve algo. Se definio una High Funcion previamente
        usarBiFunction((x,y) -> x*y);

        //Funcion lambda con varias operaciones. Debemos definir el return. Se definio una High Funcion previamente
        usarBiFunction((x,y) -> {
            System.out.println("X: " + x + ", Y: " + y);
            return x-y;
        });

        //Funcion lambda que no recibe ni devuelve algo. Se definio una High Funcion previamente
        usarNada(() -> {
            System.out.println("Hola alumno");
        });

        //Definiendo directamente el tipo de dato. Se definio una High Funcion previamente
        usarBiFunction((Integer x, Integer y) -> x*y);
    }

    //High funcion para poder ejecutar lambda
    static void usarPredicado(Predicate<String> predicado ){}

    //High funcion para poder ejecutar lambda
    static void usarZero(ZeroArguments zeroArgument){}

    //High funcion para poder ejecutar lambda
    static void usarBiFunction(BiFunction<Integer, Integer, Integer> operacion){}

    //High funcion para poder ejecutar lambda
    static void usarNada(operarNada usarNada){}

    //Interface funcional que no recibe un argumento y devuelve un entero
    @FunctionalInterface
    interface ZeroArguments{
        int get();
    }

    //Interface funcional que recibe y devuelve nada
    @FunctionalInterface
    interface operarNada{
        void nada();
    }
}
