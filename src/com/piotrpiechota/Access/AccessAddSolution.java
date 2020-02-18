package com.piotrpiechota.Access;

import com.piotrpiechota.Dao.ExerciseDao;
import com.piotrpiechota.Dao.SolutionDao;
import com.piotrpiechota.Dao.UserDao;
import com.piotrpiechota.Exercise;
import com.piotrpiechota.InputUtils;
import com.piotrpiechota.Solution;
import com.piotrpiechota.User;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class AccessAddSolution extends Processor{

    private int userId;
    private UserDao userDao;
    private SolutionDao solutionDao;
    private ExerciseDao exerciseDao;

    public AccessAddSolution(int userId) {
        this.userId = userId;
        this.userDao = new UserDao();
        this.solutionDao = new SolutionDao();
        this.exerciseDao = new ExerciseDao();
    }

    @Override
    public void run() {
        User user = userDao.read(userId);
        System.out.println("Rozwiązania użytkownika: " + user);
        boolean quit = false;

        while (!quit) {
            System.out.print("Wybierz jedną z opcji:\n" +
                    "1. ADD - dodaj rozwiązanie\n" +
                    "2. VIEW - zobacz swoje rozwiązania\n" +
                    "3. QUIT - zakończenie programu\n");
            int choice = InputUtils.getNumber();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
            }
        }
    }

    private void add() {

        Solution[] allUserSolutions = solutionDao.findAllByUserId(userId);
        Exercise[] unresolvedExercises = getUnresolvedExercises(allUserSolutions);
        show(unresolvedExercises);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID zadania, które chcesz rozwiązać:");
        int exerciseId = InputUtils.getNumber();
        if(canExerciseBeResolved(exerciseId, unresolvedExercises)) {

            System.out.println("Podaj rozwiązanie zadania:");
            String description = scanner.nextLine();

            for (Solution userSolution : allUserSolutions) {
                if (userSolution.getExerciseId() == exerciseId) {
                    userSolution.setUpdated(new Date()); //current date
                    userSolution.setDescription(description);

                    solutionDao.update(userSolution);
                }
            }

        } else {
            System.out.println("Nie mozna zapisać rozwiązania dla zadania o id: " + exerciseId);
        }
    }

    private Exercise[] getUnresolvedExercises(Solution[] allUserSolutions) {

        Exercise[] unresolved = new Exercise[0];

        for (Solution solution : allUserSolutions) {
            if (isDescriptionEmpty(solution)) {

                Exercise exercise = exerciseDao.read(solution.getExerciseId());
                Exercise[] tmpExercises = Arrays.copyOf(unresolved, unresolved.length + 1);
                tmpExercises[unresolved.length] = exercise;
                unresolved = tmpExercises;
            }
        }

        return unresolved;
    }

    private void show(Exercise[] unresolvedExercises) {

        System.out.println("Użytkownika o id: " + userId + " nie rozwiązał następujących zadań:");
        for (Exercise unresolvedExercise : unresolvedExercises) {
            System.out.println(unresolvedExercise);
        }
    }

    private boolean canExerciseBeResolved(int exerciseId, Exercise[] unresolvedExercises) {
        for (Exercise unresolvedExercise : unresolvedExercises) {
            if(unresolvedExercise.getId() == exerciseId) {
                return true;
            }
        }

        return false;
    }

    private boolean isDescriptionEmpty(Solution userSolutions) {
        return userSolutions.getDescription() == null || userSolutions.getDescription().isBlank();
    }

    private void view() {
        Solution[] allUserSolutions = solutionDao.findAllByUserId(userId);
        System.out.println("Rozwiazania użytkownika:");
        for (Solution solution : allUserSolutions) {
            System.out.println(solution);
        }
    }
}
