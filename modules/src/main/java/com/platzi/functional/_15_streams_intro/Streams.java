package com.platzi.functional._15_streams_intro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        //Creamos una lista, usando una funcion que genera una lista previamente definida por ejemplo
        List<String> courseList = getList("Java", "Frontend", "Backend", "Fullstack");

        //Iteracion para tomar cada elemento de la lista
        for(String course: courseList){
            String courseName = course.toLowerCase().replace("!","!!");
            System.out.println("Platzi: " + courseName);
        }

        //Definimos un stream a traves de una funcion que genera un stream a partir de datos que ya conocemos. . Se crea un nuevo stream con dichos valores
        //Podriamos definirlo de la siguiente manera Stream<String> coursesStream = Stream.of("Java", "Frontend", "Backend", "Fullstack");
        Stream<String> coursesStream3 = Stream.of(courseList.toArray(new String[0]));

        //Podriamos definir un stream que convierta de un stream a otro. Map recibe una funcion y genera un nuevo dato tipo stream. En este ejemplo obtenemos la longitud de caracteres de cada curso
        //Stream<Integer> courseLenghtStream = coursesStream3.map(course -> course.length());
        //Luego podemos determinar el nombre mas largo luego de obtener la longitud de los cursos
        //Optional<Integer> longest = courseLenghtStream.max((x, y) -> (y-x) );

        //Con este stream agregamos emfasis a la palabra del curso añadiendo el signo de exclamacion. Se crea un nuevo stream con dichos valores
        Stream<String> emphasisCourses = coursesStream3.map(course -> course + "!");
        //Con este stream filtramos los cursos que posean la palabra Java. Se crea un nuevo stream con dichos valores
        Stream<String> justJavaCourses = emphasisCourses.filter(course -> course.contains("Java"));
        //Con esta instruccion podemos imprimir cada uno de los elementos del stream que se creo previamente
        justJavaCourses.forEach(System.out::println);

        //Con esta instruccion podemos convertir una lista o colecction a Stream
        Stream<String> coursesStreams2 = courseList.stream();
        //Podemos aplicar chaining para no tener que almacenar el resultado en cada iteracion, realizando el conjunto de operaciones sobre los elementos que debamos hacer
        //coursesStreams2.map(course -> course + "!!").filter(course -> course.contains("Java")).forEach(System.out::println);

        //Llamamos la funcion que itera sobre el stream.
        addOperator(coursesStreams2.map(course -> course + "!").filter(course -> course.contains("Java")))//Le enviamos el stream sin la funcion terminal ya que como indica es enviarle un stream
                .forEach(System.out::println);//Como la funcion devuelve un Stream podemos aplicar la funcion terminal

        //El uso del metodo collect permite ejecutar cada una de las acciones previamemnte
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }



    //Esta funcion que definimos nos permite ejecutar codigo y operadores a un stream que recibe como parametro. Esto es una High Orden Funcion
    //que toma un stream, agregando sus funciones y devuelve un stream
    static <T> Stream<T> addOperator(Stream<T> stream){
        //Peek recibe un dato y devuelve el mismo dato. Solo permite iterar dentro del dato.
        return stream.peek(data -> System.out.println("Dato: " + data));
    }

    // El uso de ... permite enviar desde 0 a N cantidad de parametros siempre y cuando sean del mismo tipo.
    public static <T> List<T> getList(T... elements){
        return Arrays.asList(elements);
    }
}
