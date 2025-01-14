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
public class Enemy1 extends Sprite {

    public Picture initialPic2;
    Random rand = new Random();
    // constructor for enemy 1
    public Enemy1(SpriteComponent sc, int x, int y, String imagename) {
        super(sc);
        initialPic2 = new Picture(imagename);
        setPicture(initialPic2);
        double speed = rand.nextDouble(3.5, 5);
        setVel(speed, 0);
        setX(x);
        setY(y);

    }
    final ArrayList<Integer> spawn = new ArrayList<Integer>();
    
    // makes the cars bump off of each other 
    public void processEvent(SpriteCollisionEvent se) {
        spawn.add(146);
        spawn.add(293);
        spawn.add(585);
        spawn.add(734);
        SpriteComponent sc = getSpriteComponent();
        sc.addSpriteSpriteCollisionListener(Enemy1.class, Enemy1.class, new SpriteSpriteCollisionListener<Enemy1, Enemy1>() {
            @Override
            public void collision(Enemy1 sp1, Enemy1 sp2) {
                sp1.setVel(sp2.getVelX() + .5, sp2.getVelY());
            }
        });
        // handles when the cars reach the end of the map
        if (se.xlo) {
            setX(sc.getSize().width - getWidth());
            double speed = rand.nextDouble(3, 5);
            setVel(speed, 0);
        }
        if (se.xhi) {
            Dimension d = sc.getSize();
            setX(0);
            double speed = rand.nextDouble(3, 5);
            int i = rand.nextInt(0, 3);
            setVel(speed, 0);

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

    

    public void respawn() {
        setX(0);
    }
}
