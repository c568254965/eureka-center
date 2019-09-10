package java8;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sloan on 2019/9/2.
 */


public class Java8Test {

    @Test
    public void test1() {



        MyInterface my = new MyInterface() {
            @Override
            public String myFoo() {
                return "Normal";
            }
        };
        System.out.println(my.myFoo());

        MyInterface my2 = ()-> "lambda";
        System.out.println(my2.myFoo());

        //////////////////////////////////


        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(10);


        Supplier<String> getColor = apple::getColor;

        System.out.println( getColor.get() );

        Supplier<String> appleFoo = Apple::appleFoo;

        System.out.println(appleFoo.get());


        List<Integer> collect = Stream.of(1, 2, 3).collect(Collectors.toList());
        List<String> list = Arrays.asList("1", "2");


        List<Apple> appleList = Apple.getData();
        System.out.println(appleList.toString());


        appleList.stream().filter(a->a.getWeight()>40).forEach(
                System.out::print
        );
//
//        Stream<Integer> weightStream = appleList.stream().map(a -> a.getWeight());
//        List<Integer> integerList = weightStream.filter(a -> a > 50).collect(Collectors.toList());
//        System.out.println(integerList);


        List<Apple> noSortedList = Apple.getNoSortedData();

        System.out.println("排序。。。。。\n");
        noSortedList.stream().sorted(
                Comparator.comparing(Apple::getWeight)
                //多个字段排序....Integer.compare(x,y)
                //if()else{}
        ).forEach(System.out::print);


        long count = noSortedList.stream().count();

        Apple maxAppler = noSortedList.stream().max(Comparator.comparing(Apple::getWeight)).get();
        System.out.println("\n最重的苹果"+maxAppler);



        Map<String, Apple> map = noSortedList.stream().collect(Collectors.toMap(Apple::getColor, apple1->apple1));

        System.out.println("\nmap:"+map.toString());

        System.out.println("~~~");
        Map<String, Integer> map1 = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getWeight()));
        //Map<String, Integer> map1 = map.entrySet().stream().collect(Collectors.toMap(a->a.getKey(), e -> e.getValue().getWeight()));

        List<String> colorList = noSortedList.stream().map(a -> a.getColor()).collect(Collectors.toList());


    }
}
