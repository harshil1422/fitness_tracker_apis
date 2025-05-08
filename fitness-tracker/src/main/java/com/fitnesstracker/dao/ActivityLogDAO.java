package com.fitnesstracker.dao;


import com.fitnesstracker.model.ActivityLog;

public interface ActivityLogDAO {
    ActivityLog save(ActivityLog activityLog);
}