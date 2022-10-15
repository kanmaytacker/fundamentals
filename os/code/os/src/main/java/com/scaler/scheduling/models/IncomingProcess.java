package com.scaler.scheduling.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomingProcess {
    private int id;
    private int arrivalTime;
    private int burstTime; // How long the process will take to complete

    private int completedAt;

    public IncomingProcess(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

// List<ScheduleProcess> schedule(List<IncomingProcess>)
