package com.lyn.myfactory;


import java.time.LocalTime;
import java.time.ZonedDateTime;

/**
 * Created by smlz on 2019/12/16.
 */
public class TulingTimeBetweenConfig {

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

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now());
    }

}
