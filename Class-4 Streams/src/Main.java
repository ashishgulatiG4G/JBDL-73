import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*

            Streams ->
                -introduced in JAVA 8
                - Way to play around with collections
                - Modify collections



        Input [collection] -> stream -> Intermediate operations1 -> intermediate ops2- >  -> Terminal Operations -> output

        Lambdas -> short representation where we don't have to write function name, class name, arguments



         */

        HashSet hashSet = new HashSet();
        hashSet.stream();                // converts collection into stream


        /*
            Intermediate ops ->
                1. filter() -> select elements as per the Predicate passed
         */

        List<String> names = Arrays.asList("Shrey", "Rahul", "Rohan");
        List<String> result = names.stream()
                .filter(s -> s.startsWith("R") && s.endsWith("n"))
                .toList();

        System.out.println(result);

//        Q-1 Given a stream of integers, you need to return a list of odd integers
//        List = [1, 2, 4, 5, 2, 3, 6, 7]
        List<Integer> list = Arrays.asList(1, 2, 4, 5, 2, 3, 6, 7);

        List<Integer> result1 = list.stream()
                .filter(s -> s%2 == 1)
                .toList();

        System.out.println(result1);


         /*
            Intermediate ops ->
                2. map() -> stream consisting of results of applied operations
//         */
////
        List<Integer> squares = list.stream()
            .map(integer -> integer*integer)
            .toList();

        list.stream()
                .map(integer -> integer*integer)
                .forEach(y -> System.out.println(y));


//        List<Integer> squares = new ArrayList<>();
//        for(Integer inr : list) {
//            squares.add(inr*inr);
//        }


//        System.out.println(squares);


            /*
                3. Sorted -> sort the stream


         */

        names.stream().sorted().forEach(t -> System.out.println(t));



        /*
            Terminal -> Reduce


         */

        int sum = list.stream()
                .map(integer -> integer*integer)
                .reduce(10, (ans, i) -> ans+i);
        System.out.println(sum);



/*
ans = 10

for(every i) {
    ans = ans+i
}
 */


    /*
        Q -> Given a list of integers, find the first even integer
     */

        Integer result6 = list.stream()
                .filter(s -> s%2 == 0)
                .findFirst()
                        .orElse(-1);

        System.out.println(result6);



        /*

            Q - Given a list of integers, calculate the sum of square of odd numbers

                    odd numbers -> square them -> calculate sum of them
                    filter    ->   map     ->    reduce

         */

        System.out.println(sumUsingStream(list));
        System.out.println(sumUsingLoop(list));


    }

    public static Integer sumUsingStream(List<Integer> list) {
        return list.stream()
                .filter(s -> s%2 == 1)
                .map(s -> s*s)
                .reduce(0, (sum, s) -> sum + s);

    }

    public static Integer sumUsingLoop(List<Integer> list) {
        int sum = 0;
        for(Integer s : list) {
            if(s%2 == 1) {
                sum += s*s;
            }
        }

/*
        Given a list of integers, find the maximum value element present in it using Stream functions
      */
//        long count = list.stream().max((a, b) -> a-b).orElse(-1);
//
//        System.out.println(count);
//


//        perform cube on list elements and filter numbers greater than 50.


        List<Integer> list1 = list.stream()
                .map(n -> n*n*n)
                .filter(n -> n > 50)
                .toList();
        System.out.println(list1);



        return sum;
    }





}


// Given a list of integers, find the total number of elements present in the list using Stream functions? ->

//Given a list of integers, find the maximum value element present in it using Stream functions

//perform cube on list elements and filter numbers greater than 50.

