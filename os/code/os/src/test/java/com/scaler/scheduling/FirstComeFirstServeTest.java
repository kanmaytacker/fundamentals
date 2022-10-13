package com.scaler.scheduling;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.javatuples.Pair;
import org.junit.Test;

import com.scaler.scheduling.models.IncomingProcess;
import com.scaler.scheduling.models.ScheduledProcess;

public class FirstComeFirstServeTest {

    private static AtomicInteger generator = new AtomicInteger();

    private List<Pair<Integer, Integer>> processTimes = List.of(
            Pair.with(2, 6),
            Pair.with(1, 8),
            Pair.with(0, 3),
            Pair.with(4, 4));

    private List<Integer> expectedOrder = List.of(3, 2, 1, 4);
    private List<Integer> expectedCompletionTimes = List.of(3, 11, 17, 21);

    @Test
    public void test() {
        FirstComeFirstServe firstComeFirstServe = new FirstComeFirstServe();
        List<ScheduledProcess> scheduledProcesses = firstComeFirstServe.schedule(incomingProcesses(processTimes));

        assertEquals("If n processes are given, then n processes should be scheduled", processTimes.size(),
                scheduledProcesses.size());

        List<Integer> actualOrder = scheduledProcesses.stream().map(ScheduledProcess::getId)
                .collect(Collectors.toList());
        assertEquals("The order of the processes should be the same as the order of the input", expectedOrder,
                actualOrder);

        List<Integer> actualCompletionTimes = scheduledProcesses.stream().map(ScheduledProcess::getProcess)
                .map(IncomingProcess::getCompletedAt)
                .collect(Collectors.toList());

        assertEquals("The completion time of the processes should be the same as the expected completion times",
                expectedCompletionTimes,
                actualCompletionTimes);

    }

    private static List<IncomingProcess> incomingProcesses(List<Pair<Integer, Integer>> processTimes) {

        return processTimes.stream()
                .map(p -> new IncomingProcess(generator.incrementAndGet(), p.getValue0(), p.getValue1()))
                .collect(Collectors.toList());
    }
}
