package com.fitnesstracker.dao.impl;


import com.fitnesstracker.dao.WorkoutPlanDAO;
import com.fitnesstracker.model.WorkoutPlan;
import com.fitnesstracker.repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WorkoutPlanDAOImpl implements WorkoutPlanDAO {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Override
    public WorkoutPlan save(WorkoutPlan workoutPlan) {
        return workoutPlanRepository.save(workoutPlan);
    }
}
