package com.fitnesstracker.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class ActivityLogDTO {

    private Long id;

    @NotEmpty(message = "Activity description cannot be empty")
    private String activityDescription;
}
