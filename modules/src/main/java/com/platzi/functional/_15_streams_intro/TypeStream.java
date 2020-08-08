package com.platzi.functional._15_streams_intro;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TypeStream {
    public static void main(String[] args) {
        //IntStream es un stream que emite Integers (enteros). Vamos a definir uno que genere datos continuamente basado en una funcion especifica
        //Por medio del metodo iterate que itera hasta el infinito empezando desde donde le indicamos y adicional con un UnaryOperator definimos como generamos los enteros
        IntStream infiniteStream = IntStream.iterate(0,x -> x+1 );
        //Le indicamos hasta donde iterar. Solo 1000 numeros. Procedemos a aplicar chaining para filtrar pares y verificar que todos sean pares con allMatch
        //alMatch devuelve un boolean indicando si todos los elementos del stream cumplieron con la condicion del predicate
        Boolean cumplen = infiniteStream.limit(1000).filter(x-> x % 2 == 0).allMatch(x ->  x % 2 == 0 );

        //Veamos el valor a ver si se cumple el allMatch
        System.out.println(cumplen);

        //Por medio del metodo iterate que itera hasta el infinito empezando desde donde le indicamos y adicional con un UnaryOperator definimos como generamos los enteros
        IntStream infiniteStream2 = IntStream.iterate(0,x -> x+1 );
        //Ejecutamos el filtrado de numeros pares y los imprimimos en pantalla, pero ejecutamos parallel() de manera que los datos
        //no se mostrarian desordenados ya que los procesadores van entregando los resultados paralelamente, es decir se ejecuta de forma concurrente\
        //por ello a medida que termina entrega los resultados
        infiniteStream2.limit(1000).parallel().filter(x-> x % 2 == 0).forEach(System.out::println);

        //Por medio del metodo iterate que itera hasta el infinito empezando desde donde le indicamos y adicional con un UnaryOperator definimos como generamos los enteros
        IntStream infiniteStream3 = IntStream.iterate(0,x -> x+1 );
        //Ejecutamos el filtrado de numeros pares y los imprimimos en pantalla, pero ejecutamos parallel() y forEachOrdered() de manera que los datos
        //no se mostrarian ordenados para ordenar los datos al final de cuentas
        infiniteStream3.limit(1000).parallel().filter(x-> x % 2 == 0).forEachOrdered(System.out::println);

        //Contar los elementos de un stream
        Stream yearsStream = Stream.of(1990, 1991, 1994, 2000, 2010, 2019, 2020);
        long yearsCount = yearsStream.count(); //7, solo nos dice cuantos datos tuvo el stream.
        System.out.println(yearsCount);

        //Unir una lista de palabras
        Stream aLongStoryStream = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
        Optional longStoryOptional = aLongStoryStream.reduce((previousStory, nextPart) -> previousStory + " " + nextPart);
        longStoryOptional.ifPresent(System.out::println); //"Cuando despertó, el dinosaurio todavía estaba allí."

        //Suma de los primeros 10 numeros
        IntStream firstTenNumbersStream = IntStream.iterate(0, i -> i + 1).limit(10);
        int sumOfFirstTen = firstTenNumbersStream.reduce(0, Integer::sum); //45 -> 0 + 1 + … + 9
        System.out.println(sumOfFirstTen);

        
    }

}
