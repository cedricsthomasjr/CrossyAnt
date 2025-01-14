/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author cjthomas
 */

// methods to add, subtract, update coin button, save, and load coins.
public class CoinManager {

    public static int amount = 0;
    public static int initialAmount = getCoinCount();

    public static int getCoinCount() {
        int d = loadCoinCount();
        return d;
    }

    public static void incrementCoinCount() {
        amount++;
        saveCoinCount();
        updateCoinButton();
    }

    public static void incrementCoinCount(int count) {

        if (amount + count >= 0) {
            amount = amount + count;
            saveCoinCount();
            updateCoinButton();
        } else {
            brokeBoy();
        }

    }
    public static boolean broke = false;

    public static void brokeBoy() {
        broke = true;
    }

    public static void saveCoinCount() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("amount.dat"));
            outputStream.writeInt(amount);
            outputStream.close();
        } catch (IOException e) {
        }
    }

    public static int loadCoinCount() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("amount.dat"));
            amount = inputStream.readInt();
            inputStream.close();
        } catch (IOException e) {
            
        } 
       
        return amount;

    }

    private static void updateCoinButton() {
        CrossyAntGame.coinButton.setText("Coins: " + amount);
    }

    static void resetCoinButton() {
        CrossyAntGame.coinButton.setText("Coins: " + initialAmount);
    }

}
