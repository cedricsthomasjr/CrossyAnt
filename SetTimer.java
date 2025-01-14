/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import static CrossyAntGame.CrossyAntGame.Buff;
import static CrossyAntGame.CrossyAntGame.Coin;
import static CrossyAntGame.CrossyAntGame.Others;
import static CrossyAntGame.CrossyAntGame.sc;
import static CrossyAntGame.CrossyAntGame.spawnTimer;
import static CrossyAntGame.CrossyAntGame.spawnTimerFlipped;
import basicgraphics.ClockWorker;
import java.util.Timer;

/**
 *
 * @author cjthomas
 */
public class SetTimer {

    public static Timer CoinBuff;

    public static void setTimers() throws InterruptedException {
        try {
            // Handle collisions, move characters, and initialize clock worker
            CharacterMovement.moveChar();
            CollisionHandler.handleCollisions();
            ClockWorker.initialize(10);
            ClockWorker.addTask(sc.moveSprites());
            Coin = new Timer();
            spawnTimer = new Timer();
            Others = new Timer();
            Buff = new Timer();
            spawnTimerFlipped = new Timer();
            CoinBuff = new Timer();
            Others.schedule(new OthersSpawnTask(sc), 0);
            spawnTimerFlipped.schedule(new SpawnTaskFlipped(sc), 1);
            spawnTimer.schedule(new SpawnTask(sc), 2);
            Buff.schedule(new SpawnTaskBuff(sc), 3);
        } catch (InterruptedException e) {
            System.out.println("Misfire");
        }
    }

}
