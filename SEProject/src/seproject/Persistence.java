/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seproject;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Daniel Servejeira
 */
public class Persistence {
    private static final String FILE_NAME = "people.dat";

    public static void savePeople(ArrayList<Person> people) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(people);
            System.out.println("People list saved.");
        } catch (IOException e) {
            System.err.println("Error saving people: " + e.getMessage());
        }
    }

    public static ArrayList<Person> loadPeople() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("People list loaded.");
            return (ArrayList<Person>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading people: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
