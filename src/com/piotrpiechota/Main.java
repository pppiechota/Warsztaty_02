package com.piotrpiechota;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        User newUser = new User("test","test@tset","test123");

//        User createdUser = userDao.create(newUser);
//
//        System.out.println(createdUser.toString());

        User readUser = userDao.read(100);
        System.out.println("Read user: "+readUser);
        System.out.println("-------");
        User userBeforeUpdate = userDao.read(2);
        System.out.println("User before update: "+userBeforeUpdate);


        User userToUpdate = new User("abc","test@best.pl","abc");
        userToUpdate.setId(2);

        userDao.update(userToUpdate);

        User userAfterUpdate = userDao.read(2);
        System.out.println("User after update: "+userAfterUpdate);
    }
}
