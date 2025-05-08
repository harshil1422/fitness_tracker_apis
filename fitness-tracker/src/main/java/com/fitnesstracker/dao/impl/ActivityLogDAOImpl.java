package com.fitnesstracker.dao.impl;

import com.fitnesstracker.dao.ActivityLogDAO;
import com.fitnesstracker.model.ActivityLog;
import com.fitnesstracker.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityLogDAOImpl implements ActivityLogDAO {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Override
    public ActivityLog save(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }
}
