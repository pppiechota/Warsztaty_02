package com.piotrpiechota.Access;

import java.util.Scanner;

public class DataProcessor extends Processor{

    public void run(){
        boolean quit = false;

        while (!quit) {

            showAll();

            System.out.print("Wybierz jedną z opcji [1-4]:\n" +
                    "1. ADD - dodaj\n" +
                    "2. EDIT - edytuj\n" +
                    "3. DELETE - usuń\n" +
                    "4. QUIT - zakończenie programu\n");

            int choice = getOperation();

            switch (choice) {
                case 1:
                    add();
                    System.out.println("Dodaję użytkownika...");
                    break;
                case 2:
                    edit();
                    System.out.println("Zmiany zostały wprowadzone");
                    break;
                case 3:
                    delete();
                    System.out.println("Usuwam użytkownika...");
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
            }
        }
    }

    private int getOperation(){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

    protected void showAll(){
        System.out.println("Nie zaimplementowano metody!");
    }

    protected void add(){
        System.out.println("Nie zaimplementowano metody!");
    }

    protected void edit(){
        System.out.println("Nie zaimplementowano metody!");
    }

    protected void delete(){
        System.out.println("Nie zaimplementowano metody!");
    }

}
