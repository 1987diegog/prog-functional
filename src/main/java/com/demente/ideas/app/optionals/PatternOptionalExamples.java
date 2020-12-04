package com.demente.ideas.app.optionals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PatternOptionalExamples {

    public static void main(String[] args) {
        optionalIfPresent();
    }

    public static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }

    public static Optional<List<Integer>> getNumbers() {
        Optional<List<Integer>> listOptional =
                Optional.of(getList(0, 1, 2, 3, 4, 5, 6, 8, 40,
                        80, 1000, 1566, 2010, 2020));
        return listOptional;
    }

    public static Optional<List<String>> obtenerListaDatos() {
        Optional<List<String>> listOptional =
                Optional.of(Arrays.asList("Irina", "Silvia", "Diego", "Ragnar", "Roger",
                        "Rafa", "Jose", "Pepe"));
        return listOptional;
    }

    public static Optional<String> nameOptionalById (int id) {
        if(id > 0) {
            return Optional.of("Diego");
        } else {
            return Optional.empty();
        }
    }

    public static void optionalIfPresent() {

        nameOptionalById(45).ifPresent(System.out::println);

        try {
            String name = nameOptionalById(-8).orElseThrow(() -> new ClassNotFoundException());
            System.out.println(name);
        } catch (ClassNotFoundException e) {
            System.out.println("No existe");
        }

        System.out.println("Map numbers");
        nameOptionalById(23).map(number -> "Text " + number.toString())
                .ifPresent(System.out::println);
    }
}
