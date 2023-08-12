package com.scaler.quicksort;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class QuickSorter implements Callable<Integer[]> {

    private Integer[] values;
    private ExecutorService es;
    private int start;
    private int end;

    private int partition (Integer[] a, int start, int end)
    {
        int pivot = a[end]; // pivot element
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++)
        {
            // If current element is smaller than the pivot
            if (a[j] < pivot)
            {
                i++; // increment index of smaller element
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i+1];
        a[i+1] = a[end];
        a[end] = t;
        return (i + 1);
    }


    @Override
    public Integer[] call() throws Exception {
        if(start < end) {
            int p = partition(values, start, end);
            es.submit(new QuickSorter(values, es, start, p - 1));
            es.submit(new QuickSorter(values, es, p + 1, end));
        }
        return values;
    }
}
