package com.platzi.functional._04_functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {
    static void showHelp(CLIArguments cliArguments){

        //Instanciamos un consumer para evaluar una condicion y ejecutar una accion sin devolver nada mas.
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            if(cliArguments1.isHelp()){
                System.out.println("Manual ha sido solicitado");
            }
        };
        //Llamado del metodo accept que posee el consumer para su ejecucion y procesar el elemento que se le envio.
        consumerHelper.accept(cliArguments);
    }

    static CLIArguments generateCLI(){
        //Instanciamos un supplier para que nos devuelva un elemento especifico
        Supplier<CLIArguments> generator = () -> new CLIArguments();
        //Ejecutamos el metodo get que posee para la ejecucion del supplier
        return generator.get();
    }

}
