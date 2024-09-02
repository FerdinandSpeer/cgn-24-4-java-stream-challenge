package de.speer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10,12,13,14,15,16,17,18,19,20);

        numbers.stream()
                //Step 1-3:
                .filter(number -> number % 2 == 0)
                .map(number -> 2 * number)
                .sorted(Comparator.naturalOrder())
                //Step 5:
                .forEach(System.out::println);
        System.out.println("_______________________");
        int sum = numbers.stream()
                //Step 4:
                .filter(number -> number % 2 == 0)
                .map(number -> 2 * number)
                .sorted(Comparator.naturalOrder())
                .reduce(0, (a,b) -> a+b);

        System.out.println(sum);
        System.out.println("______________________");
        //Step6:
        List <Integer> currywurst = numbers.stream()
                .filter(number -> number % 2 == 0)
                .peek(number -> System.out.println(number))
                .map(number -> 2 * number)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(currywurst);

        try {
            Files.lines(Path.of("src/main/java/de/speer/students.csv"))
                    .skip(1)
                    .forEach(line -> new Student(line.split(",")[0],line.split(",")[1],line.split(",")[2],line.split(",")[3]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}