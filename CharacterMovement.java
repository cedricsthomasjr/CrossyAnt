 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import static CrossyAntGame.CrossyAntGame.bc2;
import static CrossyAntGame.CrossyAntGame.speed;
import static CrossyAntGame.CrossyAntGame.you;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author cjthomas
 */


// a key listener for main character movement, catched a null pointer exception thrown when you try to move before character has spawned

public class CharacterMovement {    
    
    public static void moveChar() {
        bc2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {

                switch (ke.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        try {
                            you.setVel(0, -speed - .25);
                            you.updateScore();
                        } catch (NullPointerException n) {
                            System.out.println("No movement until character has spawned!");
                        }   break;
                    case KeyEvent.VK_RIGHT:
                        try {
                            you.setVel(speed +.25 , 0);
                        } catch (NullPointerException n) {
                            System.out.println("No movement until character has spawned!");
                        }   break;
                    case KeyEvent.VK_LEFT:
                        try {
                            you.setVel(-speed -.25 , 0);
                        } catch (NullPointerException n) {
                            System.out.println("No movement until character has spawned!");
                            
                        }   break;
                    case KeyEvent.VK_DOWN:
                        try {
                            you.setVel(0, speed +.25);
                        } catch (NullPointerException n) {
                            System.out.println("No movement until character has spawned!");
                            
                        }   break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    you.setVel(0, 0);
                    System.out.println(you.getY());

                } catch (NullPointerException n) {
                    System.out.println("No movement until character has spawned!");

                }
            }
        });

    }
}
