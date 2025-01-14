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

public class ShieldOrb extends Sprite {        
    Picture p = new Picture("shieldorb.png");
    //constructor for shield orb
    public ShieldOrb(SpriteComponent sc){
        super(sc);
        Random rand = new Random();
        setPicture(p);
        setX(rand.nextDouble(470, 870));
        setY(rand.nextDouble(350, 750));
    }
    
    
}
