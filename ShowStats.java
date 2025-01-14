/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import javax.swing.JOptionPane;

/**
 *
 * @author cjthomas
 */
public class ShowStats {
    // a simple JOptionPane that displays your current attributes
    public static void ShowStats() {
        String[] options = {"Reset Stats", "Close"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Your stats are:\n\n\n" + "Coins: " + CoinManager.getCoinCount() + " coins" + "\nSpeed: " + SpeedManager.loadSpeed() * 10 + " mph" + "\nScore Multiplier: " + MultManager.loadMult() + "x\nPower-Up Duration: " + TimeManager.loadTime() / 1000 + " seconds\n",
                "Stats",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (choice == JOptionPane.YES_OPTION) {
            SpeedManager.resetFile();
            TimeManager.resetFile();
            MultManager.resetFile();
            JOptionPane.showMessageDialog(null, "Attributes have been reset.");
        }

    }

}
