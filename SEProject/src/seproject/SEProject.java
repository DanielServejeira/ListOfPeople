/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package seproject;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Daniel Servejeira
 */
public class SEProject {
    static final byte EXITOPTION = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList <Person> people = Persistence.loadPeople();

            byte menuOption = -1, totalMenuOptions = 4;
            char confirmation = '0';

            while(menuOption != EXITOPTION || confirmation == 'N') {
                menuOption = -1;
                confirmation = '0';

                while(menuOption < EXITOPTION || menuOption > totalMenuOptions) {
                    System.out.println("\n-=-=-=-=-=-MENU-=-=-=-=-=-");
                    System.out.println("[1] <- Add a person's data to the list");
                    System.out.println("[2] <- Remove a person's data from the list");
                    System.out.println("[3] <- Modify a person's data in the list");
                    System.out.println("[4] <- View a person's data in the list");
                    System.out.println("[0] <- Exit");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
                    System.out.print("Choose an option: ");
                    menuOption = scanner.nextByte();

                    System.out.println("");
                }


                while(confirmation != 'Y' && confirmation != 'N') {
                    System.out.println("Are you sure? (Y/N) ");
                    confirmation = scanner.next().toUpperCase().charAt(0);
                    scanner.nextLine();
                }

                if(confirmation == 'Y') {
                    System.out.println("");

                    switch (menuOption) {
                        case 0 -> System.out.println("Software by Daniel Servejeira\n");
                        case 1 -> addPerson(scanner, people);
                        case 2 -> removePerson(scanner, people);
                        case 3 -> modifyPerson(scanner, people);
                        case 4 -> viewPeople(scanner, people);
                    }
                }
            }
        }
    }
    
    private static void addPerson(Scanner scanner, ArrayList<Person> people) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter birthday (MM/DD/YYYY): ");
        String birthday = scanner.nextLine();
        System.out.print("Enter gender (M/F): ");
        char genderChar = scanner.next().charAt(0);
        boolean gender = (Character.toUpperCase(genderChar) == 'M');
        scanner.nextLine();
        System.out.print("Enter CPF: ");
        String cpf = scanner.nextLine();
        
        people.add(new Person(name, birthday, gender, cpf));
        savePeople(people);
        
        System.out.println("Person added successfully!");
        System.out.print("Insert a character to continue. ");
        scanner.nextLine();
    }

    private static void removePerson(Scanner scanner, ArrayList<Person> people) {
        if (people.isEmpty()) {
            System.out.println("There is no people in the list.");
            System.out.print("Insert a character to continue. ");
            scanner.nextLine();
            return;
        }
        
        System.out.println("People in the list:");
        for (int i = 0; i < people.size(); i++) {
            System.out.println("[" + i + "] " + people.get(i).getName());
        }
        
        System.out.print("Enter the index of the person to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        
        if (index >= 0 && index < people.size()) {
            people.remove(index);
            savePeople(people);
            
            System.out.println("\nPerson removed successfully!");
        }
        else {
            System.out.println("Invalid index.\n");
        }
        
        System.out.print("Insert a character to continue. ");
        scanner.nextLine();
    }

    private static void modifyPerson(Scanner scanner, ArrayList<Person> people) {
        if (people.isEmpty()) {
            System.out.println("There is no people in the list.");
            System.out.print("Insert a character to continue. ");
            scanner.nextLine();
            return;
        }
        
        System.out.println("People in the list:");
        for (int i = 0; i < people.size(); i++) {
            System.out.println("[" + i + "] " + people.get(i).getName());
        }
        
        System.out.print("\nEnter the index of the person to modify: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        
        if (index >= 0 && index < people.size()) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new birthday (MM/DD/YYYY): ");
            String birthday = scanner.nextLine();
            System.out.print("Enter new gender (M/F): ");
            char genderChar = scanner.next().charAt(0);
            boolean gender = (Character.toUpperCase(genderChar) == 'M');
            scanner.nextLine();
            System.out.print("Enter new CPF: ");
            String cpf = scanner.nextLine();
            
            people.set(index, new Person(name, birthday, gender, cpf));
            savePeople(people);
            
            System.out.println("\nPerson modified successfully!");
        }
        else {
            System.out.println("Invalid index.");
        }
        
        System.out.print("Insert a character to continue. ");
        scanner.nextLine();
    }

    private static void viewPeople(Scanner scanner, ArrayList<Person> people) {
        if (people.isEmpty()) {
            System.out.println("There is no people in the list.");
            System.out.print("Insert a character to continue. ");
            scanner.nextLine();
            return;
        }

        System.out.println("People in the list:");
        for (int i = 0; i < people.size(); i++) {
            System.out.println("[" + i + "] " + people.get(i).getName());
        }
        
        System.out.print("Insert a character to continue. ");
        scanner.nextLine();
    }
    
    private static void savePeople(ArrayList<Person> people) {
        Persistence.savePeople(people);
    }
}
