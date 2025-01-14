/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.util.Random;

/**
 *
 * @author cjthomas
 */

// constructor for saveable coin
public class Coin extends Sprite {

    public Picture ip = new Picture("coin.png");

    public Coin(SpriteComponent sc) {
        super(sc);
        setPicture(ip);
        Random rand = new Random();
        setX(rand.nextDouble(470, 910));
        setY(rand.nextDouble(0, 750));
    }

}
