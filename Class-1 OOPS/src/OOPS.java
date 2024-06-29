public class OOPS {
    public static void main(String[] args) {
        Vehicle rapid = new Car();

        rapid.accelerate();


        Honda bike = new Honda();
        bike.run();



    }

    public int add(int a, int b) {
        return a+b;
    }

    public int add(int a, int b, int c) {
        return a+b+c;
    }
}



/*
    JDK = Java development Kit
    JRE = Java Runtime Env
    JVM = Java virtual machine

    JRE = set of libraries + class loaders + JVM
    JDK = JRE + dev tools

 */


/*

Inheritance ->

    IS-A

     Vehicle
   /    |       \
Car     Bike    Truck   ..  ..


    1. Single level inheritance
    2. Multilevel inheritance
    3. Hierarchical
    4. Multiple Inheritance

 */

/*

Polymorphism ->
       1. Compile time (Method overloading)
       2. Method Overriding -> Runtime polymorphism -> Dynamic Method dispatch


   final method -> you can't override
   final variables -> can set value once

 */

/*

Abstraction ->
    Hides the complexity and show just functionality

    Example -> Car running, a phone call,

    2 ways ->
        1. Abstract Class -> can have abstract as well as non abstract methods
        2. Interface -> all methods are public, abstract



 */