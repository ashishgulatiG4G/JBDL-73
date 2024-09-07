package com.example.Class_15_MinorProject;

import java.util.List;

import static java.lang.Math.abs;

public class Sum {

    public static int findSum(List<Integer> arr) {
        int sum = 0;
        for(Integer val : arr) {
            sum += val;
        }

        return sum;
    }

}
