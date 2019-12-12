package com.piotrpiechota;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        User newUser = new User("test","test@tset","test123");

        Date date = new Date();

        SolutionDao solDao = new SolutionDao();
        Solution sol = new Solution("Bardzo ciekawe rozwiązanie");

        Solution created = solDao.create(sol);
        System.out.println(created.toString());

//        User readUser = userDao.read(100);
//        System.out.println("Read user: "+readUser);
//        System.out.println("-------");
//        User userBeforeUpdate = userDao.read(2);
//        System.out.println("User before update: "+userBeforeUpdate);
//
//
//        User userToUpdate = new User("abc","test@best.pl","abc");
//        userToUpdate.setId(2);
//
//        userDao.update(userToUpdate);
//
//        User userAfterUpdate = userDao.read(2);
//        System.out.println("User after update: "+userAfterUpdate);
//
//
//        System.out.println("--------------------");
//        User userBeforeDelete = userDao.read(3);
//        System.out.println("User before delete: "+userBeforeDelete);
//
//        userDao.delete(3);
//        User userAfterDelete = userDao.read(3);
//        System.out.println("User after delete: "+userAfterDelete);
//
//        User[] allUsers = userDao.findAll();
//        System.out.println("All users:");
//        for(User user : allUsers){
//            System.out.println(user.toString());
//        }

    }
}
