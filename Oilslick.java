/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Dimension;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author cjthomas
 */
public class Oilslick extends Sprite {
    // debuff constructor and logic
    private static Timer effectTimer;
    private static boolean effectActive;
    public Picture p = new Picture("oilslick.png");

    public Oilslick(SpriteComponent sc) {
        super(sc);
        setPicture(p);
        Dimension d = sc.getSize();
        Random rand = new Random();
        int z = rand.nextInt(1, 2);
        int x = 0;
        if (z == 1) {
            x = rand.nextInt(700, 800);
        }
        if (z == 2) {
            x = rand.nextInt(200, 500);
        }

        int y = rand.nextInt(0, d.height - 300);
        setX(x);
        setY(y);

    }

    public static void activateEffect() {
        CrossyAntGame.speed /= 2;
        effectTimer = new Timer();
        effectTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                deactivateEffect();
            }
        }, 1000);

    }

    private static void deactivateEffect() {
        CrossyAntGame.speed = SpeedManager.loadSpeed();
        effectTimer.cancel();
    }

    public static boolean isEffectActive() {
        return effectActive;
    }

}
