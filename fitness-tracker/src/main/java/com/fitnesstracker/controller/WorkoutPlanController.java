package com.fitnesstracker.controller;

import com.fitnesstracker.dto.WorkoutPlanDTO;
import com.fitnesstracker.service.WorkoutPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/workout-plans")
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanService workoutPlanService;

    @PostMapping
    public ResponseEntity<WorkoutPlanDTO> createWorkoutPlan(@Valid @RequestBody WorkoutPlanDTO workoutPlanDTO) {
        WorkoutPlanDTO created = workoutPlanService.createWorkoutPlan(workoutPlanDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
