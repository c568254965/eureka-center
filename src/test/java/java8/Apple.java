package java8;

import java.util.Arrays;
import java.util.List;

import static io.reactivex.netty.protocol.http.sse.ServerSentEvent.Type.Data;

/**
 * Created by sloan on 2019/9/2.
 */

public class Apple  {


    private String color;
    private Integer weight;



    public static List<Apple> getData(){

        Apple a1 = new Apple("红色",10);
        Apple a2 = new Apple("蓝色",20);
        Apple a3 = new Apple("绿色",30);
        Apple a4 = new Apple("橙色",40);
        Apple a5 = new Apple("紫色",50);
        Apple a6 = new Apple("黄色",60);
        Apple a7 = new Apple("青色",70);

        return Arrays.asList(a1,a2,a3,a4,a5,a6,a7);
    }


    public static List<Apple> getNoSortedData(){

        Apple a1 = new Apple("红色",10);
        Apple a2 = new Apple("蓝色",20);
        Apple a3 = new Apple("绿色",30);
        Apple a4 = new Apple("橙色",40);
        Apple a5 = new Apple("紫色",50);
        Apple a6 = new Apple("黄色",60);
        Apple a7 = new Apple("青色",70);

        return Arrays.asList(a1,a7,a3,a2,a4,a6,a5);
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public static String appleFoo(){
        System.out.println("this is static");
        return "static";
    }

    public Apple() {
    }

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
