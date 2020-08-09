package com.platzi.functional._15_streams_intro;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
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

        //Unir una lista de palabras. En este caso el reduce ejecuta un acumulador binario simple. El resultado es un optional del mismo tipo de dato del stream
        Stream aLongStoryStream = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
        Optional longStoryOptional = aLongStoryStream.reduce((previousStory, nextPart) -> previousStory + " " + nextPart);
        longStoryOptional.ifPresent(System.out::println); //"Cuando despertó, el dinosaurio todavía estaba allí."

        //Suma de los primeros 10 numeros. Este ejemplo de reduce(), se itera por separado el Stream, y luego en el reduce se agrupan todos a un mismo valor con la operacion binaria y retorna un tipo de dato especifico del mismo tipo de dato del stream.
        IntStream firstTenNumbersStream = IntStream.iterate(0, i -> i + 1).limit(10);
        int sumOfFirstTen = firstTenNumbersStream.reduce(0, Integer::sum); //45 -> 0 + 1 + … + 9
        System.out.println(sumOfFirstTen);

        //Contamos la cantidad de letras totales que posee todas las letras juntas. Este ejemplo de reduce itera y ejecuta la reduccion en la misma funcion pero retorna un tipo de dato diferente al stream. En este reduce cambia el tipo de dato del Stream
        Integer aLongStoryStream2 = Stream.of("Cuando", "despertó,", "los", "dinosaurios", "todavían", "estaban", "allí.") // Crea el Stream list de los elementos por separados
                .reduce(0,(count, word) -> count + word.length() // Ejecuta la funcion binaria que primero almacena un valor por cada elemento del Stream List, es decir para cada elemento calcula el valor en un diferete tipo de dato basado en el mismo valor inicial de la indentidad
                , Integer::sum); //Ejecuta la operacion Binaria para reducir todos los elementos a un solo valor
        System.out.println(aLongStoryStream2);

        //Evaluamos las palabras que contengan un numero par de letras
        Stream initialCourses = Stream.of("Java", "Spring", "Node.js").map(course -> course.length()).filter(courselenght -> courselenght % 2 == 0);

        //Creamos un IntStream (stream de enteros). Adicional creamos una secuencia de enteros infinita
        IntStream infiniteStream4 = IntStream.iterate(0, x -> x + 1);
        //Convertimos el IntStream a Stream de integer con el metodo boxed(), es decir convierte un Stream de un tipo de datos especificos por naturaleza a un stream
        //de datos especificos a manera general. Adicional con el metodo collect() recopilamos los datos del stream en una propia estructura fisica de datos
        //es decir una estructura concreta que ya no tiene operaciones, de datos resultantes de multiples operaciones a un stream.
        List<Integer> numberList = infiniteStream4.limit(1000).filter(x -> x % 2 == 0 ).boxed().collect(Collectors.toList());


    }

}
