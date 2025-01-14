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
 */
public class SpawnTaskBuff extends TimerTask {
// spawntask for buffs
    static PowerUp[] p = new PowerUp[999];

    public SpawnTaskBuff(SpriteComponent sc) throws InterruptedException {
        for (int t = 0; t < p.length; t++) {
            SpawnTaskBuff.p[t] = new PowerUp(sc);
            
            Thread.sleep(7000);
            if (t == 15) {
                CrossyAntGame.mixedList.add(p);
            }
        }
    }

    @Override
    public void run() {
    }

   
}
