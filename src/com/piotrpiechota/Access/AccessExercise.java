package com.piotrpiechota.Access;

import com.piotrpiechota.Dao.ExerciseDao;
import com.piotrpiechota.Dao.GroupDao;
import com.piotrpiechota.Exercise;
import com.piotrpiechota.Group;
import com.piotrpiechota.InputUtils;

import java.util.Scanner;

public class AccessExercise extends DataProcessor{

    ExerciseDao exerciseDao;

    public AccessExercise() {
        this.exerciseDao = new ExerciseDao();
    }

    @Override
    protected void showAll() {
        Exercise[] exercises = exerciseDao.findAll();

        System.out.println("Wszystkie zadania:");
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }
    }

    @Override
    protected void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł zadania:");
        String title = scanner.nextLine();
        System.out.println("Podaj treść zadania:");
        String description = scanner.nextLine();
        Exercise exercise = new Exercise(title,description);

        exerciseDao.create(exercise);
    }

    @Override
    protected void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID zadania do edycji:");
        int editId = InputUtils.getNumber();
        System.out.println("Podaj tytuł zadania:");
        String title = scanner.nextLine();
        System.out.println("Podaj treść zadania:");
        String description = scanner.nextLine();

        Exercise exercise = new Exercise(title,description);
        exercise.setId(editId);
        exerciseDao.update(exercise);
    }

    @Override
    protected void delete() {
        System.out.println("Podaj ID zadania do usunięcia:");
        int exerciseId = InputUtils.getNumber();
        exerciseDao.delete(exerciseId);
    }
}
