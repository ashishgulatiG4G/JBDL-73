public class Main {
    public static void main(String[] args) {
        /*

            Exception Handling

            divide by zero
         */


        int a = 10;
        int b = 0;


//        try {
//            System.out.println(a / b);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }

        System.out.println("Hey there");

//        People people = new People();
//        System.out.println(People.class);


        System.out.println(MATH.computeDivision(2, 0));

    }



/*
    Checked Exceptions -> Compile time exceptions
    Unchecked exception -> Run time exceptions, even if we don't handle the exception
                                -> you won't get a compilation error

 */



    /*

    How JVM handles exception

        At runtime, system searches all the methods on the call stack and if it is not able to
        find the appropriate handler, it handover the Exception object to default exception handler

     */

class MATH {
    static int divideByZero(int a, int b) {
        return a/b;
    }

    static int computeDivision(int a, int b) throws ArithmeticException {
        int res = 0;
        try {
            res = divideByZero(a, b);
        } catch (ArithmeticException ex){
            throw new ArithmeticException(ex.toString());
        } finally {
            System.out.println("hey in finally");
        }
        System.out.println("hey in function");
        return res;
    }
}

/*

    How programmer handles exception ->

        try, catch, throw, finally, throws

 */

}