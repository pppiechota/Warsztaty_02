package com.piotrpiechota.Access;

import com.piotrpiechota.Dao.UserDao;
import com.piotrpiechota.InputUtils;
import com.piotrpiechota.User;

import java.util.Scanner;

public class AccessUser extends DataProcessor {

    UserDao userDao;

    public AccessUser() {
        this.userDao = new UserDao();
    }

    @Override
    protected void showAll() {
        User[] users = userDao.findAll();

        System.out.println("Wszyscy użytkownicy:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Override
    protected void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę użytkownika:");
        String username = scanner.nextLine();
        System.out.println("Podaj email użytkownika:");
        String email = scanner.nextLine();
        System.out.println("Podaj hasło:");
        String pass = scanner.nextLine();
        System.out.println("Podaj grupę do której należy użytkownik:");
        int groupId = InputUtils.getNumber();
        User user = new User(username, email, pass, groupId);

        userDao.create(user);
    }

    @Override
    protected void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID użytkownika do edycji:");
        int editId = InputUtils.getNumber();
        System.out.println("Podaj nazwę użytkownika:");
        String username = scanner.nextLine();
        System.out.println("Podaj email użytkownika:");
        String email = scanner.nextLine();
        System.out.println("Podaj hasło:");
        String pass = scanner.nextLine();
        System.out.println("Podaj grupę do której należy użytkownik:");
        int groupId = InputUtils.getNumber();

        User user = new User(username, email, pass, groupId);
        user.setId(editId);

        userDao.update(user);
    }

    @Override
    protected void delete() {
        System.out.println("Podaj ID użytkownika do usunięcia:");
        int userId = InputUtils.getNumber();
        userDao.delete(userId);
    }
}
