package com.learn.sammidev.collections;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        q();
    }

    static enum Gender {
        MALE,FEMALE,BENCONG,TOMBOY
    }
    static enum Level {
        SE,ME,EE
        }
    static void a() {
        List<String> names = List.of("Sammi","Dev");
        Object[] objects = names.toArray();
        String[] strings = names.toArray(new String[]{});

        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(strings));

        List<Integer> list = new ArrayList<>(1000);
        for (int i = 0; i <= 1000; i++) {
            list.add(i);
        }

        int index = Collections.binarySearch(list, 123);
        System.out.println(index);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        int index2 = Collections.binarySearch(list, 333);
        System.out.println(index2);
        System.out.println(comparator.compare(0,-6));

        Collection<String> collection = new ArrayList<>();
        collection.add("Sam");
        collection.add("mi");
        collection.addAll(List.of("sammi","ganteng","sekali"));
        for (String value : collection) {
            System.out.println(value);
        }

        collection.remove("Sam");
        collection.remove("mi");

        System.out.println(
                collection.contains("sammi")
        );
        System.out.println(collection.size());
        collection.removeAll(collection);
        System.out.println(collection.size());


        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }

        numbers.replaceAll(integer -> integer * 10);
        numbers.replaceAll(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 10;
            }
        });


        numbers.forEach(integer -> {
            System.out.println(integer);
        });


        numbers.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return index > 990;
            }
        });

        numbers.forEach(integer -> {
            System.out.println(integer);
        });
    }
    static void b() {
        List<String> list = new ArrayList<>();
        list.addAll(List.of("sammidev","siti","rahma","iwan"));

        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }

    static void c() {

    Deque<String> stack = new LinkedList<>();
    stack.offerLast("sammi");
    stack.offerLast("aldhi");
    stack.offerLast("yanto");

    System.out.println(stack.pollFirst());
    System.out.println(stack.pollLast());
    System.out.println(stack.pollLast());
    System.out.println(stack.pollLast());

    Deque<String> deque = new LinkedList<>();
    deque.offerLast("sammi");
    deque.offerLast("aldhi");
    deque.offerLast("yanti");
    System.out.println(deque.pollLast());
    System.out.println(deque.pollFirst());
    System.out.println(deque.pollFirst());
    }
    static void d() {
        Map<String, String> map = new HashMap<>();
        map.put("B", "Sam");
        map.put("A", "Sammidev");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (var entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    static void e() {
        Map<Level,String> levelStringMap = new EnumMap<Level, String>(Level.class);
        levelStringMap.put(Level.EE, "Sammidev");
        levelStringMap.put(Level.SE, "Sammidev");
        levelStringMap.put(Level.ME, "Sammidev");

        for (var key : levelStringMap.keySet()) {
            System.out.println(levelStringMap.get(key));
        }

        System.out.println(levelStringMap.get(levelStringMap.keySet()));
    }
    static void f() {
        Set<Gender> genders = EnumSet.allOf(Gender.class);
        for (var gender : genders) {
            System.out.println(gender);
        }
    }
    static void g() {
        Map<String, String> map = new HashMap<>();
        map.put("sammidev","sammidev");
        map.put("sammidev","sammidev");
        System.out.println(map.get("sammidev"));
        System.out.println(map.get("sammidev"));
    }
    static void h() {
        Map<String,String> map = new Hashtable<>();
        map.put("sammidev","Sammidev");
        map.put("dev","Sammidev");
        map.put("dev","Sammidev");
        map.put("sam","Sammidev");

        for (var key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println(map.keySet());
        System.out.println(map.values());
    }
    static void i() {
        Map<String,String> map = new IdentityHashMap<>();
        String key1 = "sammi.dev";
        String name = "sammi";
        String dot = ".";
        String first = "dev";
        String key2 = name + dot + first;
        System.out.println(key1.equals(key2));
        System.out.println(key1 == key2);


        map.put(key1, "ganteng");
        map.put(key2, "cantik");
        System.out.println(map.size());
    }

    static void j() {
        List<String> one   = Collections.singletonList("one");
        System.out.println(one);

        List<String> empty = Collections.emptyList();
        List<String> mutable = new ArrayList<>();
        mutable.add("Sammi");
        mutable.add("Dev");

        List<String> immutable = Collections.unmodifiableList(mutable);
        List<String> elements = List.of("Sammi","Dev");
    }
    static void k() {
        Map<String, String> empty = Collections.emptyMap();
        List<Integer> em = Collections.singletonList(12);
        Map<String, String> singleton = Collections.singletonMap("name", "Eko");

        Map<String, String> mutable = new HashMap<>();
        mutable.put("name", "Eko");

        Map<String, String> immutable = Collections.unmodifiableMap(mutable);
        Map<String, String> map = Map.of(
                "first", "Eko",
                "middle", "Kurniawan",
                "last", "Khannedy"
        );

    }
    static void l() {
        Iterable<String> names = List.of("S","A","M","M","I");
        for (var name : names) {
            System.out.println(name);
        }
        System.out.println("ITERATOR");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.print(name);
        }

    }
    static void m() {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("first", "Sammi");
        map.put("last", "Yanto");
        map.put("middle", "Aldhi");

        Set<String> keys = map.keySet();
        for (var key : keys) {
            System.out.println(key);
        }
    }
    static void n() {
        List<String> names = new ArrayList<>();
        names.add("sammi");
        names.add("dev");
        names.set(0, "Sammidev");
        names.remove(0);
        System.out.println(names.get(0));
        for (var val : names) {
            System.out.println(val);
        }
    }
    static void o() {
        Map<String,String> map = new HashMap<>();
        map.put("sam1","dev1");
        map.put("sam2","dev2");
        map.put("sam3","dev3");

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String val) {
                System.out.println(key + " : " + val);
            }
        });
    }
    static void p() {
        Person person = new Person("Sam");
        person.add(person.getName());
        person.add("Dev");
        person.show();
    }
    static void q(){
        NavigableMap<String,String> map = new TreeMap<>();
        map.put("Sam","Dev");
        map.put("Sam2","Dev2");
        map.put("Sam3","Dev3");

        for (var key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println(map.lowerKey("Sam"));
        System.out.println(map.higherKey("Sam"));

    }
}

class Person {

    List<String> list = new ArrayList();

    void add (String data){
        this.list.add(data);
    }

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String data) {
                System.out.println(data);
            }
        });
    }
}