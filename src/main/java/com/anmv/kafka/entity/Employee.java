package com.anmv.kafka.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Employee {
    @NonNull
    private String employeeId;

    @NonNull
    private String name;

    @NonNull
    private LocalDate birthDate;
}
