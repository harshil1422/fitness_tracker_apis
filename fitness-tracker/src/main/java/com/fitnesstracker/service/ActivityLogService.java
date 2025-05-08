package com.fitnesstracker.service;

import com.fitnesstracker.dao.ActivityLogDAO;
import com.fitnesstracker.dto.ActivityLogDTO;
import com.fitnesstracker.model.ActivityLog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogService {

    @Autowired
    private ActivityLogDAO activityLogDAO;

    @Autowired
    private ModelMapper modelMapper;

    public ActivityLogDTO createActivityLog(ActivityLogDTO activityLogDTO) {
        ActivityLog activityLog = modelMapper.map(activityLogDTO, ActivityLog.class);
        activityLog = activityLogDAO.save(activityLog);
        return modelMapper.map(activityLog, ActivityLogDTO.class);
    }
}
