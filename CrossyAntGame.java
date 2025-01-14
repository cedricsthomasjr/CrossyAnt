package CrossyAntGame;

import basicgraphics.BasicContainer;
import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;
import basicgraphics.sounds.ReusableClip;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;

/**
 *
 * @author cjthomas
 */
public class CrossyAntGame {

    public static ArrayList<Object> mixedList = new ArrayList<>();
    public static Timer spawnTimer;
    public static Timer Others;
    public static Timer Buff;
    public static Timer Coin;
    public static boolean restarted = false;
    public static String username = System.getProperty("user.name");

    public static Timer spawnTimerFlipped;
    public static JPanel coinPanel;
    public static JLabel coinLabel;
    public static JButton scoreLabel;

    public static int SCORE = 0;
    public static double dist = 0;
    
    final static ReusableClip powerUpSound = new ReusableClip("sound1.wav");
    final static ReusableClip collect = new ReusableClip("coin.wav");
    final static ReusableClip dieSound = new ReusableClip("splattt-6295.wav");
    final static ReusableClip coinbuff = new ReusableClip("coinbuff.wav");
    final static ReusableClip slip = new ReusableClip("slip.wav");
    final static ReusableClip titleSong = new ReusableClip("titleSong.wav");
    final static ReusableClip start = new ReusableClip("game-start-6104.wav");
    final static ReusableClip shielded = new ReusableClip("shielded.wav");
    final static ReusableClip checkpoint = new ReusableClip("checkpoint.wav");
    final static ReusableClip done = new ReusableClip("done.wav");
    
    static Color grass_green = new Color(0, 200, 0);
    static Color asphalt = new Color(80, 80, 80);
    static Color water = new Color(65, 107, 223);
    static Color sand = new Color(225, 191, 146);
    public static int speed = 2;
    public static final BasicFrame bf = new BasicFrame("Crossy Ant");
    final static Container content = bf.getContentPane();
    final static CardLayout cards = new CardLayout();
    static BasicContainer bc1 = new BasicContainer();
    final public static BasicContainer bc2 = new BasicContainer();
    public static SpriteComponent sc = new SpriteComponent();
    public static MainChar you;
    public static JLabel countdownLabel;
    public static boolean countdownPanelRemoved = true;
    static Random rand = new Random();
    public static JButton coinButton;
    public static int playerYPosition;
    public static boolean gameOverCondition;
    public static int highScore = 0;
    public static int pos = 0;
    public static int coinsCollected = 0;
    public static int respawn = MainChar.spawnY;
    public static boolean checkpointActive = false;
    public static Dimension d = sc.getSize();
   
    
    // main class, contains the main game loop and calls on most of the methods in the game directly or indirectly
    public static void main(String[] args) throws InterruptedException {
        ShowGame.ShowGame();
        LoadAll.loadAll();
        while (true) {
            titleSong.loop();
            SetTimer.setTimers();
        }
    }
}