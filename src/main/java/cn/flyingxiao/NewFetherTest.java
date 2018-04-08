package cn.flyingxiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Mtime on 2018/3/26.
 */
public class NewFetherTest {
    public static void main(String[] args) {
//        Arrays.asList( "a", "b", "d" ).forEach( a -> System.out.println( a ) );
//
//        Arrays.asList( 1, 2, 3 ).forEach( e -> System.out.println( e ) );
//
//        String separator = ",";
//        Arrays.asList( "a", "b", "d" ).forEach(
//                ( String e ) -> {
//                    System.out.print( e + separator );
//                }
//        );

        //////
//        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
//
//        List<String> stringList = Arrays.asList("b", "a", "c", "f", "d");
//        stringList.forEach(e -> System.out.println(e));
//
//        stringList.sort( ( e1, e2 ) -> {
//            int result = e1.compareTo( e2 );
//            return result;
//        } );
//
//        stringList.forEach(e -> System.out.println(e));


        //////
//        Optional< String > fullName = Optional.ofNullable( null );
//        System.out.println( "Full Name is set? " + fullName.isPresent() );
//        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
//        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
//
//        Optional< String > firstName = Optional.of( "Tom" );
//        System.out.println( "First Name is set? " + firstName.isPresent() );
//        System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
//        System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
//        System.out.println();

        //////
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.println("====求交集===");

        List<Integer> list=list1.stream().filter(t->list2.contains(t)).collect(Collectors.toList());
        list.stream().forEach(System.out::println);




        System.out.println("====求差集===");
        list=list1.stream().filter(t-> !list2.contains(t)).collect(Collectors.toList());
        list.stream().forEach(System.out::println);


        System.out.println("====求并集===");

        list.addAll(list1);
        list.addAll(list2);
        list=list.stream().distinct().collect(Collectors.toList());
        list.stream().forEach(System.out::println);

    }
}
