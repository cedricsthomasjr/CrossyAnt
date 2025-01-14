/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author cjthomas
 */
public class MultManager {
public static final String FILE_PATH = "multiplier.txt";
    // saves and loads your score mulitplier
    public static void saveMult(int multiplier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(Integer.toString(multiplier));
        } catch (IOException e) {
            System.out.println("filenotfound m");
        }
    }

    public static Integer loadMult() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            if (line != null) {
                MainChar.multiplier = Integer.parseInt(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("filenotfound m");
        }
        return MainChar.multiplier;
        
    }    
    public static void resetFile()
    {
       saveMult(1);
    }
}
