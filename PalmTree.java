/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

/**
 *
 * @author cjthomas
 */
public class PalmTree extends Sprite {

    public Picture iPic;
    //tree constructor
    public PalmTree(SpriteComponent sc, int x, int y) {
        super(sc);
        iPic = new Picture("palm-tree.png");
        setPicture(iPic);
        setX(x);
        setY(y);
    }
}
