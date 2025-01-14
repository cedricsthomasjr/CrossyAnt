/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import basicgraphics.SpriteComponent;
import java.util.TimerTask;

/**
 *
 * @author cjthomas
 *
 */
public class SpawnTask extends TimerTask {
    // Spawn taks for enemy1
    static int[] spawn = {676, 542, 274, 140};
    public static Enemy1[] EnemiesSpawnable1 = new Enemy1[16];
    static String[] enemyImage = {"graycar.png", "tealcar.png", "redcar2.png", "purplecar1.png"};
   

    public SpawnTask(SpriteComponent sc) throws InterruptedException {

        for (int t = 0; t <= 15; t++) {
            String d = enemyImage[t % 3];
            if (d.equals("bus1.png")) {
                EnemiesSpawnable1[t] = new Enemy1(sc, 0, spawn[(t % 4)] - 5, d);
            }
            if (!d.equals("bus1.png")) {
                EnemiesSpawnable1[t] = new Enemy1(sc, 0, spawn[(t % 4)], d);
            }
            if (t == 15) {
                CrossyAntGame.mixedList.add(EnemiesSpawnable1);
            }
            Thread.sleep(100);  

        }
    }

    @Override
    public void run() {

    }

    public static Enemy1[] clear() {
        EnemiesSpawnable1 = new Enemy1[16];
        return EnemiesSpawnable1;
    }

}
