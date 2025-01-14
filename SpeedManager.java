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
public class SpeedManager {
    
    //file writer and reader for speed
    private static final String FILE_PATH = "speed.txt";

    public static void saveSpeed(int speed) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(Integer.toString(speed));
        } catch (IOException e) {
            System.out.println("Speed file not found");
        }
    }

    public static int loadSpeed() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            if (line != null) {
                CrossyAntGame.speed = Integer.parseInt(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Speed file not found");
        }
        return CrossyAntGame.speed;
    }
    public static void resetFile()
    {
       saveSpeed(2);
    }
        
        
}
