package com.scaler.scheduling;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.scaler.scheduling.models.IncomingProcess;
import com.scaler.scheduling.models.ScheduledProcess;

public class FirstComeFirstServe {

    public List<ScheduledProcess> schedule(List<IncomingProcess> processes) {
        Queue<IncomingProcess> queue = prepareQueue(processes);
        List<ScheduledProcess> scheduledProcesses = new LinkedList<>();

        int time = 0;
        int index = 0;
        while (!queue.isEmpty()) {
            IncomingProcess process = queue.poll();
            time += process.getBurstTime();
            index += 1;

            process.setCompletedAt(time);
            scheduledProcesses.add(new ScheduledProcess(index, process));
        }

        return scheduledProcesses;
    }

    private Queue<IncomingProcess> prepareQueue(List<IncomingProcess> processes) {
        Queue<IncomingProcess> queue = new LinkedList<>();

        List<IncomingProcess> sortedProcesses = new LinkedList<>(processes);
        sortedProcesses.sort((p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());

        for (IncomingProcess process : sortedProcesses) {
            queue.add(process);
        }
        return queue;
    }
}