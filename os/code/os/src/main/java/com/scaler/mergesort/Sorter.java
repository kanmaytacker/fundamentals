package com.scaler.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sorter implements Callable<List<Integer>> {
    private List<Integer> values = new ArrayList<>();
    private ExecutorService executorService;

    @Override
    public List<Integer> call() throws Exception {

        // Base case - If size of array 1 is return
        if (values.size() <= 1) {
            return values;
        }

        // Split the array
        int mid = values.size() / 2;

        List<Integer> leftArray = values.subList(0, mid);
        List<Integer> rightArray = values.subList(mid, values.size());

        Sorter leftSorter = new Sorter(leftArray, executorService);
        Sorter rightSorter = new Sorter(rightArray, executorService);

        Future<List<Integer>> sortedLeft = executorService.submit(leftSorter);
        Future<List<Integer>> sortedRight = executorService.submit(rightSorter);

        // Merge the array
        return merge(sortedLeft, sortedRight);
    }

    private List<Integer> merge(Future<List<Integer>> sortedLeftFuture, Future<List<Integer>> sortedRightFuture)
            throws InterruptedException, ExecutionException {
        List<Integer> sortedArray = new ArrayList<>();
        int first = 0;
        int second = 0;

        List<Integer> sortedLeft = sortedLeftFuture.get();
        List<Integer> sortedRight = sortedRightFuture.get();

        // Compare values from both the arrays
        while (first < sortedLeft.size() && second < sortedRight.size()) {
            // If left is smaller, add to sorted array
            // increment first
            if (sortedLeft.get(first) < sortedRight.get(second)) {
                sortedArray.add(sortedLeft.get(first));
                ++first;
            } else {
                // Add the right one to the sorted array
                // increment second
                sortedArray.add(sortedRight.get(second));
                ++second;
            }
        }

        while (first < sortedLeft.size()) {
            sortedArray.add(sortedLeft.get(first));
            ++first;
        }

        while (second < sortedRight.size()) {
            sortedArray.add(sortedRight.get(second));
            ++second;
        }

        return sortedArray;
    }

}

// Parallel - multiple tasks at same time instant
// 7:11 - Task 1
// 7:11 - Task 2

// Person 1 Done
// Person 2 IN PROCESS
// Person 3 NOT started

// Concurrency - Two tasks at different stages of execution
// Person 1 - Intro 10% IN PROCESS
// Person 2 - intro 10% IN PROCESS
// Person 3 - intro 10% IN PROCESS

// Person 1 - Query
