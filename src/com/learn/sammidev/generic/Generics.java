package com.learn.sammidev.generic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Generics {
    public static void main(String[] args) {

        // single generic
        String something = new SingleGeneric<>("Sammidev").getSomething();
        System.out.println(something);

        // double generics
        DoubleGeneric<String, Integer> sample = new DoubleGeneric<>("Sammidev", 19);
        System.out.println(sample.toString());

        // method generic
        System.out.println(MethodGeneric.showLength(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(MethodGeneric.showLength(new String[]{"1", "2", "3", "4", "5"}));

        /**
         * covariant apapun yg extends dari object (sample nya y)
         * read only
         * @param : Integer
         * @param : String
         */

        SingleGeneric<String> data = new SingleGeneric<>("Sam");
        SingleGeneric<Integer> data2 = new SingleGeneric<>(1231);
        procces(data, data2);

        /**
         * invariant (kebalikan invariant)
         * good for write
         * @param : Integer
         * @param : String
         */

        SingleGeneric<Object> data3 = new SingleGeneric<>(1231);
        SingleGeneric<Object> data4 = new SingleGeneric<>("Sammi Aldhi Yanto");
        procces2(data4, data3);


        /**
         * Bounded : batas type saja yg diperbolehkan
         * default : object
         **/
        BoundedNumber<Integer> integerBoundedNumber = new BoundedNumber<>(1);
        BoundedNumber<Long> longBoundedNumber = new BoundedNumber<>(123123L);
        System.out.println(integerBoundedNumber.getNumber());
        System.out.println(longBoundedNumber.getNumber());


        Student student = new Student("Sammidev","19", "Tinggam", "2003113948");
        Data data1 = new Data("sammidev","19", "Tinggam");

        BoundedStudent<Student> studentBoundedStudent = new BoundedStudent<>(student);
        BoundedStudent<Data> studentBoundedStudent2 = new BoundedStudent<>(data1);

        System.out.println(studentBoundedStudent.getDetails());
        System.out.println(studentBoundedStudent2.getDetails());

        Data2<Manager> data21 = new Data2<>(new Manager("sammidev"));
        System.out.println(data21.getData());

        DoubleBounded<People> peopleDoubleBounded = new DoubleBounded<>(new People());
        System.out.println(peopleDoubleBounded.getData());


        printLength(new SingleGeneric<>("sammidev"));
        printLength(new SingleGeneric<>(123123));
        printLength(new SingleGeneric<>(true));


        // type erasure (informasi generic hilang) sample -> Data, not -> Data<DataType>
//        Dataaa data5 = new Dataaa<String>("12312dsf");
//        Dataaa<Integer> data6 = (Dataaa<Integer>) data5;
//        Integer dat = data6.getData(); // akan ERROR (salah konversi)


        Comparablee[] comparable = {
                new Comparablee("sammidev",19),
                new Comparablee("sammidev",12),
                new Comparablee("sammidev",11),
                new Comparablee("sammidev",25),
                new Comparablee("sammidev",90)
        };

        // sample sort ages
        Arrays.sort(comparable);
        System.out.println(Arrays.toString(comparable));



        Comparablee[] comparable2 = {
                new Comparablee("sammidev",19),
                new Comparablee("sammidev",12),
                new Comparablee("sammidev",11),
                new Comparablee("sammidev",25),
                new Comparablee("sammidev",90)
        };

        Comparator<Comparablee> comparableeComparator = new Comparator<Comparablee>() {
            @Override
            public int compare(Comparablee o1, Comparablee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Arrays.sort(comparable2);
        System.out.println(Arrays.toString(comparable2));
    }


    static class Comparablee implements Comparable<Comparablee>{
        @Override
        public String toString() {
            return "Comparablee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        private String name;
        private Integer age;

        public Comparablee(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public int compareTo(Comparablee o) {
            return this.age.compareTo(o.age);
        }
    }

    static class Dataaa<T> {
        T data;

        public Dataaa(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public static void procces2(SingleGeneric<? super String> data,
                                SingleGeneric<? super Integer> data2) {
        data.setSomething("sammidev");
        data2.setSomething(123123);

        Object getData2 = data2.getSomething();

        System.out.println(data.getSomething());
        System.out.println(getData2);
    }

    public static void procces(SingleGeneric<? extends Object> data,
                               SingleGeneric<? extends Object> data2) {
        Object object = data.getSomething();
        Object object2 = data2.getSomething();
        System.out.println(object);
        System.out.println(object2);
    }

    /**
     * Wildcard
     * ?
     */

    static void printLength(SingleGeneric<?> data) {
        System.out.println(data.getSomething());
    }
}


/**
 *  param1 = class
 *  param2, ... = must interface, why?? because in java not able to have more than one parent class
 *
 */

class Data2<T extends Manager> {
    private T data;

    public Data2(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
class DoubleBounded<T extends Employee & Hello> {
    private T data;

    @Override
    public String toString() {
        return "DoubleBounded{" +
                "data='" + data + '\'' +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleBounded(T data) {
        this.data = data;
    }
}

interface Hello {
    void sayHello(String name);
}
abstract class Employee {}
class Manager extends Employee {

    private String name;
    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class People extends Employee implements Hello {
    @Override
    public void sayHello(String name) {
        System.out.println("people");
    }
}

class BoundedStudent<T extends Data> {
    T details;

    public BoundedStudent(T details) {
        this.details = details;
    }

    public T getDetails() {
        return details;
    }

    public void setDetails(T details) {
        this.details = details;
    }
}
class BoundedNumber<T extends Number> {
    T number;

    public BoundedNumber(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    public void something() {
        this.number.doubleValue();
    }
}
class MethodGeneric {
    static <T> int showLength(T[] arr) {
        return arr.length;
    }
}
class DoubleGeneric<T,E> {
    private T name;
    private E age;

    public DoubleGeneric(T name, E age) {
        this.name = name;
        this.age = age;
    }

    public E getAge() {
        return age;
    }

    public void setName(T name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
class SingleGeneric<T> {
    T something;

    public SingleGeneric(T something) {
        this.something = something;
    }

    public T getSomething() {
        return something;
    }

    public void setSomething(T something) {
        this.something = something;
    }
}

class Data {
    public Data(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private String name;
    private String age;
    private String address;

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Student extends Data {
    private String nim;

    public Student(String name, String age, String address, String nim) {
        super(name, age, address);
        this.nim = nim;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nim='" + nim + '\'' +
                '}';
    }
}