/*
Singleton Design Pattern -> When we want to restrict object creation to just one
    How we can restrict object creation -> private constructor
 */


public class SingletonDP {
    /*
            1. Eager initialisation -> create object initially and use it when required
                => use this only when the class is light or its guranteed the object will be required
    */
//    String config;
//
//    private static SingletonDP singletonDP = new SingletonDP("hd");
//
//    private SingletonDP(String config) {
//        this.config = config;
//    }
//
//    public static SingletonDP getInstance() {
//        return singletonDP;
//    }

    /*
     2.
        Classic implementation => Not thread safe
     */

//    private String config;
//
//    private static SingletonDP singletonDP;
//
//    private SingletonDP(String config) {
//        this.config = config;
//    }
//
//    public static SingletonDP getInstance() {
//        if(singletonDP == null) {
//            singletonDP = new SingletonDP("hd");
//        }
//        return singletonDP;
//    }


    /*
        3. Using synchronised keyword =>

     */

//  String config;
//
//    private static SingletonDP singletonDP;
//
//    private SingletonDP(String config) {
//        this.config = config;
//    }
//
//    synchronized public static SingletonDP getInstance() {
//        if(singletonDP == null) {
//            singletonDP = new SingletonDP("hd");
//        }
//        return singletonDP;
//    }


  //   singletonDP = null, t1 -> put a lock => enters => singletonDP == null => create obj
 //     singletonDP != null, t1 -> put a lock => get the object


//    4. Double checked locking
String config;

    private static SingletonDP singletonDP;

    private SingletonDP(String config) {
        this.config = config;
    }

    public static SingletonDP getInstance() {
        if(singletonDP == null) {
            synchronized (SingletonDP.class) {
                if(singletonDP == null) singletonDP = new SingletonDP("hd");
            }
        }
        return singletonDP;
    }


    //   singletonDP = null, t1 -> put a lock => enters => singletonDP == null => create obj
    //     singletonDP = null, t1 => get the object
    //     singletonDP = null, t2 => get the object

}

