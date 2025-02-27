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

    private static final String BASE_PATH = "src/seproject/database/";

    public static <T extends Serializable> void saveArchive(T object, String fileName) {
        File dir = new File(BASE_PATH);
        if (!dir.exists()) dir.mkdirs();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BASE_PATH + fileName))) {
            oos.writeObject(object);
        } catch (IOException e) {
            System.err.println("Error saving: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T loadArchive(String fileName, T defaultValue) {
        File file = new File(BASE_PATH + fileName);
        if (!file.exists()) return defaultValue;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading: " + e.getMessage());
            return defaultValue;
        }
    }
}
