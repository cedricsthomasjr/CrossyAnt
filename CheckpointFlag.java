/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Dimension;

/**
 *
 * @author cjthomas
 */

// constructor for checkpoints that save respawn
public class CheckpointFlag extends Sprite {

    public Picture Checkpoint;

    public CheckpointFlag(SpriteComponent sc, int y, String name) {
        super(sc);
        Dimension d = sc.getSize();
        Checkpoint = new Picture(name);
        setPicture(Checkpoint);
        setY(y);
        setX(730);
    }

}
