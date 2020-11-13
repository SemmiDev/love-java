package com.learn.sammidev;

/*
 Monday,August 10
 Sammi Aldhi Yanto
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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


        int[] numbers = {2,4,3,1,5,8,7,6};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("index : " + Arrays.binarySearch(numbers, 7));
        System.out.println("index : " + Arrays.binarySearch(numbers, 1));
        System.out.println("index : " + Arrays.binarySearch(numbers, 2));
        System.out.println("index : " + Arrays.binarySearch(numbers, 100));

        int[] result = Arrays.copyOf(numbers,5);
        System.out.println(Arrays.toString(result));
        int[] result2 = Arrays.copyOfRange(numbers,5,7);
        System.out.println(Arrays.toString(result2));

        String name = "sammidev";
        String encoded = Base64.getEncoder().encodeToString(name.getBytes());
        System.out.println(encoded);

        byte[] result3 = Base64.getDecoder().decode(encoded);
        System.out.println(new String(result3));

        BigInteger priceA = new BigInteger("100000000000000000000");
        BigInteger priceB = new BigInteger("90000000000000000000000");
        BigInteger priceC = priceA.add(priceB);
        System.out.println(priceC);

        Date date = new Date();
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.HOUR_OF_DAY, 22);
        Date result4 = calendar.getTime();
        System.out.println(result4);


        var min = Math.min(1000,2000);
        System.out.println(min);

        var max = Math.max(1000,2003);
        System.out.println(max);

        var result5 = Math.abs(-100);
        System.out.println(result5);
        System.out.println(Math.PI);

        System.out.println(Math.ceil(20.2));
        System.out.println(Math.floor(20.2));

        System.out.println(Math.sqrt(100));
        System.out.println(Math.nextAfter(10,5));
        System.out.println(Math.sin(45));
        System.out.println(Math.cos(45));
        System.out.println(Math.tan(45));

        Integer int1 = 200;
        Long long1 = int1.longValue();
        Double double1 = long1.doubleValue();
        Short Short1 = double1.shortValue();
        String sampleDouble = "130.20";
        Double contohDouble = Double.valueOf(sampleDouble);
        System.out.println(contohDouble);


        App.execute(new App.Data("sammidev"));
        runtime();
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

    private static String loveAnnotation(Object param) {
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


    static void readProperties() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("app.properties"));
            String host = properties.getProperty("database.host");
            String port = properties.getProperty("database.port");
            String username = properties.getProperty("database.username");
            String password = properties.getProperty("database.password");
            String database = properties.getProperty("database.database");

            System.out.println(host);
            System.out.println(port);
            System.out.println(username);
            System.out.println(password);
            System.out.println(database);

        } catch (FileNotFoundException e) {
            System.out.println("FILE ENGGAK ADA");
        } catch (IOException e) {
            System.out.println("GAGAL LOAD DATA DARI FILE");
        }finally {
            System.out.println("OK");
        }


        try {
            Properties properties = new Properties();
            properties.put("name.name", "Sammidev");
            properties.put("name.email", "sammidev@gmail.com");
            properties.put("name.phone", "01928012392");

            properties.store(new FileOutputStream("name.properties"), "admin config");
        } catch (FileNotFoundException r) {
            System.out.println("FILE ENGGAK ADA ");
        } catch (Exception e) {
            System.out.println("GAGAL MENYIMPAN PROPERTIES");
        }
    }

    static void randomApp() {
        Random random= new Random();
        for (int i = 0; i < 100; i++) {
            int val = random.nextInt(100);
            System.out.println(val);
        }
    }

    static void regex() {
        String name = "sammidev";
        Pattern pattern = Pattern.compile("[a-zA-Z]*[a][a-zA-Z]*");
        Matcher matcher = pattern.matcher(name);

        while (matcher.find()) {
            String result = matcher.group();
            System.out.println(result);
        }
    }

    static void runtime() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.maxMemory());
    }

    static void scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama : ");
        String name = scanner.nextLine();
        System.out.print("Umur : ");
        Integer age = scanner.nextInt();
        System.out.println("Hello " + name + " umur anda adalah " + age);
    }

    static void str() {
        String name = "Sammidev";
        String nameLowercase = name.toLowerCase();
        String nameUppercase = name.toUpperCase();


        System.out.println(name);
        System.out.println(nameLowercase);
        System.out.println(nameUppercase);
        System.out.println(name.length());
        System.out.println(name.startsWith("Sa"));
        System.out.println(name.endsWith("dev"));

        String[] names = name.split(" ");
        for(var value : names){
            System.out.println(value);
        }

        System.out.println(" ".isBlank());
        System.out.println(" ".isEmpty());
        System.out.println("".isEmpty());
        System.out.println(name.charAt(0));

        char[] chars = name.toCharArray();
    }

    static void strBuilder() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sam");
        builder.append(" ");
        builder.append("Dev");
        builder.append(" ");
        builder.append("Ganteng");

        String name = builder.toString();
        System.out.println(name);
    }

    static void join() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        joiner.add("sammidev");
        joiner.add("sammidev2");
        joiner.add("sammidev3");

        String value = joiner.toString();
        System.out.println(value);
    }

    static void strTokenizer() {
        String value = "Sammidev ganteng";

        StringTokenizer tokenizer = new StringTokenizer(value, " ");

        while(tokenizer.hasMoreTokens()){
            String result = tokenizer.nextToken();
            System.out.println(result);
        }
    }

    static void system() {

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(System.getenv("NAME"));
        System.out.println(System.getenv("APP"));
        System.out.println(System.getenv("VERSION"));

        System.gc();
        System.exit(1);
        System.out.println("Hello");
    }

    static void uuid() {
        for(var i = 0; i < 1000; i++){
            UUID uuid = UUID.randomUUID();
            String key = uuid.toString();
            System.out.println(key);
        }
    }

}

class App {
    static class Data {
        private String name;

        public Data(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return Objects.equals(name, data.name);
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static void execute(Data data) {
        System.out.println(Objects.toString(data));
        System.out.println(Objects.hashCode(data));
    }
}