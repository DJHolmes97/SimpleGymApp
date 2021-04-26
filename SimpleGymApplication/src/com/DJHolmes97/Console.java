package com.DJHolmes97;

import java.util.LinkedList;
import java.util.Scanner;

public class Console {
    private int mainMenuSelection;
    private Scanner scanner;
    private LinkedList<Workout> workouts;

    public Console() {
        //Value used to track input from console
        mainMenuSelection = 0;
        //This reads in input, it can easily broken and needs updated error detection
        scanner = new Scanner(System.in);
        //This is the list of workouts
        workouts = new LinkedList<>() {
        };
    }


    public void MainMenu(){

        //So that the scanner doesn't skip on spaces
        scanner.useDelimiter("\n");

        //The main menu
        while(mainMenuSelection != 4){

            //Initialisation
            mainMenuSelection = 0;

            //Menu for user to see
            System.out.println("| Workout Application      |");
            System.out.println("| Options:                 |");
            System.out.println("|      1. Create Workout   |");
            System.out.println("|      2. View Workout     |");
            System.out.println("|      3. Delete Workout   |");
            System.out.println("|      4. Quit             |");

            //Menu User Input
            mainMenuSelection = scanner.nextInt();

            switch (mainMenuSelection){
                case 1:
                    //The user has selected creating a new workout
                    System.out.println("Create new workout.");
                    CreateWorkout();
                    mainMenuSelection = 0;
                    break;
                case 2:
                    //The user has selected to view current workouts
                    System.out.println("View Workout.");
                    ViewWorkout();
                    mainMenuSelection = 0;
                    break;
                case 3:
                    //The user has selected to delete a workout
                    System.out.println("Delete Workout.");
                    DeleteWorkout();
                    mainMenuSelection = 0;
                    break;
                case 4:
                    //The user has decided to quit the application
                    System.out.println("Quitting Application.");
                    break;
            }
        }
    }


    private void CreateWorkout() {
        //Template workout is created to be stored in list
        Workout newWorkout = new Workout();

        //Workout needs to be named so it can be differentiated
        System.out.println("Name the workout: ");
        newWorkout.setName(scanner.next());
        //Workout creation sub-menu display
        while(mainMenuSelection != 3){
            mainMenuSelection = 0;
            System.out.println("| Workout Creator               |");
            System.out.println("| Options:                      |");
            System.out.println("|      1. Add Exercise          |");
            System.out.println("|      2. Save Workout          |");
            System.out.println("|      3. Quit (without saving) |");
            mainMenuSelection = scanner.nextInt();

            //Workout creation sub-menu input
            switch (mainMenuSelection){
                case 1:
                    //User has chosen to add Exercise
                    System.out.println("Add Exercise");
                    Exercise ex = new Exercise();

                    System.out.println("Type exercise name: ");
                    ex.setName(scanner.next());

                    System.out.println("Type exercise sets: ");
                    ex.setSets(scanner.nextInt());

                    System.out.println("Type exercise reps: ");
                    ex.setReps(scanner.nextInt());

                    newWorkout.addExercise(ex);
                    mainMenuSelection = 0;
                    break;
                case 2:
                    //User has chose to save the current workout
                    System.out.println("Save Workout");
                    workouts.add(newWorkout);
                    mainMenuSelection = 3;
                    break;
                case 3:
                    //USer has chose to quit without saving workout
                    System.out.println("Quitting Workout Creator.");
                    break;
            }
        }

    }
    private void ViewWorkout() {
        //Temp workout obj
        Workout vWorkout;
        //Check if list is empty for error avoiding
        if(workouts.isEmpty()){
            //Inform user of empty list
            System.out.println("No workouts to view.");
        } else {
            //Show user workout list so they can choose
            System.out.println("Below is a list of your workouts.");
            for (Workout w: workouts) {
                System.out.println(workouts.indexOf(w) + ". Workout name: " + w.getName());
            }
            System.out.println();

            //Get user to choose workout to be viewed
            System.out.println("Type index of workout to be viewed: ");
            vWorkout = workouts.get(scanner.nextInt());

            //Display workout
            System.out.println("Workout name: " + vWorkout.getName());
            for (Exercise e: vWorkout.getWorkout()) {
                System.out.println("Exercise name: " + e.getName());
                System.out.println("Sets: " + e.getSets());
                System.out.println("Reps: " + e.getReps());
            }
        }
    }
    private void DeleteWorkout() {
        //temp workout obj
        Workout dWorkout;

        //Check that list isn't empty
        if(workouts.isEmpty()){
            //Skip deletion if it is
            System.out.println("No workouts created.");
        } else {
            //Show list so user can choose
            System.out.println("Below is a list of your workouts.");
            for (Workout w: workouts) {
                System.out.println(workouts.indexOf(w) + ". Workout name: " + w.getName());
            }
            System.out.println();

            //Have user choose workout to be deleted
            System.out.println("Type index of workout to be deleted: ");
            dWorkout = workouts.get(scanner.nextInt());
            System.out.println(dWorkout.getName() + " has been deleted.");
            workouts.remove(dWorkout);
        }
    }
}
