import java.util.HashSet;

class Basket<T, G>{
    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    private T item;
    private G length;

    public <H> void func(H param1, H param2) {
        System.out.println(param1);
        System.out.println(param2);
    }

}

class BreadBasket{
    public Bread getItem() {
        return item;
    }

    public void setItem(Bread item) {
        this.item = item;
    }

    private Bread item;


}

class CakeBasket{
    public Cake getItem() {
        return item;
    }

    public void setItem(Cake item) {
        this.item = item;
    }

    private Cake item;
}

class Cake{
    public Cake(String name) {
        this.name = name;
    }

    private String name;
}

class Bread{
    public Bread(String type) {
        this.type = type;
    }

    private String type;
}



public class Main {



    public static void main(String[] args) {
        /*

            Generics, Streams, Exception Handling

            Generics

                1. Type Safety
                2. Typecasting is not required
                3. Code reusability

         */

//        HashSet<Integer>
//        HashSet<String>
        // HashSet<Double>


//        HashSet hashSet = new HashSet();
//
//        hashSet.add(1);
//        hashSet.add(2);
//        hashSet.add("12");
//
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(1);
        hashSet.add(2);


        Integer sum = 0;

        for(Object obj : hashSet) {
            Integer a = (Integer) obj;
            sum += a;
        }

        System.out.println(sum);


        Basket<Cake, Integer> cakeBasket = new Basket<>();
        cakeBasket.setItem(new Cake("Chocolate"));

        Basket<Bread, Integer> breadBasket = new Basket<>();
        breadBasket.setItem(new Bread("Multigrain"));


        breadBasket.func(1, 2);
        breadBasket.func("ashish", "gfg");


    }



//    Generic Methods





    /*


     */





}