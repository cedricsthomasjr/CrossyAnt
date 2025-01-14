/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import static CrossyAntGame.CrossyAntGame.SCORE;
import static CrossyAntGame.CrossyAntGame.highScore;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author cjthomas
 */
public class PowerUp extends Sprite {
    // powerup constructor
    public static int time = 2000;
    Random rand = new Random();
    public Picture initialPic;
    private static Timer effectTimer;
    public static boolean effectActive;
    public static int intialspeed = SpeedManager.loadSpeed();

    public PowerUp(SpriteComponent sc) {
        super(sc);
        initialPic = new Picture("speedpowerup.png");
        setPicture(initialPic);
        double speed = rand.nextDouble(2, 3);
        setVel(0, speed);
        setX(rand.nextInt(470, 910));
        setY(0);

    }
    // powerup logic
    public static void activateEffect() {

        effectTimer = new Timer();
        effectTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                deactivateEffect();
            }
        }, time);
        effectActive = true;
        CrossyAntGame.speed += CrossyAntGame.speed * .5;

    }

    private static void deactivateEffect() {
        effectTimer.cancel();
        effectActive = false;
        if (MainChar.immune) {
            Picture p2 = new Picture("shieldedant.png");
            CrossyAntGame.you.setPicture(p2);
        } else {
            Picture p2 = new Picture("ant-small.png");
            CrossyAntGame.you.setPicture(p2);

        }
        CrossyAntGame.speed = intialspeed;
    }

    public static boolean isEffectActive() {
        return effectActive;
    }

    @Override
    public void processEvent(SpriteCollisionEvent se) {
        if (se.yhi) {
            setActive(false);
        }

    }

}
