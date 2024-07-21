package org.example;


import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

class ThrowsTest {
    void abc() throws FileNotFoundException {
        File file = new File("sample.txt");
        Scanner scanner = new Scanner(file);
    }

    void xyz() {
        try {
            abc();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("exception");
        }
    }

    void pqr() {
        xyz();
    }

}

public class throwsKeyWord {

    public void check() {
        ThrowsTest throwsTest = new ThrowsTest();
        throwsTest.pqr();
    }


}
