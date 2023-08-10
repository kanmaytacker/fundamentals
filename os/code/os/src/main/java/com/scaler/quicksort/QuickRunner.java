package com.scaler.quicksort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuickRunner {

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 1, 2, 3, 4};

        ExecutorService executor = Executors.newCachedThreadPool();
        QuickSorter sorter = new QuickSorter(arr, executor,0,arr.length-1);
        executor.execute(sorter);
        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Something wrong happened");
        }
        executor.shutdown();

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
