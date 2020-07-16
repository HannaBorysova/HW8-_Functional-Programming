package main.java.com.hw8.executor;

import main.java.com.hw8.stream.RandomStream;
import main.java.com.hw8.user.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Executor {
    public static void start() {
        createUsers();
        printUsersOlderForty(createUsers(), 40);
        printUsersYoungerFiftyFromDdnipro(createUsers(), 50, "Dnipro");
        printAverageAgeUsersFromLviv(createUsers(), "Lviv");
        printAmountOfUsersNotFromKyiv(createUsers(), "Kyiv");
        printFirstThreeUsersSortedByAge(createUsers(), 3);
        RandomStream randomStream = new RandomStream();
        randomStream.printRandomStreamGenerator();
        randomStream.printMinRandomStreamValue();
        randomStream.printMaxRandomStreamValue();
        randomStream.printDivisibleRandomStreamValue(2);
        randomStream.printIncreaseRandomStreamValue(10);
    }

    public static Collection<User> createUsers() {
        Collection<User> collection = Arrays.asList(
                new User("Vasya", 16, "Dnipro"),
                new User("Petya", 23, "Dnipro"),
                new User("Elena", 42, "Lutsk"),
                new User("Elena", 92, "Chernigov"),
                new User("Sergey", 5, "Kyiv"),
                new User("Maryna", 32, "Kyiv"),
                new User("Ivan Ivanovych", 69, "Lviv"));
        return collection;
    }

    public static void printUsersOlderForty(Collection<User> collection, int age) {
        List<User> list = collection.stream()
                .filter(user -> user.getAge() > age).collect(Collectors.toList());
        System.out.println("Older than 40 years old: " + list);
    }

    public static void printUsersYoungerFiftyFromDdnipro(Collection<User> collection, int age, String city) {
        List<User> list2 = collection.stream()
                .filter(user -> user.getAge() < age && user.getCity().equals(city)).collect(Collectors.toList());
        System.out.println("Younger than 50 years old from Dnipro: " + list2);
    }

    public static void printAverageAgeUsersFromLviv(Collection<User> collection, String city) {
        Double list3 = collection.stream()
                .filter(user -> user.getCity().equals(city))
                .collect(Collectors.averagingInt(User::getAge));
        System.out.println("Average age users from Lviv: " + list3);
    }

    public static void printAmountOfUsersNotFromKyiv(Collection<User> collection, String city) {
        long list4 = collection.stream()
                .filter(user -> !user.getCity().equals(city))
                .count();
        System.out.println("Amount of users not from Kyiv: " + list4);
    }

    public static void printFirstThreeUsersSortedByAge(Collection<User> collection, int limit) {
        List<User> list5 = collection.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .limit(limit)
                .collect(Collectors.toList());
        System.out.println("First three users sorted by age: " + list5);
    }
}
