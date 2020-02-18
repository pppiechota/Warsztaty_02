package com.piotrpiechota.Access;

import com.piotrpiechota.Dao.GroupDao;
import com.piotrpiechota.Group;
import com.piotrpiechota.InputUtils;

import java.util.Scanner;

public class AccessGroup extends DataProcessor {

    GroupDao groupDao;

    public AccessGroup() {
        this.groupDao = new GroupDao();
    }

    @Override
    protected void showAll() {
        Group[] groups = groupDao.findAll();

        System.out.println("Wszystkie grupy:");
        for (Group group : groups) {
            System.out.println(group);
        }
    }

    @Override
    protected void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę grupy:");
        String name = scanner.nextLine();
        Group group = new Group(name);

        groupDao.create(group);
    }

    @Override
    protected void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID grupy do edycji:");
        int editId = InputUtils.getNumber();
        System.out.println("Podaj zmienioną nazwę grupy:");
        String name = scanner.nextLine();

        Group group = new Group(name);
        group.setId(editId);
        groupDao.update(group);
    }

    @Override
    protected void delete() {
        System.out.println("Podaj ID grupy do usunięcia:");
        int groupId = InputUtils.getNumber();
        groupDao.delete(groupId);
    }
}
