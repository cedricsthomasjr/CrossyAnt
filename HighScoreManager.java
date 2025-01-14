/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author cjthomas
 */
public class HighScoreManager {

    private static final String HIGH_SCORE_FILE = "highscore.txt";
// readers and writers for your high score 
    public static void saveHighScore(int highScore) {
        try {
            FileWriter writer = new FileWriter(HIGH_SCORE_FILE);
            writer.write(String.valueOf(highScore));
            writer.close();
        } catch (IOException e) {
        }
    }

    public static int loadHighScore() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(HIGH_SCORE_FILE));
            String highScoreString = reader.readLine();
            reader.close();
            return Integer.parseInt(highScoreString);
        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }
}
