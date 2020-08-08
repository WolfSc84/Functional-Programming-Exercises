package com.platzi.functional._10_chaining;

public class ChainingPhrases {
    //Los chaining nos ahorran almacenar datos o resultados en diferentes variables
    public static void main(String[] args) {
        //Funcion StringBuilder que nos permite crear un String mediante metodos que permiten agregar datos de cualquier tipo convirtiendolos en una cada de caracteres.
        StringBuilder stringcompleto = new StringBuilder();
        //Ejemplo del uso de chaining. Se observa que se llama un metodo tras de otro.
        stringcompleto.append("Texto1").append(4).append(234).append(34.5).append("La casa de papel");

        System.out.println(stringcompleto);

        //Definimos nuestro propio objeto para demostrar como programar nuestro propio chainer
        Chainer chainer = new Chainer();
        chainer.sayHi().sayBye();
    }

    static class Chainer{
        //Metodo que retorna esta misma instancia por medio del uso de this en el return y asi podemos realizar el chaining de nuestros metodos. Ojo los metodos son del mismo tipo de la clase que los contiene
        public Chainer sayHi(){
            System.out.println("Hola");
            //Retornamos la misma instancia
            return this;
        }
        //Metodo que retorna esta misma instancia por medio del uso de this en el return y asi podemos realizar el chaining de nuestros metodos. Ojo los metodos son del mismo tipo de la clase que los contiene
        public Chainer sayBye(){
            System.out.println("Bye");
            //Retornamos la misma instancia
            return this;
        }
    }
}
