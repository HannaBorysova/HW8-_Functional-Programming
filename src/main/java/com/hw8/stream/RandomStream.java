package main.java.com.hw8.stream;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomStream {
    private final int STREAM_SIZE = 15;
    private final int RANDOM_NUMBER_ORIGIN = 0;
    private final int RANDOM_NUMBER_BOUND = 100;

    List<Integer> list = new Random()
            .ints(STREAM_SIZE, RANDOM_NUMBER_ORIGIN, RANDOM_NUMBER_BOUND)
            .boxed()
            .collect(Collectors.toList());


    public void printRandomStreamGenerator() {
        System.out.println("Random numbers:" + list);
    }

    public void printMinRandomStreamValue() {

        Integer list1 = list.stream()
                .min(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        System.out.println("Min random stream value: " + list1);
    }

    public void printMaxRandomStreamValue() {
        Integer list2 = list.stream()
                .max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        System.out.println("Max random stream value: " + list2);
    }

    public void printDivisibleRandomStreamValue(int divider) {
        List<Integer> list3 = list.stream()
                .filter((y) -> y % divider == 0).collect(Collectors.toList());
        System.out.println("Divisible elements: " + list3);
    }

    public void printIncreaseRandomStreamValue(int magnifier) {
        List<Integer> list4 = list.stream()
                .map(integer -> integer + magnifier).collect(Collectors.toList());
        System.out.println("Increased elements values: " + list4);
    }
}
