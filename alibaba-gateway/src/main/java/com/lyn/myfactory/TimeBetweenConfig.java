package com.lyn.myfactory;

import java.time.LocalTime;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-10 14:06
 **/
public class TimeBetweenConfig {
    private LocalTime startTime;
    private LocalTime endTime;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
