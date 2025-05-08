package com.fitnesstracker.dto;



import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class WorkoutPlanDTO {

    private Long id;

    @NotEmpty(message = "Plan name cannot be empty")
    private String planName;
}
