package com.platzi.functional._05_sam;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeUtils {

    public static void main(String[] args) {
        //Creamos una funcion para condicionar si el numero es menor que 10 de manera que agregara un cero antes del numero para que la funcion no falle
        //Notar que la nomenclatura usada es diferente eejmplo el condicional se aplica con el simbolo ? y el else de la condicion
        //se denota con el simbolo : para que asi de esta manera se coloque en una sola linea el codigo completo
        Function<Integer, String> addCeros = x -> x < 10 ? "0" + String.valueOf(x) : String.valueOf(x);
        //Instanciamos nuestra propia funcion creada a partir de nuestra propia interfaz SAM y @FunctionalInterface
        TriFunction<Integer, Integer, Integer, LocalDate> parseDate = (day, month, year) -> LocalDate.parse(year + "-" + addCeros.apply(month) + "-" + addCeros.apply(day));
        //Instanciamos nuestra propia funcion creada a partir de nuestra propia interfaz SAM y @FunctionalInterface
        TriFunction<Integer, Integer, Integer, Integer> calculatedAge =
                (day, month, year) -> Period.between(parseDate.apply(day,month,year), LocalDate.now()).getYears();

        //Ejecutamos la funcion diseñada
        System.out.println(calculatedAge.apply(22,10,1984));


    }


    @FunctionalInterface
    interface BiConsumer{
        void accept();
    }

    @FunctionalInterface
    interface TriFunction<X,Y,Z,R>{
        R apply(X x, Y y, Z z);
    }

}
