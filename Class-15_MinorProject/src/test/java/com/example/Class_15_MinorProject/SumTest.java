package com.example.Class_15_MinorProject;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumTest {

    @BeforeClass
    public static void setup() {
        System.out.println("Before class");
    }

    @Before
    public void setupMethod() {
        System.out.println("Before test");
    }

    @Test
    public void testFindSum() {
        System.out.println("Testing1");
        List<Integer> arrayList = Arrays.asList(-1, 2, -3, 4);
        int expectedSum = 10;
        assertEquals(expectedSum, Sum.findSum(arrayList));

    }



}
