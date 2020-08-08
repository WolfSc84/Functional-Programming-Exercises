package com.platzi.functional._09_defaults;

public class StringFunctions {

    @FunctionalInterface
    interface StringOperation{
        //Metodo abstracto unico, cuyas acciones definiremos en una lambda
        int getAmount();

        //Metodo default. Desde aqui podemos llamar nuevamente al metodo abstracto
        default void operate(String text){
            int x = getAmount();
            while(x-- > 0){
                System.out.println(text);
            }
        }
    }

    @FunctionalInterface
    interface DoOperation{
        //Metodo abstracto unico, cuyas acciones definiremos en una lambda
        void take(String take);
        //Metodo default. Desde aqui podemos llamar nuevamente al metodo abstracto
        default void execute(int x, String text){
            while(x-- >0){
                take(text);
            }
        }
    }

    public static void main(String[] args) {
        //Asignamos la operacion al metodo abstracto
        StringOperation six = () -> 6;
        //Ejecutamos la funcion default en la cual se llama nuevamente al metodo abstracto cuya acciones definimos previamente en la linea anterior
        six.operate("Alumno");
        //Asignamos la operacion al metodo abstracto
        DoOperation operateFive = text -> System.out.println(text);
        //Ejecutamos la funcion default en la cual se llama nuevamente al metodo abstracto cuya acciones definimos previamente en la linea anterior
        operateFive.execute(5,"Wolf");
    }
}