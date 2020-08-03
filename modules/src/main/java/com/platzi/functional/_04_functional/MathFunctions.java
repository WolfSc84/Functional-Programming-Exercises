package com.platzi.functional._04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        System.out.println("Hola Wolf");

        //Tipo de sintaxis #1 para implementar interfaz Function
        //Declaramos la funcion usando un objeto de tipo Function en el cual definimos el elemento que recibe y el elemento que retorna
        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                 return x * x;
            }
        };

        //Ejecutamos la funcion. Basta con colocar el nombre de la funcion y ejecutar su unico metodo llamado apply segun la interfaz Function
        System.out.println(squareFunction.apply(5));
        System.out.println(squareFunction.apply(25));

        //Tipo de sintaxis #2 para implementar interfaz Function
        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        //Implementacion de la interfaz Predicate
        Predicate<Integer> isEven = x -> x % 2 == 0;
        //Ejecutamos la funcion. Basta con colocar el nombre de la funcion y ejecutar su unico metodo llamado test segun la interfaz Predicate
        System.out.println(isEven.test(6));

        //Implementacion  como ejemplo de la interfaz Predicate utilizando una clase anidada estatica
        Predicate<Student> isApproved = student -> student.getCalificacion() >= 6.0;

        //Creamos un objeto para probar la funcion Predicate creada previamente.
        Student wolf = new Student(7);
        //Ejecutamos la funcion. Basta con colocar el nombre de la funcion y ejecutar su unico metodo llamado test segun la interfaz Predicate
        System.out.println(isApproved.test(wolf));


    }

    static class Student{
        private double calification;

        public Student(double calification){
            this.calification = calification;
        }

        public double getCalificacion() {
            return calification;
        }

    }

}
