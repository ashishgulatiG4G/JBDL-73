package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class CheckedExceptions {
    public void check() {
        // 1. FileNotFoundException
        File file = new File("sample.txt");
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        // 2. ClassNotFound exception

        try {
            Class<?> clas = Class.forName("com.example.UncheckedExceptions");

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        // 3. SQL Exception
        // DB Connection code


        //4. ParseException

        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String invalidDate = "-13-45-2024";

        try {
            Date parsedDate = dateFormat.parse(invalidDate);
            System.out.println("Parsed date: " + parsedDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.out.println("Interrupted Exception");
//        }


        URL url = null;
        try {
            url = new URL("htp:/example.com");
        } catch (MalformedURLException e) {
            System.out.println(e);
        }



    }
}
