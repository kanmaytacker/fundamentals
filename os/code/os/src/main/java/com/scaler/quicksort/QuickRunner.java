package com.scaler.quicksort;

import java.util.concurrent.*;

public class QuickRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer[] arr = {10, 9, 8, 7, 1, 2, 3, 4};

        ExecutorService executor = Executors.newCachedThreadPool();
        QuickSorter sorter = new QuickSorter(arr, executor,0,arr.length-1);
        Future<Integer[]> future = executor.submit(sorter);
        arr = future.get();
        executor.shutdown();

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
