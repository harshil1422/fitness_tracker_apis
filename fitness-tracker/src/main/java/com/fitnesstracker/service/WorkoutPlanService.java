package com.fitnesstracker.service;

import com.fitnesstracker.dao.WorkoutPlanDAO;
import com.fitnesstracker.dto.WorkoutPlanDTO;
import com.fitnesstracker.model.WorkoutPlan;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutPlanService {

    @Autowired
    private WorkoutPlanDAO workoutPlanDAO;

    @Autowired
    private ModelMapper modelMapper;

    public WorkoutPlanDTO createWorkoutPlan(WorkoutPlanDTO workoutPlanDTO) {
        WorkoutPlan workoutPlan = modelMapper.map(workoutPlanDTO, WorkoutPlan.class);
        workoutPlan = workoutPlanDAO.save(workoutPlan);
        return modelMapper.map(workoutPlan, WorkoutPlanDTO.class);
    }
}
