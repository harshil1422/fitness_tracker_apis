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
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Activity description cannot be empty")
    private String activityDescription;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
