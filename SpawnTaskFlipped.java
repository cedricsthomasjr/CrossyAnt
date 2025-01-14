/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import basicgraphics.SpriteComponent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author cjthomas
 *
 */
public class SpawnTaskFlipped extends TimerTask {
    // spawn task for enemy2
    static Random rand = new Random();
    static String[] enemyImage = {"graycar.png", "tealcar.png", "redcar2.png", "purplecar1.png","whitecar.png"};

    public static int[] spawn = {703, 571, 299, 165};
    public static Enemy2[] EnemiesSpawnable2 = new Enemy2[16];
    public static Timer timer = new Timer();

    public SpawnTaskFlipped(SpriteComponent sc) throws InterruptedException {

        for (int t = 0; t <= 15; t++) {
            String d = enemyImage[t % 4];

            if (d.equals("graycar.png")) {
                EnemiesSpawnable2[t] = new Enemy2(sc, 0, spawn[(t % 4)] +10, d);
            }
            if (!d.equals("graycar.png")) {
                EnemiesSpawnable2[t] = new Enemy2(sc, 0, spawn[(t % 4)], d);
            }
            
            if (t == 15) {
                CrossyAntGame.mixedList.add(EnemiesSpawnable2);
            }
            Thread.sleep(100);
        }
    }

    @Override
    public void run() {

    }

}
