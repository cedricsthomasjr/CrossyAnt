/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import static CrossyAntGame.CrossyAntGame.sc;
import javax.swing.JOptionPane;

/**
 *
 * @author cjthomas
 */
public class ShopManager {

    
    // Shop logic
    public static void ShowShop() {
        String[] options = {"Upgrade Speed (100 coins)", "Upgrade Effect Length (25 coins)", "Upgrade Score Multiplier (20 coins)"};
        if (SpeedManager.loadSpeed() == 4) {
            options[0] = "SPEED MAXED";
        }
        if (TimeManager.loadTime() == 4000) {
            options[1] = "EFFECT LENGTH MAXED";
        }
        if (MultManager.loadMult() == 4) {
            options[2] = "SCORE MULTIPLIER MAXED";
        }

        int choice = JOptionPane.showOptionDialog(
                null,
                "You have " + CoinManager.getCoinCount() + " coins.\nChoose an upgrade option:",
                "Upgrade Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        

        if (choice == 0) { 
            upgradeSpeed();
        } else if (choice == 1) { 
            upgradePowerUpTime();
        } else if (choice == 2) { 
            upgradeScoreMultiplier();
        } else {
        }
    }
    
    // handles speed upgrade
    private static void upgradeSpeed() {
        
        if (SpeedManager.loadSpeed() < 4) {
            if (CoinManager.loadCoinCount()>=100) {
                CoinManager.incrementCoinCount(-100);
                int intials = CrossyAntGame.speed;
                CrossyAntGame.speed++;
                SpeedManager.saveSpeed(CrossyAntGame.speed);
                JOptionPane.showMessageDialog(null, "Speed upgraded! " + "(" + intials * 10 + " mph " + "-->" + CrossyAntGame.speed * 10 + " mph" + ")");

            } else {
                JOptionPane.showMessageDialog(sc, "You dont have enough coins!");// executes when you dont have enough moneyy to purchase th upgrade
            }
        } else {
            JOptionPane.showMessageDialog(sc, "You have acheived max speed! (" + SpeedManager.loadSpeed() + " mph)");
        }
    }
    // handles time upgrade
    private static void upgradePowerUpTime() {
        
        if (TimeManager.loadTime() < 4000) {
            if (CoinManager.loadCoinCount()>=25) {
                CoinManager.incrementCoinCount(-25);
                int intialt = PowerUp.time;
                PowerUp.time += 1000;
                TimeManager.saveTime(PowerUp.time);
                JOptionPane.showMessageDialog(null, "Power-up time upgraded! " + "(" + intialt / 1000 + " seconds" + "-->" + PowerUp.time / 1000 + " seconds" + ")");
            } else {
                JOptionPane.showMessageDialog(sc, "You dont have enough coins!");// executes when you dont have enough moneyy to purchase th upgrade

            }
        } else {
            JOptionPane.showMessageDialog(sc, "You have acheived max buff length! (4 seconds)");
        }

    }
    // handles score upgrade
    private static void upgradeScoreMultiplier() {
        if (MultManager.loadMult() < 4) {
            if (CoinManager.loadCoinCount()>=20) {
                CoinManager.incrementCoinCount(-20);
                int initialm = MainChar.multiplier;
                MainChar.multiplier += 1;
                MultManager.saveMult(MainChar.multiplier);
                JOptionPane.showMessageDialog(null, "Score multiplier upgraded!" + "(" + initialm + "x " + "--> " + MainChar.multiplier + "x" + ")");
            } else { 
                JOptionPane.showMessageDialog(sc, "You dont have enough coins!"); // executes when you dont have enough moneyy to purchase th upgrade

            }
        } else {
            JOptionPane.showMessageDialog(sc, "You have acheived max score multiplier! (4x)");

        }

    }

}
