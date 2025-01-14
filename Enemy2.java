/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.SpriteSpriteCollisionListener;
import basicgraphics.images.Picture;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cjthomas
 */
public class Enemy2 extends Sprite {
    Dimension d = CrossyAntGame.sc.getSize();
    public Picture initialPic4;
    Random rand = new Random();
    // constructor for enemy 2
    public Enemy2(SpriteComponent sc, int x, int y, String imagename) {
        super(sc);
        initialPic4 = new Picture(imagename);
        setPicture(initialPic4);
        double speed = rand.nextDouble(3.01, 5.001);
        setVel(-speed, 0);
        setX(x);
        setY(y);
    }

    public void processEvent(SpriteCollisionEvent se) {
            // makes the cars bump off of each other 

        final ArrayList<Integer> spawn = new ArrayList<Integer>();
        SpriteComponent sc = getSpriteComponent();
        sc.addSpriteSpriteCollisionListener(Enemy2.class, Enemy2.class, new SpriteSpriteCollisionListener<Enemy2, Enemy2>() {
            @Override
            public void collision(Enemy2 sp1, Enemy2 sp2) {
                sp1.setVel(sp2.getVelX() - .5, sp2.getVelY());
            }
        });
        // handles f the enemiy reaches the end of the screen
        if (se.xlo) {
            setX(sc.getSize().width - getWidth());
            double speed = rand.nextDouble(3.001, 5.001);
            setVel(-speed, 0);

        }
        if (se.xhi) {
            Dimension d = sc.getSize();
            setX(0);
            double speed = rand.nextDouble(3.001, 5.001);
            int i = rand.nextInt(0, 3);
            setVel(-speed, 0);

        }
        if (se.ylo) {
            setY(sc.getSize().height - getHeight());
            double speed = rand.nextDouble(3, 5);
            setVel(speed, 0);
        }
        if (se.yhi) {
            setY(0);
            double speed = rand.nextDouble(3, 5);
            setVel(speed, 0);
        }
    }

    
}
