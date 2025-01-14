/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import static CrossyAntGame.CoinManager.amount;
import static CrossyAntGame.CrossyAntGame.bc1;
import static CrossyAntGame.CrossyAntGame.bc2;
import static CrossyAntGame.CrossyAntGame.bf;
import static CrossyAntGame.CrossyAntGame.cards;
import static CrossyAntGame.CrossyAntGame.coinButton;
import static CrossyAntGame.CrossyAntGame.content;
import static CrossyAntGame.CrossyAntGame.countdownLabel;
import static CrossyAntGame.CrossyAntGame.countdownPanelRemoved;

import static CrossyAntGame.CrossyAntGame.sc;

import static CrossyAntGame.CrossyAntGame.you;

import basicgraphics.SpriteComponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author cjthomas
 */
public class ShowGame {

    public static JButton scoreButton;

    // shows Game UI, title screen, and game screen
    public static void ShowGame() {
        CoinManager.initialAmount = amount;
        content.setLayout(cards);
        content.add(bc1, "Splash");
        content.add(bc2, "Game");
        sc = new SpriteComponent() {
            @Override
            public void paintBackground(Graphics g) {
                Dimension d = getSize();
                PaintBackground.paintGrass(g, d);
                PaintBackground.paintRiver(g, d);
                PaintBackground.paintSand(g, d);
                PaintBackground.paintAsphalt(g, d);
                PaintBackground.paintOuterLines(g, d);
                PaintBackground.paintTrafficLines(g, d);
            }
        };
        bc2.add(sc);
        scoreButton = new JButton("Score: 0");
        scoreButton.setEnabled(false);
        coinButton = new JButton("Coins: " + CoinManager.getCoinCount());
        coinButton.setEnabled(false);
        bc2.add(coinButton);
        bc2.add(scoreButton);

        sc.setPreferredSize(new Dimension(sc.getMaximumSize()));
        Dimension d = sc.getPreferredSize();
        String[][] layout1 = {
            {"Title"},
            {"Welcome"},
            {"Button"},
            {"How-To"},
            {"Shop"},
            {"Stats"},
            {"Kill"},};
        JButton jstart = new JButton("Start");
        JButton kill = new JButton("Quit Game");
        JButton instructionsButton = new JButton("Instructions");
        bc1.setStringLayout(layout1);
        try {
            bc1.add("Title", new JLabel("Crossy Ant"));
            bc1.add("Welcome", new JLabel("Welcome User: " + CrossyAntGame.username));
            bc1.add("Button", jstart);
            bc1.add("Kill", kill);

            bc1.add("How-To", instructionsButton);
        } catch (basicgraphics.GuiException e) {

        }

        kill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options2 = {"Yes", "No"};
                int option2 = JOptionPane.showOptionDialog(sc, "Sad to see you go. Are you sure you want to exit the game?", "Quit Game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.CANCEL_OPTION, null, options2, options2[0]);
                if (option2 == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        jstart.setPreferredSize(new Dimension(100, 100));

        instructionsButton.setPreferredSize(new Dimension(100, 100));
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInstructions();
            }
        });
        JButton shopButton = new JButton("Shop");
        shopButton.setPreferredSize(new Dimension(100, 100));
        try {
            bc1.add("Shop", shopButton);
        } catch (basicgraphics.GuiException e) {

        }
        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShopManager.ShowShop();
            }
        });
        JButton statButton = new JButton("Stats");
        statButton.setPreferredSize(new Dimension(100, 100));
        try {
            bc1.add("Stats", statButton);
        } catch (basicgraphics.GuiException e) {

        }
        statButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowStats.ShowStats();
            }
        });
        jstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CrossyAntGame.start.playOverlapping();
                JPanel countdownPanel = new JPanel();
                System.out.println("Start button clicked");
                countdownLabel = new JLabel();
                countdownPanel.add(countdownLabel);
                bc2.add(countdownPanel, BorderLayout.NORTH);
                content.setPreferredSize(new Dimension(d.width, d.height));
                countdownPanel.setVisible(true);
                countdownLabel.setText("Character spawning in 3...");

                Timer countdownTimer = new Timer();
                countdownTimer.scheduleAtFixedRate(new TimerTask() {
                    int count = 3;

                    @Override
                    public void run() {
                        countdownLabel.setText("Character spawning in " + count + "...");
                        count--;
                        if (count < 0) {
                            countdownLabel.setText("GO!!!   Use arrow keys to move.");
                            if (!countdownPanelRemoved) {
                                bc2.remove(countdownLabel);
                                bc1.remove(countdownLabel);
                                countdownLabel.setVisible(false);
                                bc2.revalidate();
                                bc2.repaint();
                                countdownPanelRemoved = true; // logic that for the player countdown
                            }
                        }
                    }
                }, 0, 1000);
                Timer characterSpawnTimer = new Timer();
                characterSpawnTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // Spawn the character after the delay
                        you = new MainChar(sc, "ant-small.png");

                    }
                }, 3000);
                Timer countdownUpdateTimer = new Timer();

                // show the game card
                cards.show(content, "Game");

                // request focus for bc2
                bc2.requestFocus();

            }
        });

        String[][] layout2 = {{
            "Crossy Ant"
        }};

        bc2.setStringLayout(layout2);

        try {
            bc2.add("Crossy Ant", sc);
        } catch (basicgraphics.GuiException e) {
        }

        bc2.setLayout(new BoxLayout(bc2, BoxLayout.Y_AXIS));
        bf.show();

    }

    // joption pane for the instructions
    private static void displayInstructions() {
        String instructionsText = """
                                  
                              HOW TO PLAY
                                  
                              After you click start, your ant will take 3 seconds, and then spawn at the bottom of the screen.
                              When you spawn in, move using the arrow keys towards the top of the screen. Dodge the cars, or else you will get squished!
                              Your goal is to finish with as high a score as possible, collecting coins along the way to upgrade your character in the shop.
                              Finally, HAVE FUN!!!
                              
                              CHECKPOINTS
                                 
                              Collide with flags to save your checkpoint. The flag will turn green, float, and beep, confirming that this is your spawn point.
                              Respawning at checkpoints costs 5 coins.    
                              
                              POWERUPS
                              
                              Powerups will momentarily spawn from the top of the map, including:
                              
                              A pile of coins granting 5 coins and +500 score on collision. 
                              A flame that temporarily increases your speed and +900 score on collision.
                                  ***AS YOU UPGRADE YOUR SPEED THE SPEED BOOST FROM THIS BUFF GETS LARGER*** 
                              An orb of protection shielding you from getting ran over temporarily and +1500 score on collision.
                                                                         
                              OBSTACLES
                                  
                              Beware! During your trek across the screen you will encounter many obstaces!
                              
                              Cars will flatten you on collision as you try to navigate across the map (Some of which are speeding!)
                              Oilslicks cause you to slip and cut your movement speed in half for one second.
                              Trees are to thick for this ant to travel through! 
                                
                              SCORE
                                  
                              Score will be increased as you traverse through the map. This however will not be the main source of your score.
                              Try to collect coins and powerups. There are large score bonuses attatched to powerups, and small score bonuses are attatched to coins.
                              This scoring system encourages you to walk around, explore, and interact with the different aspects of the game! 
                              If you win, your score will be divided by 100. The resulting quotient will be the amount of coins that you earn for winning!
                                  
                              COINS
                                  
                              Collecting coins increases score, as well as adds coins to your coin total. This coin total is saveable, even when you exit the game.
                              Coins are used to ugrade your character in the shop, as well as respawning to the nearest checkpoint (the last lane you were in between)
                              Upgrades include am increase to the score mulitplier, speed upgrades, as well as increases of the duration of buffs.
                             """;

        JOptionPane.showMessageDialog(null, instructionsText, "Game Instructions", JOptionPane.INFORMATION_MESSAGE);
    }
}
