/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import static CrossyAntGame.CrossyAntGame.asphalt;
import static CrossyAntGame.CrossyAntGame.grass_green;
import static CrossyAntGame.CrossyAntGame.sand;
import static CrossyAntGame.CrossyAntGame.sc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author cjthomas
 */
public class PaintBackground {
    // logic for painting background
    public static void paintGrass(Graphics g, Dimension d) {
        g.setColor(grass_green);
        g.fillRect(0, 0, d.width, d.height);
    }

    public static void paintAsphalt(Graphics g, Dimension d) {
        g.setColor(asphalt);
        g.fillRect(d.width / 3, 0, d.width / 3, d.height);
        g.fillRect(0, d.height / 6, d.width, d.height / 12);
        g.fillRect(0, d.height / 3, d.width, d.height / 12);
        g.fillRect(0, d.height / 2 + d.height / 6, d.width, d.height / 12);
        g.fillRect(0, d.height / 2 + d.height / 3, d.width, d.height / 12);
        g.fillRect(0, d.height / 2 + d.height / 3, d.width, d.height / 12);
    }

    public static void paintTrafficLines(Graphics g, Dimension d) {
        g.setColor(Color.yellow);
        g.fillRect(d.width / 2, 0, d.width / 100, d.height);
        g.fillRect(0, d.height / 5 + 5, d.width / 3, d.height / 200);
        g.fillRect(0, d.height / 3 + d.height / 26, d.width / 3, d.height / 200);
        g.fillRect(0, d.height / 5 + 5, d.width / 3, d.height / 200);
        g.fillRect(0, d.height - (d.height / 4 + 35), d.width / 3, d.height / 200);
        g.fillRect(0, d.height - (d.height / 8), d.width / 3, d.height / 200);
        g.fillRect(0, d.height / 5 + 5, d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height / 3 + d.height / 25, d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height / 5 + 5, d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height - (d.height / 4 + 35), d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height - (d.height / 8), d.width / 3, d.height / 200);
    }

    public static void paintOuterLines(Graphics g, Dimension d) {
        g.setColor(Color.white);
        g.fillRect(d.width / 3, 0, 5, d.height / 6);
        g.fillRect(d.width / 3, d.height / 6 + d.height / 12, 5, d.height / 12);
        g.fillRect(d.width / 3, d.height / 6 + d.height / 4, 5, d.height / 4);
        g.fillRect(d.width / 3, d.height / 2 + d.height / 4, 5, d.height / 12);
        g.fillRect(d.width / 3, d.height - d.height / 12, 5, d.height / 12);
        g.fillRect(d.width / 3 + d.width / 3, 0, 5, d.height / 6);
        g.fillRect(d.width / 3 + d.width / 3, d.height / 6 + d.height / 12, 5, d.height / 12);
        g.fillRect(d.width / 3 + d.width / 3, d.height / 6 + d.height / 4, 5, d.height / 4);
        g.fillRect(d.width / 3 + d.width / 3, d.height / 2 + d.height / 4, 5, d.height / 12);
        g.fillRect(d.width / 3 + d.width / 3, d.height - d.height / 12, 5, d.height / 12);
        g.fillRect(d.width / 3 + d.width / 3, d.height / 6, d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height / 3, d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height - d.height / 3, d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height - d.height / 6, d.width / 3, d.height / 200);
        g.fillRect(0, d.height / 6, d.width / 3, d.height / 200);
        g.fillRect(0, d.height / 3, d.width / 3, d.height / 200);
        g.fillRect(0, d.height - d.height / 3, d.width / 3, d.height / 200);
        g.fillRect(0, d.height - d.height / 6, d.width / 3, d.height / 200);
        g.fillRect(0, d.height - d.height / 12, d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height - d.height / 12, d.width / 3, d.height / 200);
        g.fillRect(0, d.height - d.height / 4, d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height - d.height / 4, d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height / 12 + d.height / 6, d.width / 3, d.height / 200);
        g.fillRect(0, d.height / 12 + d.height / 6, d.width / 3, d.height / 200);
        g.fillRect(0, d.height / 6 + d.height / 4, d.width / 3, d.height / 200);
        g.fillRect(d.width / 3 + d.width / 3, d.height / 6 + d.height / 4, d.width / 3, d.height / 200);
    }

    public static void paintRiver(Graphics g, Dimension d) {
        River r = new River(sc,g);
    }

    public static void paintSand(Graphics g, Dimension d) {
        g.setColor(sand);
        g.fillRect(0, d.height / 2 + d.height / 12, d.width, d.height / 24);
        g.fillRect(0, d.height / 2 - d.height / 24, d.width, d.height / 24);

    }

}
