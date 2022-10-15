package com.scaler.scheduling;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.scaler.scheduling.models.IncomingProcess;
import com.scaler.scheduling.models.ScheduledProcess;

public class FirstComeFirstServe {

    public List<ScheduledProcess> schedule(List<IncomingProcess> processes) {

        // Get a sorted list of processes
        Queue<IncomingProcess> queue = prepareQueue(processes);
        List<ScheduledProcess> scheduledProcesses = new LinkedList<>();

        int time = 0;
        int index = 0;

        // Check if there are any processes in the queue
        while (!queue.isEmpty()) {
            IncomingProcess process = queue.poll();

            // Increment elapsed time by the burst time of the process
            time += process.getBurstTime();
            index += 1;

            process.setCompletedAt(time);

            // Add the process to the list of scheduled processes
            scheduledProcesses.add(new ScheduledProcess(index, process));
        }

        return scheduledProcesses;
    }

    // When ever we get a new process, we add it to the queue
    private Queue<IncomingProcess> prepareQueue(List<IncomingProcess> processes) {
        // Simulate a queue using a linked list
        Queue<IncomingProcess> queue = new LinkedList<>();

        List<IncomingProcess> sortedProcesses = new LinkedList<>(processes);

        // Sort the processes by arrival time to simulate FCFS
        sortedProcesses.sort((p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());

        for (IncomingProcess process : sortedProcesses) {
            queue.add(process);
        }
        return queue;
    }
}

// Side-assignment
// Implement tie breaking in scheduling
// If two processes have the same arrival time
// * Check the id
// * Also, you can check the burst time
// One line code