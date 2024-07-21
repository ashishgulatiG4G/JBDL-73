package org.example;

public class finall {

    // finally block will always be executed
    // finally block would follow try or catch block

    public void check() {
        try {
            int x = 25/0;
        } finally{
            System.out.println("Finally block");
        }
    }

}
