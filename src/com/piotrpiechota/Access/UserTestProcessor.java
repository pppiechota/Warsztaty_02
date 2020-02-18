package com.piotrpiechota.Access;

import com.piotrpiechota.Dao.UserDao;
import com.piotrpiechota.User;

public class UserTestProcessor extends Processor {

    @Override
    public void run() {
        UserDao userDao = new UserDao();

        User newUser = new User("test", "test@test.com", "test123",1);
        User createdUser = userDao.create(newUser);

        System.out.println("Create user: " + createdUser);


        User readUser = userDao.read(100);
        System.out.println("Read user: " + readUser);

        System.out.println("--------------------");
        User userBeforeUpdate = userDao.read(2);
        System.out.println("User before update: " + userBeforeUpdate);

        User userToUpdate = new User("abc", "def@test.com", "abc12345",1);
        userToUpdate.setId(2);

        userDao.update(userToUpdate);

        User userAfterUpdate = userDao.read(2);
        System.out.println("User after update: " + userAfterUpdate);


        System.out.println("--------------------");
        User userBeforeDelete = userDao.read(5);
        System.out.println("User before delete: " + userBeforeDelete);

        userDao.delete(5);

        User userAfterDelete = userDao.read(5);
        System.out.println("User after delete: " + userAfterDelete);

        System.out.println("--------------------");
        User[] allUsers = userDao.findAll();
        System.out.println("All users:");
        for (User user : allUsers) {
            System.out.println(user);
        }
    }
}