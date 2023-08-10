package com.scaler.quicksort;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class QuickSorter implements Runnable {

    private int[] values;
    private ExecutorService es;
    private int start;
    private int end;

    @Override
    public void run() {
        if(start < end) {
            int p = partition(values, start, end);
            es.execute(new QuickSorter(values, es, start, p - 1));
            es.execute(new QuickSorter(values, es, p + 1, end));
        }
    }

    private int partition (int a[], int start, int end)
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



}
