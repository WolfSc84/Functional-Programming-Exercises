package com.platzi.functional._04_functional;

import java.sql.SQLOutput;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        //Instanciamos la funcion UnaryOperator
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        //Instanciamos la funcion UnaryOperator
        UnaryOperator<String> addMark = text -> text + "!";
        //Ejecutamos la funcion UnaryOperator por medio del metodo Apply de Function debido que es este Operator es una
        //extension de Function
        System.out.println(quote.apply("Probando una funcion operator"));
        //Ejecutamos la funcion UnaryOperator por medio del metodo Apply de Function debido que es este Operator es una
        //extension de Function
        System.out.println(addMark.apply("Hola"));

        //Instanciamos la funcion BiFunction
        BiFunction<Integer, Integer, Double> multiplicacion = (x,y) -> Double.valueOf(x*y);
        //Instanciamos la funcion BiFunction
        BiFunction<String, Integer, String> leftpad = (text, number) -> String.format("%" + number + "s", text );

        //Ejecutamos la funcion BiFunction por medio del metodo Apply de Function debido que es esta funcion es una
        //extension de Function
        System.out.println(leftpad.apply("Wolf",20));

        //Instanciamos la funcion BinaryOperator
        BinaryOperator<String> leftpad2 = (text, x) -> text + x;

        //Ejecutamos la funcion BinaryOperator por medio del metodo Apply de Function debido que es esta funcion es una
        //extension de Function
        System.out.println(leftpad2.apply("Hola","Wolfgang"));
    }
}
