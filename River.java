/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author cjthomas
 */
public class River extends Sprite{
    //river
    public River(SpriteComponent sc, Graphics g){
        super(sc);
        Dimension d = sc.getSize(); 
        g.setColor(CrossyAntGame.water);
        g.fillRect(0, d.height / 2, d.width, d.height / 12);
}
    
}
