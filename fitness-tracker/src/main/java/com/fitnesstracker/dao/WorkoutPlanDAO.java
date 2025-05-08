package com.fitnesstracker.dao;


import com.fitnesstracker.model.WorkoutPlan;

public interface WorkoutPlanDAO {
    WorkoutPlan save(WorkoutPlan workoutPlan);
}