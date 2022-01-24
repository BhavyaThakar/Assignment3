package com.example.assignment3;

import java.io.Serializable;

public class Time implements Serializable {
    String time;

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Time(String time) {
        this.time = time;
    }
}