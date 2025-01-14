/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import static CrossyAntGame.CrossyAntGame.rand;
import static CrossyAntGame.CrossyAntGame.sc;
import basicgraphics.SpriteComponent;
import java.util.TimerTask;

/**
 *
 * @author cjthomas
 */
public class OthersSpawnTask extends TimerTask {
    // spawns all other miscellaneous items such as coins, debuffs, and trees
    static int c = rand.nextInt(5, 8);
    static Coin[] coin = new Coin[c];
    public static CheckpointFlag cf1 = new CheckpointFlag(sc, 199, "redflag1.png");
    public static CheckpointFlag cf2 = new CheckpointFlag(sc, 370, "redflag1.png");
    public static CheckpointFlag cf3 = new CheckpointFlag(sc, 595, "redflag1.png");
     CoinBuff d = new CoinBuff(CrossyAntGame.sc);
    public OthersSpawnTask(SpriteComponent sc) {

        Oilslick o = new Oilslick(sc);

        PalmTree[] lowerleftPalms = new PalmTree[5];
        for (int i = 75; i <= 375; i += 75) {
            int t = 1;
            lowerleftPalms[t++] = new PalmTree(sc, i, 465);
        }
        PalmTree[] lowerrightPalms = new PalmTree[5];
        for (int i = 1025; i <= 1400; i += 75) {
            int u = 1;
            lowerleftPalms[u++] = new PalmTree(sc, i, 465);
        }
        PalmTree[] upperrightPalms = new PalmTree[5];
        for (int i = 75; i <= 375; i += 75) {
            int t = 1;
            lowerleftPalms[t++] = new PalmTree(sc, i, 360);
        }
        PalmTree[] upperleftPalms = new PalmTree[5];
        for (int i = 1025; i <= 1400; i += 75) {
            int u = 1;
            lowerleftPalms[u++] = new PalmTree(sc, i, 360);

        }
        for (int i = c - 1; i >= 0; i--) {
            coin[i] = new Coin(sc);
        }
        ShieldOrb s = new ShieldOrb(sc);
    }

    @Override
    public void run() {
        System.out.println("OthersSpawned");
    }

}
