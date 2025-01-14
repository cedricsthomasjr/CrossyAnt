/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import static CrossyAntGame.CoinManager.getCoinCount;

/**
 *
 * @author cjthomas
 */
public class LoadAll {
    
    public static void loadAll() {
        //loads all of the saveable attributes in the game
        int d = CoinManager.loadCoinCount();
        System.out.println(getCoinCount() + "coins");

        CrossyAntGame.highScore = HighScoreManager.loadHighScore();
        System.out.println(HighScoreManager.loadHighScore() + "high score");

        SpeedManager.loadSpeed();
        System.out.println(CrossyAntGame.speed + "speed");

        TimeManager.loadTime();
        System.out.println(PowerUp.time + "time");

        MultManager.loadMult();
        System.out.println(MainChar.multiplier + "mult");
        

    }

}
