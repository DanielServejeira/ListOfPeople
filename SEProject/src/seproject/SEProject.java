/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package seproject;
import java.io.IOException;
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
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Person> people = new ArrayList<>();
        
        byte menuOption = -1, totalMenuOptions = 4;
        char confirmation = '0';
        
        String name, birthday, cpf, fathersName, mothersName;
        Boolean gender;
        int totalPeople = 0;
        
        while(menuOption != EXITOPTION) {
            while(menuOption < EXITOPTION || menuOption > totalMenuOptions) {
                System.out.println("-=-=-=-=-=-MENU-=-=-=-=-=-");
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
                System.out.println("Are you sure? (Y/N)");
                try {
                    confirmation = (char) System.in.read();
                }
                catch (IOException error) {
                    error.printStackTrace();
                }
                
                if(confirmation == 'y' || confirmation == 'n') {
                    confirmation = Character.toUpperCase(confirmation);
                }
            }
            
            switch (menuOption) {
                case 0 ->
                case 1 ->
                case 2 ->
                case 3 ->
                case 4 ->
            }
        }
        scanner.close();
    }
}
