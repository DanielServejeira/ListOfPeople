/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seproject.persistence;

import java.io.*;

/**
 *
 * @author Daniel Servejeira
 */
public class Persistence {

    public static <T extends Serializable> void saveArchive(T object, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
        } catch (IOException e) {
            System.err.println("Error saving: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T loadArchive(String fileName, T defaultValue) {
        File file = new File(fileName);
        if (!file.exists()) return defaultValue;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading: " + e.getMessage());
            return defaultValue;
        }
    }
}
