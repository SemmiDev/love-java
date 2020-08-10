package com.learn.sammidev;

/*
 Monday,August 10
 Sammi Aldhi Yanto
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static void loveCollections() {
        List<String> students = new ArrayList<>();
        Map<Integer, String> ages = new HashMap<>();
        Set<String> email = new HashSet<>();

        // iter -> tab
        for (String student : students) {
            System.out.println(student);
        }
    }

    private static void loveCollectionsFactories() {
        List<String> unModified = List.of("sammidev","ayatullah","others");
        List<String> listOfStrings = unModified.stream()
                .filter(s -> s.startsWith("sa"))
                .sorted()
                .collect(Collectors.toList());
    }

    private static void lovaLambda() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"sammidev");
        map.put(2,"Ayatullah");
        String csvSample = map.values().stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));

        List<String> arr = Arrays.asList(csvSample.split(","));
        for (String value : arr) {
            System.out.println(value);
        }

        map.computeIfAbsent(1, Object::toString);
    }

    private static void loveOptional() {
        List<String> students = List.of("sammidev","ayatullah","aditya");
        Optional<String> aValue = students.stream()
                .filter(s -> s.equals("sammidev"))
                .findFirst();

        aValue.ifPresentOrElse(System.out::println, () -> System.out.println("tidak ada yg sama"));
    }

    private static void loveTime() {

        LocalDateTime now = LocalDateTime.now();
        DayOfWeek week = now.getDayOfWeek();
        int month = now.getDayOfMonth();
        int year = now.getDayOfYear();
        System.out.println(now.getMinute());

        LocalDateTime daysMin = now.minusDays(5);
        System.out.println(daysMin);

        LocalDate tod = LocalDate.of(now.getYear(), now.getDayOfMonth(),now.getMonthValue());
        System.out.println(tod);
    }

    private static void loveException() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = simpleDateFormat.parse("not a date");
        } catch (ParseException e) {
            System.out.println("this is not a date");
        }
    }

    @Contract(pure = true)
    private @NotNull static String loveAnnotation(@NotNull Object param) {
        String value = param.toString();
        return "this can never return null";
    }


    // next -> love jshell



    private static void loveWhereAppropriate() {
        var name = "sammidev";
        var names = List.of("sammidev","Aditya");
    }

    private void loveAccessModifier() {
        new MyInnerClass();
    }

    static class MyInnerClass {

    }



    private String switchExpression(int someVal) {
        String retVal = "sammidev";
        return switch (someVal) {
            case 1 -> retVal;
            case 2 -> retVal + "2";
            default -> throw new IllegalStateException("unexpecte val " + someVal);
        };
    }

    private void taktau() {
        String hellow = "Samidev";
        var a = new Student("sammidev");

    }


    private class Student {
        private String name;
        Student(String name) {
            this.name = name;
        }
    }


    String sql =
            """
               sammidev
            """;

}