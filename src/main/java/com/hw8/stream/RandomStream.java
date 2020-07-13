package main.java.com.hw8.stream;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomStream {

    public static void randomStreamGenerator() {
        List<Integer> list = new Random()
                .ints(15, 0, 100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Random numbers:" + list);

        Integer list1 = list.stream()
                .min(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        System.out.println("Min random stream value: " + list1);

        Integer list2 = list.stream()
                .max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        System.out.println("Max random stream value: " + list2);

        List<Integer> list3 = list.stream()
                .filter((y) -> y % 2 == 0).collect(Collectors.toList());
        System.out.println("Divisible by 2: " + list3);

        List<Integer> list4 = list.stream()
                .map(integer -> integer + 10).collect(Collectors.toList());
        System.out.println("Values + 10: " + list4);
    }
}
