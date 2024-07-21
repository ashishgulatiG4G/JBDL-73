package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;





public class Main {



    public static void main(String[] args)  {


        // Application of exception handling -> maintain the normal flow of application
        // Default Exception handler ->
                // 1. Prints exception description and stacktrace
                // 2. Terminates the program




        UncheckedExceptions uncheckedExceptions = new UncheckedExceptions();
        uncheckedExceptions.check();

        CheckedExceptions checkedExceptions = new CheckedExceptions();
        checkedExceptions.check();

        MultipleTryCatch multipleTryCatch = new MultipleTryCatch();
        multipleTryCatch.check();



    }
}