package com.demente.ideas.app.functional;

import com.demente.ideas.app.sam.TriFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionalProgrammingExamples {

    public static void main(String[] args) {
        /////////////
        function();
        unaryOperator();
        biFunction();
        biOperator();
        triFunctionMySAM();
        /////////////
        predicate();
        consume();
        supplier();
    }

    public static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }

    public static List<Integer> getNumbers() {
        return getList(0, 1, 2, 3, 4, 5, 6, 8, 40, 80, 1000, 1566, 2010, 2020);
    }

    public static List<String> obtenerListaDatos() {
        return Arrays.asList("Irina", "Silvia", "Diego", "Ragnar", "Roger", "Rafa", "Jose", "Pepe");
    }

    // Function: Recibe un tipo y genera el mismo o otro tipo de dato.
    // Hay que recordar que un metodo tambien puede ser una funcion, la diferencia ahora
    // es que ahora las Funciones (Function) son tipos de datos, y al ser tipos podemos
    // involucrarlas en variables, pasarlas como parametros o retornarlas como resultado
    // de una operacion.
    public static void function() {

        // Cast number to String
        Function<Integer, String> castNumberToString = number -> String.valueOf(number);
        System.out.println(castNumberToString.apply(5));

        // Raiz cuadrada de...
        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number*number;
            }
        };
        Integer raizCuadradaDe = 5;
        System.out.println("Raiz cuadrada de " + raizCuadradaDe
                + " = " + square.apply(raizCuadradaDe));
        raizCuadradaDe = 4;
        System.out.println("Raiz cuadrada de "
                + raizCuadradaDe + " = " + square.apply(4));
    }

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////

    // Operators: Funciones que nos permiten no tener que estar definiendo que tipos de datos
    // vamos a estar recibiendo o retornando.

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////

    // UnaryOperator: es una Function (extends Function), la misma recibe un tipo y siempre debe
    // retornar un resultado del mismo tipo que se define. Esto nos evita tener que definir el
    // tipo de resultado ya que es implicito una vez definido el tipo de dato de entrada.
    public static void unaryOperator() {
        UnaryOperator<Integer> more1000 = number -> number + 1000;

        System.out.println(more1000.apply(0));
        System.out.println(more1000.apply(800));
        System.out.println(more1000.apply(1000));
    }

    // BiFunction: Es una Function (extends Function) que tomara dos tipos de datos y genera
    // otro tipo de datos
    public static void biFunction() {

        BiFunction<Integer, Long, String> castSumIntLongToString =
                (numInteger, numLong) -> String.valueOf(numInteger + numLong);

        String result = castSumIntLongToString.apply(5, 5L);
        System.out.println(result);

        ////////////////////////////////////////////////////////////

        BiFunction<Integer, Integer, Integer> sumTwoNumbers = (n1, n2) -> n1 + n2;
        Integer resultNum = sumTwoNumbers.apply(5, 5);
        System.out.println(resultNum);
    }

    // BiOperator: Similar a UnaryOperator, solamente definiendo un tipo de datos, los
    // dos tipos de datos siguientes (el segundo parametro y el resultado) deberan ser
    // del mismo tipo.
    public static void biOperator() {
        BinaryOperator<Integer> sumTwoNumbers = (n1, n2) -> n1 + n2;
        Integer resultNum = sumTwoNumbers.apply(5, 5);
        System.out.println(resultNum);
    }

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////

    // Custumer Function @FunctionalInterface -> SAM
    // TriOperator: Funcion definida por mi que recibe tres tipos de datos y retonra
    // otro tipo de dato. Obs: todos los tipos de datos pueden ser el mismo.
    public static void triFunctionMySAM() {
        TriFunction<Integer, Integer, Integer, String> sumTriAndPrint =
                (n1, n2, n3) -> "Result" + (n1 + n2 + n3);

        String result = sumTriAndPrint.apply(10,5,125);
        System.out.println(result);
    }

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////


    // Predicate: Es una interface generica, al ser generica trabaja sobre un tipo de dato
    // y testea si el mismo cumple determinada condicion,
    // devuelve un booleano dependiendo si cumple o no la condicion (predicado).
    public static void predicate() {

        // Ejemplo con Integer
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Integer test = 4;
        if(isEven.test(test)) {
            System.out.println(test + "is even");
        } else {
            System.out.println(test + "not is even");
        }

        // Ejemplo con String
        Predicate<String> isDiego = name -> name.equals("Diego");
        String name = "Irina";
        if(isDiego.test(name)) {
            System.out.println(name + " is Diego");
        } else {
            System.out.println(name + " not is Diego");
        }
    }

    // Consumer: Es una interface generica, al ser generica trabaja sobre un tipo de
    // datos. Consume el tipo de dato, por ejemplo, puede realizar operaciones sobre
    // el dato, como borrar archivos, o cambiarlos.
    public static void consume() {

        Consumer<StringBuilder> concatenarSimbolo = palabra -> {
            if(palabra.length() > 0) {
                palabra.append("$");
            }
        };

        StringBuilder name = new StringBuilder("Irina");
        System.out.println("Antes de aplicar Consume: " + name);
        concatenarSimbolo.accept(name);
        System.out.println("Despues de aplicar Consume: " + name);
    }

    // Supplier: Es una interface generica, y al ser generica puede trabajar sobre un tipo de datos,
    // es una funcion que se encargar de proveer datos, puede servir para generar configuraciones
    // o archivos bajo demanda, o generar muchos datos de manera infinita a traves de un supplier
    public static void supplier() {

        Supplier<String> generarNombre = () -> new String("Diego");
        String nombre = generarNombre.get();
        System.out.println(nombre);
    }
}
