import java.util.*;

public class Main {
    public static void main(String[] args) {

        // names = [swapna, aditya, abhishek]


        /*
            Collection -> Data structure to store data

            Array, List, Stack, Set, Map, Queue

            1. Array -> Contiguous in nature

            // array[60] = ["swapna", "aditya", "abhishek"....]

         */

        // [0, 1, 2....n-1] , n = size of the array

//        String[] names = new String[3];
//        names[0] = "swapna";
//        names[1] = "aditya";
//        names[2] = "abhishek";
//
//        for(int i = 0; i < names.length; i++) {
//            System.out.println(names[i]);
//        }

        /*
            Q-1 -> You are given a sorted array of distinct integers, you want to find out the second largest element in the array

                int[] array = new int[5];

                array = [1, 2, 3, 4, 6];

                after first iteration -> largest value = 6

                find ith largest value => We need i iterations
                find nth largest value => we need n iterations => every iteration = O(n^2)

                array.length = size of array

                In java, we have zero based indexing for arrays
                array[array.length-2]
         */

        /*
            2. List -> Array of any data [non contiguous in nature], homogenous data

            List = [1, 2, 3, 4, 6]
            1 = 100
            2 = 101 or something else

            // ArrayList, LinkedList, Vector

                // ArrayList => dynamic arrays
                            size is automatically adjusted as data grows -> grow();

                ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            arrayList.add(i+1);
        }

        arrayList.remove(2);

        System.out.println(arrayList.get(2));


        */


        /*
            LinkedList -> Implementation of linked list in java, -> linear DS -> two parts -> value, next address

         */

//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i < 100; i++) {
//            linkedList.add(i + 1);
//        }
//
//        linkedList.remove(2);
//
//        System.out.println(linkedList.get(2));



    /*
        Vectors are synchronised in nature => only one thread can access/modify at once
     */

    /*
    3. Stack -> Implementation of stack data structure => follows LIFO (Last in fast out)

    Q -> Given a list of strings, you need to reverse the order of list

    Q -> Remove the last inserted string

    List = ["Geeks", "For", "Geeks", "Development"];





     */

//        Stack<String> stack = new Stack<>();
//        stack.push("Geeks");
//        stack.push("For");
//        stack.push("Geeks");
//        stack.push("Development");
//
//        ListIterator<String> itr = stack.listIterator(2);
//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//        }

//        while(!stack.empty()) {
//            System.out.println(stack.peek());
//            stack.pop();
//        }

        /*
            4. Set Interface -> Store data without duplicates => unique entries

            // HashSet, TreeSet, LinkedHashSet

            HashSet -> Classic implementation of hash table
                    ordering is not guaranteed
                    Elements are inserted on the based of hash code
                    Insert null elements as well
         */


//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("Geeks");
//        hashSet.add("For");
//        hashSet.add("Geeks");
//        hashSet.add("Development");
//
////        System.out.println(hashSet);
//
//        Iterator<String> itr = hashSet.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//        }




/*
    Q -> Given an unsorted list of integers, find out the "first pair" whose sum is equal to target
        If no pair exist => return -1

        L = [1, 2, 3, 5, 7, 4, 8, 10, 20]
        Target = 15


        Set = [1, 2, 3, 5, 7, 4]
        b = 8
        a = 7 (target-b)



        a...b
        a comes prior to b


        a + b = target
        a = target - b => 15 - arr[i]
 */

//        List<Integer> list = Arrays.asList(1, 2, 3, 5, 7, 4, 8, 10, 20);
//
//        Set<Integer> set = new HashSet<>();             // preferred
//        HashSet<Integer> hashSet1 = new HashSet<>();     // over this

        // Always program to interface rather than concrete implementation
        // interface -> blueprint or a contract

//        int target = 15;
//
//        for(Integer b : list) {
//            Integer a = target-b;
//            if(set.contains(a)) {
//                System.out.println(a + " " + b);
//                break;
//            }
//            set.add(b);
//        }


/*

    Map -> key value store, [key->value], key cannot have duplicates

 */

//    HashMap<String, String> mentorInfo = new HashMap<>();
//
//    mentorInfo.put("Name", "Ashish");
//    mentorInfo.put("company", "Salesforce");
//    mentorInfo.put("Course", "JBDL73");
//
//    for(Map.Entry<String, String> entry : mentorInfo.entrySet()) {
//        String key = entry.getKey();
//        String value = entry.getValue();
//
//        System.out.println(key + " : " + value);
//
//    }


        /*

        Anonymous inner class


        Set<Integer> set = new Set<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };


        Types of interfaces ->

        1. Normal Interface
        2. Marker Interface - separately

        3. Functional Interface [SAM] = Single abstract method, but it can have any number of default methods



        */


        Runnable2 runnable = new Runnable2() {
            @Override
            public int add(int i, int j) {
                return i + j;
            }
        };

        Runnable2 runnable2 = (i, j) -> i + j;

        System.out.println(runnable2.add(1, 2));


        // Lambda expressions -> only works with functional interfaces


        List<Integer> list = Arrays.asList(1, 2, 3, 7, 5, 7, 8, 8, 8, 8, 10);
        Integer target = 15;

        int count = 0;

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(Integer el : list) {
            if (frequencyMap.containsKey(el)) {
                frequencyMap.put(el, frequencyMap.get(el) + 1);
            } else {
                frequencyMap.put(el, 1);
            }
        }


        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            Integer frequencyOfDiff = frequencyMap.get(target - key);
            if(frequencyOfDiff != null) {
                count += frequencyOfDiff*value;
            }

        }

        System.out.println(count/2);

    }
}

    /*
     Q ->  Given an unsorted list of integers, find out the number of pairs whose sum is equal to target
                If no such pairs exist, you can return -1;

                L = [1, 2, 3, 7, 5, 7, 8, 8, 8, 8, 10]
                Target = 15

                1 -> 1
                2 -> 1
                3 -> 1
                7 -> 2
                5 -> 1
                8 -> 4
                10 -> 1




     */



