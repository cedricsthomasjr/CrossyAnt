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
public class TimeManager {
    public static final String FILE_PATH = "time.txt";

    public static void saveTime(int time) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(Integer.toString(time));
        } catch (IOException e) {
            System.out.println("filenotfound t");
        }
    }

    public static int loadTime() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            if (line != null) {
                PowerUp.time = Integer.parseInt(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("filenotfound t");
        }
        return PowerUp.time;
    }
    public static void resetFile()
    {
       saveTime(2000);
    }
    
}
