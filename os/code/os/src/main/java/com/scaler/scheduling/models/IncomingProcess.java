package com.scaler.scheduling.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class IncomingProcess {
    private int id;
    private int arrivalTime;
    private int burstTime;

    private int completedAt;

    public IncomingProcess(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}
