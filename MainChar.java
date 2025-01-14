/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import static CrossyAntGame.CrossyAntGame.SCORE;
import static CrossyAntGame.CrossyAntGame.highScore;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author cjthomas
 */
public class MainChar extends Sprite {
    //  maincharacter logic
    public static int intialSpeed = CrossyAntGame.speed;
    public Picture initialPic3;
    public static final int spawnX = 700;
    public final static int spawnY = 770;
    int initialPosition = 0;
    public static int multiplier = 1;

    public MainChar(SpriteComponent sc, String charname) {
        super(sc);
        initialPic3 = new Picture(charname);
        setPicture(initialPic3);

        setX(spawnX);
        setY(spawnY);
    }
    // handles edge logic
    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.xlo) {
            JOptionPane.showMessageDialog(sc, "Wrong way!");

        }
        if (se.xhi) {
            JOptionPane.showMessageDialog(sc, "Wrong way!");

        }
        if (se.yhi) {
            sc.setLocation(sc.getX(), sc.getY());

        }
        if (se.ylo) {
            CrossyAntGame.done.playOverlapping();
            int coinsEarned = SCORE / 100;
            CoinManager.incrementCoinCount(coinsEarned);
            if (SCORE > highScore) {
                int oldHigh = HighScoreManager.loadHighScore();
                highScore = SCORE;
                HighScoreManager.saveHighScore(highScore);
                JOptionPane.showMessageDialog(sc, "You Win!\n" + "New High Score: " + highScore + "\nOld High: " + oldHigh + "\nCoins Collected: " + CrossyAntGame.coinsCollected + "\nWinning Bonus: " + coinsEarned + " coins");
                System.exit(0);
            }
            if (SCORE < highScore) {
                JOptionPane.showMessageDialog(sc, "You Win!\n" + "Score: " + SCORE + "\nHigh Score: " + highScore + "\nCoins Collected: " + CrossyAntGame.coinsCollected + "\nWinning Bonus: " + coinsEarned + " coins");
                System.exit(0);
            }
        }   
    }

    // scoring logic
    public void updateScore() {

        initialPosition = (int) this.getY();
        double scoreIncrement = 0;
        scoreIncrement = (int) (this.getY() / 10) * (multiplier);
        SCORE += scoreIncrement;
        ShowGame.scoreButton.setText("Score: " + SCORE);
    }

    public void updateScore(int amount) {
        SCORE += amount;
        ShowGame.scoreButton.setText("Score: " + SCORE);

    }

    public void stop() {
        setVel(0, 0);
    }

    public void reset() {
        setX(spawnX);
        setY(spawnY);
    }

    public void clearEffects() {
        setPicture(new Picture("ant-small.png"));
        immune = false;
        PowerUp.effectActive = false;

    }
    public static int[] respawn = {219, 340, 615};

    public int determineRespawn(int pos) {
        return CrossyAntGame.respawn + 15;
    }

    public static boolean immune = false;
    // shield buff effect logic
    public void makeImmune() {
        immune = true;
        System.out.println(immune);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                deactivateEffect();
            }
        }, PowerUp.time);
    }

    public void deactivateEffect() {
        immune = false;
        if (PowerUp.effectActive) {
            setPicture(new Picture("speedyant.png"));
        } else {
            setPicture(new Picture("ant-small.png"));
        }
    }

}
