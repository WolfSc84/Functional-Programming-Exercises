package com.platzi.functional._14_optionals;

import java.util.*;

public class OptionalsWolf {

    public static void main(String[] args) {
        List<String> names = getNames();
        if(names != null){
            //Operar con nombres
        }

        //Instanciamos un optional que recibe un optional desde una funcion
        Optional<List<String>> optionalNames = getOptionalNames();
        if(optionalNames.isPresent()){

        }

        //Evaluamos el optional para determinar una condicion si dicho optionalNames es diferente de null
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        //Definimos un optional que recibe un objeto optional desde una funcion
        Optional<String> valuablePlayer = optionalValuablePlayer();

        //Evaluamos si el optional es empty cargamos un dato default si no cargamos el dato.
        String valuablePlayerName = valuablePlayer.orElseGet(() -> "No player");

    }

    static List<String> getNames(){
        List<String> list = new LinkedList<>();


        if(list.size() > 0) {
            //Retorna la lista
            return list;
        }else{
            //Retorna una lista que no tiene elementos.
            return Collections.emptyList();
        }
    }

    static String mostValuablePlayers(){

        //POdemos retornar un valor nullo con un return "" o en su defecto con un valor null.
        return null;
    }

    static int mostExpensiveItem(){
        return -1;
    }

    //Definimos un optional del tipo de dato List con el cual encapsulamos el dato para poder manejar casos donde el dato sea nulo o este vacio.
    static Optional<List<String>> getOptionalNames(){
        List<String> nameslist = new LinkedList<>();
        if(nameslist.isEmpty()) {
            //Retorna el optional que puede contener un null value. Tambien podriamos retornar un Optional.empty() en caso de que decidamos devolver un optional vacio
            return Optional.ofNullable(nameslist);
        }else {
            //Retorna el optional con un no-null value. En caso de ser nulo arrojara un NullPointerException
            return Optional.of(nameslist);
        }
    }

    //Definimos un optional del tipo de dato String con el cual encapsulamos el dato para poder manejar casos donde el dato sea nulo o este vacio.
    static Optional<String> optionalValuablePlayer(){

        try{
            //Acceder a una base de datos por ejemplo
            //Retorna el optional con un no-null value. En caso de ser nulo arrojara un NullPointerException
            return Optional.of("wolf");
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
            //return Optional.ofNullable() podria ser otra opcion;
        }
    }



}
