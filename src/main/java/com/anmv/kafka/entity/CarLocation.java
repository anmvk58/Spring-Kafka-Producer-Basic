package com.anmv.kafka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarLocation {

    @NonNull
    private String carId;
    private long timestamp;
    private int distance;

    @Override
    public String toString() {
        return "CarLocation{" +
                "carId='" + carId + '\'' +
                ", timestamp=" + timestamp +
                ", distance=" + distance +
                '}';
    }
}
