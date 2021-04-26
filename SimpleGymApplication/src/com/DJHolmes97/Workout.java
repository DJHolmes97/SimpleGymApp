package com.DJHolmes97;

import java.util.LinkedList;


public class Workout {
    private LinkedList<Exercise> workout;
    private String name;

    public Workout() {
        workout = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addExercise(Exercise exercise){
        workout.add(exercise);
    }

    public LinkedList<Exercise> getWorkout() {
        return workout;
    }
}
