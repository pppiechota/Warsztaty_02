package com.piotrpiechota.Access;

import com.piotrpiechota.Dao.ExerciseDao;
import com.piotrpiechota.Dao.SolutionDao;
import com.piotrpiechota.Dao.UserDao;
import com.piotrpiechota.Exercise;
import com.piotrpiechota.InputUtils;
import com.piotrpiechota.Solution;
import com.piotrpiechota.User;

import java.util.Date;

public class AccessSolution extends Processor {

    UserDao userDao;
    ExerciseDao exerciseDao;
    SolutionDao solutionDao;

    public AccessSolution() {
        this.userDao = new UserDao();
        this.exerciseDao = new ExerciseDao();
        this.solutionDao = new SolutionDao();
    }

    @Override
    public void run() {
        boolean quit = false;
        while (!quit) {
            System.out.print("Wybierz jedną z opcji:\n" +
                    "1. ADD - przypisz zadanie do użytkownika\n" +
                    "2. VIEW - zobacz rozwiązania użytkownika\n" +
                    "3. QUIT - zakończenie programu\n");
            int choice = InputUtils.getNumber();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    showAllByUser();
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

    protected void add() {
        User[] users = userDao.findAll();
        System.out.println("Wszyscy użytkownicy:");
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("Podaj ID użytkownika:");
        int userId = InputUtils.getNumber();

        Exercise[] exercises = exerciseDao.findAll();
        System.out.println("Wszystkie zadania:");
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }

        System.out.println("Podaj ID zadania:");
        int exerciseId = InputUtils.getNumber();

        Solution solution = new Solution(new Date(), null, "", userId, exerciseId);
        solutionDao.create(solution);
    }

    protected void showAllByUser() {
        System.out.println("Podaj ID użytkownika, którego zadania chcesz zobaczyć:");
        int userId = InputUtils.getNumber();

        Solution[] solutions = solutionDao.findAllByUserId(userId);

        System.out.println("Wszystkie rozwiązania użytkownika " + userId + ":");
        for (Solution solution : solutions) {
            System.out.println(solution);
        }
    }
}
