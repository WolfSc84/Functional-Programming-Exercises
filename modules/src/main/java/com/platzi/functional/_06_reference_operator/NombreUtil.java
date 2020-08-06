package com.platzi.functional._06_reference_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombreUtil {

    public static void main(String[] args) {
        String[] Nombres = {"Wolf", "Michelle", "Duquesa"};
        List<String> profesores = getList(Nombres);

        Consumer<String> printer = text -> System.out.println(text);
        profesores.forEach(printer);

        profesores.forEach(System.out::println);
    }

    // El uso de ... permite enviar desde 0 a N cantidad de parametros siempre y cuando sean del mismo tipo.
    public static <T> List<T> getList(T... elements){
        return Arrays.asList(elements);
    }

}
