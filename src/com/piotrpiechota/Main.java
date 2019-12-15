package com.piotrpiechota;

import com.piotrpiechota.Dao.SolutionDao;
import com.piotrpiechota.Dao.UserDao;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        User newUser = new User("test","test@tset","test123",2);

        SolutionDao solutionDao = new SolutionDao();


        User[] tmpU = userDao.findAllByGroupId(1);
        for (User user : tmpU) {
            System.out.println(user);
        }

    }
}
