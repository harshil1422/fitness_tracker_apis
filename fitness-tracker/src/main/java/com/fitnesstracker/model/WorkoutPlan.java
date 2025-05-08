package com.fitnesstracker.model;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class WorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Plan name cannot be empty")
    private String planName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

