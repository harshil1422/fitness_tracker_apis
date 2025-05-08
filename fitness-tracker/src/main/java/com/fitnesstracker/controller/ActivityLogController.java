package com.fitnesstracker.controller;

import com.fitnesstracker.dto.ActivityLogDTO;
import com.fitnesstracker.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService activityLogService;

    @PostMapping
    public ResponseEntity<ActivityLogDTO> createActivityLog(@Valid @RequestBody ActivityLogDTO activityLogDTO) {
        ActivityLogDTO created = activityLogService.createActivityLog(activityLogDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
