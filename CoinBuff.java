package CrossyAntGame;

import static CrossyAntGame.CrossyAntGame.rand;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author cjthomas
 */
public class CoinBuff extends Sprite {
    
    // constructor for 5 coin bonus buff
    Picture p = new Picture("coindouble.png");

    public CoinBuff(SpriteComponent sc) {
        super(sc);
        setPicture(p);
        setPicture(p);
        double speed = rand.nextDouble(2, 3);
        setVel(0, speed);
        setX(rand.nextInt(470, 910));
        setY(0);
    }
// handles when the coin moves on the screens edge
    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.yhi) {
            setY(0);

        }
        if (se.ylo) {
            setY(sc.getHeight());
        }
    }

}
