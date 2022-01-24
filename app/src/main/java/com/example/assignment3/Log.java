package com.example.assignment3;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Log implements Serializable {
    String act;

    @Override
    public String toString() {
        return act;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }


    public Log(String act) {
        this.act = act;
    }


}