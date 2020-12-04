package com.demente.ideas.app.stream;

import com.demente.ideas.app.sam.TriFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class StreamsExamples {

    public static void main(String[] args) {
        /////////////
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
}