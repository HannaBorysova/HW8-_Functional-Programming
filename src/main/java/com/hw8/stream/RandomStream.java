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

        Integer MinValueList = list.stream()
                .min(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        System.out.println("Min random stream value: " + MinValueList);
    }

    public void printMaxRandomStreamValue() {
        Integer MaxValueList = list.stream()
                .max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        System.out.println("Max random stream value: " + MaxValueList);
    }

    public void printDivisibleRandomStreamValue(int divider) {
        List<Integer> dividerList = list.stream()
                .filter((y) -> y % divider == 0).collect(Collectors.toList());
        System.out.println("Divisible elements: " + dividerList);
    }

    public void printIncreaseRandomStreamValue(int magnifier) {
        List<Integer> inreasedList  = list.stream()
                .map(integer -> integer + magnifier).collect(Collectors.toList());
        System.out.println("Increased elements values: " + inreasedList);
    }
}
