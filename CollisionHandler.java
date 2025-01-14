/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrossyAntGame;

import static CrossyAntGame.CoinManager.amount;
import static CrossyAntGame.CrossyAntGame.SCORE;
import static CrossyAntGame.CrossyAntGame.coinbuff;
import static CrossyAntGame.CrossyAntGame.collect;
import static CrossyAntGame.CrossyAntGame.dieSound;
import static CrossyAntGame.CrossyAntGame.pos;
import static CrossyAntGame.CrossyAntGame.rand;
import static CrossyAntGame.CrossyAntGame.sc;
import static CrossyAntGame.CrossyAntGame.you;
import static CrossyAntGame.MainChar.respawn;
import basicgraphics.Sprite;
import basicgraphics.SpriteSpriteCollisionListener;
import basicgraphics.images.Picture;
import javax.swing.JOptionPane;

/**
 *
 * @author cjthomas
 */
public class CollisionHandler {
// this class handles all the collisions relevant to the game

    public static void handleCollisions() {
        handleCoin();
        handlePowerUp();
        handleOilslick();
        handleTrees();
        handleCoinBuff();
        handleShieldBuff();
        handleCrashes();
        handleCheckPoint();
    }

    public static void handleCrashes() {
        sc.addSpriteSpriteCollisionListener(Enemy1.class, MainChar.class, new SpriteSpriteCollisionListener<Enemy1, MainChar>() {
            @Override
            public void collision(Enemy1 sp1, MainChar sp2) {
                if (sp2.getY() > 660.25 || !CrossyAntGame.checkpointActive) {
                    Picture p = new Picture("splat.png");
                    you.setPicture(p);
                    you.stop();
                    stopAllSprites();
                    Object[] options2 = {"Retry", "Quit"};
                    int option2 = JOptionPane.showOptionDialog(sc, "You died. Respawn or Quit.", "You died", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.CANCEL_OPTION, null, options2, options2[0]);
                    if (option2 == JOptionPane.YES_OPTION) {
                        OthersSpawnTask.cf1.setPicture(new Picture("redflag1.png"));
                        OthersSpawnTask.cf2.setPicture(new Picture("redflag1.png"));
                        OthersSpawnTask.cf3.setPicture(new Picture("redflag1.png"));
                        sp2.setY(MainChar.spawnY);
                        you.clearEffects();
                        you.updateScore(-SCORE);
                        resumeSprites();
                    } else {
                        System.exit(0);
                    }
                } else if (!MainChar.immune) {
                    you.stop();
                    stopAllSprites();
                    dieSound.playOverlapping();
                    Picture dead = new Picture("splat.png");
                    CrossyAntGame.gameOverCondition = true;
                    you.setPicture(dead);
                    Object[] options = {"Start Over ", "Resume (5 Coins)", "Quit"};
                    int option = JOptionPane.showOptionDialog(sc, "You died! What do you want to do?", "Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (option == JOptionPane.YES_OPTION) {
                        you.reset();
                        you.clearEffects();
                        you.updateScore(-SCORE);
                        OthersSpawnTask.cf1.setPicture(new Picture("redflag1.png"));
                        OthersSpawnTask.cf2.setPicture(new Picture("redflag1.png"));
                        OthersSpawnTask.cf3.setPicture(new Picture("redflag1.png"));
                        resumeSprites();
                    } else if (option == JOptionPane.NO_OPTION) {
                        
                        if (CoinManager.loadCoinCount()>=5) {
                            CoinManager.incrementCoinCount(-5);
                            resumeSprites();
                            you.clearEffects();
                            pos = (int) you.getY();
                            you.setY(you.determineRespawn(pos));
                            you.setX(730);
                        } else {
                            Object[] options2 = {"Retry", "Quit Game"};
                            int option2 = JOptionPane.showOptionDialog(sc, "You do not have enough coins to respawn", "Get Your Money Up, Not Your Funny Up", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.CANCEL_OPTION, null, options2, options2[0]);
                            if (option2 == JOptionPane.YES_OPTION) {
                                you.reset();
                                you.clearEffects();
                                you.updateScore(-SCORE);
                                OthersSpawnTask.cf1.setPicture(new Picture("redflag1.png"));
                                OthersSpawnTask.cf2.setPicture(new Picture("redflag1.png"));
                                OthersSpawnTask.cf3.setPicture(new Picture("redflag1.png"));
                                resumeSprites();
                            } else {
                                System.exit(0);
                            }
                        }

                    } else {
                        CoinManager.resetCoinButton();
                        CoinManager.initialAmount = amount;
                        System.exit(0);
                    }
                }
            }
        });
        sc.addSpriteSpriteCollisionListener(Enemy2.class, MainChar.class, new SpriteSpriteCollisionListener<Enemy2, MainChar>() {
            @Override
            public void collision(Enemy2 sp1, MainChar sp2) {
                if (sp2.getY() > 660.25 || !CrossyAntGame.checkpointActive) {
                    Picture p = new Picture("splat.png");
                    you.setPicture(p);
                    you.stop();
                    stopAllSprites();
                    Object[] options2 = {"Retry", "Quit"};
                    int option2 = JOptionPane.showOptionDialog(sc, "You died. Respawn or Quit.", "You died", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.CANCEL_OPTION, null, options2, options2[0]);
                    if (option2 == JOptionPane.YES_OPTION) {
                        sp2.setY(MainChar.spawnY);
                        OthersSpawnTask.cf1.setPicture(new Picture("redflag1.png"));
                        OthersSpawnTask.cf2.setPicture(new Picture("redflag1.png"));
                        OthersSpawnTask.cf3.setPicture(new Picture("redflag1.png"));
                        you.clearEffects();
                        you.updateScore(-SCORE);
                        resumeSprites();
                    } else {
                        System.exit(0);
                    }
                } else if (!MainChar.immune) {
                    you.stop();
                    stopAllSprites();
                    dieSound.playOverlapping();
                    Picture p = new Picture("splat.png");
                    int d = (int) you.getY();
                    CrossyAntGame.gameOverCondition = true;
                    you.setPicture(p);
                    Object[] options = {"Start Over", "Resume (5 Coins)", "Quit"};
                    int option = JOptionPane.showOptionDialog(sc, "You died! What do you want to do?", "Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (option == JOptionPane.YES_OPTION) {
                        you.reset();
                        you.clearEffects();
                        CrossyAntGame.checkpointActive = false;
                        CrossyAntGame.respawn = MainChar.spawnY;
                        you.updateScore(-SCORE);
                        OthersSpawnTask.cf1.setPicture(new Picture("redflag1.png"));
                        OthersSpawnTask.cf2.setPicture(new Picture("redflag1.png"));
                        OthersSpawnTask.cf3.setPicture(new Picture("redflag1.png"));
                        resumeSprites();
                    } else if (option == JOptionPane.NO_OPTION) {
                        if (d - MainChar.spawnY < d - respawn[1] && d - MainChar.spawnY < d - respawn[2] && d - MainChar.spawnY < d - respawn[0]) {
                            CoinManager.incrementCoinCount(-5);
                            you.reset();
                            you.clearEffects();
                        }
                        if (CoinManager.loadCoinCount()>=5) {
                            CoinManager.incrementCoinCount(-5);
                            resumeSprites();
                            you.clearEffects();
                            pos = (int) you.getY();
                            you.setY(you.determineRespawn(pos));
                            you.setX(730);

                        } else {
                            Object[] options2 = {"Retry", "Quit"};
                            int option2 = JOptionPane.showOptionDialog(sc, "You do not have enough coins to respawn", "Get Your Money Up, Not Your Funny Up", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.CANCEL_OPTION, null, options2, options2[0]);
                            if (option2 == JOptionPane.YES_OPTION) {
                                you.reset();
                                you.clearEffects();
                                you.updateScore(-SCORE);
                                resumeSprites();
                            } else {
                                System.exit(0);
                            }
                        }

                    } else {
                        CoinManager.resetCoinButton();
                        CoinManager.initialAmount = amount;
                        System.exit(0);
                    }
                }
            }
        });

    }

    public static void handlePowerUp() {
        sc.addSpriteSpriteCollisionListener(MainChar.class, PowerUp.class, (MainChar sp1, PowerUp sp2) -> {
            Picture newPic = new Picture("speedyant.png");
            CrossyAntGame.powerUpSound.playOverlapping();
            you.updateScore(900);
            sp1.setPicture(newPic);
            sp2.setActive(false);
            PowerUp.activateEffect();
            Picture p1 = new Picture("shieldedant.png");
            Picture p2 = new Picture("megaant.png");
            if (PowerUp.effectActive) {
                sp2.setPicture(p1);
            }
            if (MainChar.immune && PowerUp.effectActive) {
                sp2.setPicture(p2);
            }
        });
    }

    public static void handleOilslick() {
        sc.addSpriteSpriteCollisionListener(MainChar.class, Oilslick.class, new SpriteSpriteCollisionListener<MainChar, Oilslick>() {
            @Override
            public void collision(MainChar sp1, Oilslick sp2) {
                CrossyAntGame.slip.playOverlapping();
                Oilslick.activateEffect();
            }
        });
    }

    public static void handleCoin() {
        sc.addSpriteSpriteCollisionListener(MainChar.class, Coin.class, new SpriteSpriteCollisionListener<MainChar, Coin>() {
            @Override
            public void collision(MainChar sp1, Coin sp2) {
                collect.playOverlapping();
                CrossyAntGame.coinsCollected++;
                you.updateScore(50);
                CoinManager.incrementCoinCount();
                System.out.println(CoinManager.getCoinCount());
                sp2.setActive(false);
            }
        });
    }

    public static void handleTrees() {
        sc.addSpriteSpriteCollisionListener(MainChar.class, PalmTree.class, new SpriteSpriteCollisionListener<MainChar, PalmTree>() {
            @Override
            public void collision(MainChar mainChar, PalmTree palmTree) {
                double dx = mainChar.getX() - palmTree.getX();
                double dy = mainChar.getY() - palmTree.getY();

                double overlapX = (mainChar.getWidth() + palmTree.getWidth()) / 2 - Math.abs(dx);
                double overlapY = (mainChar.getHeight() + palmTree.getHeight()) / 2 - Math.abs(dy);

                if (overlapX < overlapY) {
                    mainChar.setX(mainChar.getX() + (dx > 0 ? overlapX : -overlapX));
                } else {
                    mainChar.setY(mainChar.getY() + (dy > 0 ? overlapY : -overlapY));
                }

            }
        });

    }

    public static void handleCoinBuff() {
        sc.addSpriteSpriteCollisionListener(CoinBuff.class, MainChar.class, new SpriteSpriteCollisionListener<CoinBuff, MainChar>() {
            @Override
            public void collision(CoinBuff sp1, MainChar sp2) {
                coinbuff.playOverlapping();
                CrossyAntGame.coinsCollected += 5;
                CoinManager.incrementCoinCount(5);
                you.updateScore(500);
                System.out.println(CoinManager.getCoinCount());
                sp1.setActive(false);
            }
        });
    }

    public static void handleShieldBuff() {
        sc.addSpriteSpriteCollisionListener(ShieldOrb.class, MainChar.class, new SpriteSpriteCollisionListener<ShieldOrb, MainChar>() {
            @Override
            public void collision(ShieldOrb sp1, MainChar sp2) {
                CrossyAntGame.shielded.playOverlapping();
                sp1.setActive(false);
                you.makeImmune();
                you.updateScore(1500);
                Picture p1 = new Picture("shieldedant.png");
                Picture p2 = new Picture("megaant.png");
                if (MainChar.immune) {
                    sp2.setPicture(p1);
                }
                if (PowerUp.effectActive) {
                    sp2.setPicture(p2);
                }
            }
        });
    }

    public static void handleCheckPoint() {
        sc.addSpriteSpriteCollisionListener(CheckpointFlag.class, MainChar.class, new SpriteSpriteCollisionListener<CheckpointFlag, MainChar>() {
            @Override
            public void collision(CheckpointFlag sp1, MainChar sp2) {
                Picture p = new Picture("activatedCheckPoint.png");
                if (sp1.getPicture() == p) {
                    OthersSpawnTask.cf1.setPicture(new Picture("redflag1.png"));
                    OthersSpawnTask.cf2.setPicture(new Picture("redflag1.png"));
                    OthersSpawnTask.cf3.setPicture(new Picture("redflag1.png"));
                    CrossyAntGame.respawn = (int) sp1.getY();
                    CrossyAntGame.checkpointActive = true;
                }
                if (sp1.getPicture() != p) {
                    OthersSpawnTask.cf1.setPicture(new Picture("redflag1.png"));
                    OthersSpawnTask.cf2.setPicture(new Picture("redflag1.png"));
                    OthersSpawnTask.cf3.setPicture(new Picture("redflag1.png"));
                    sp1.setPicture(new Picture("activatedCheckPoint.png"));
                    CrossyAntGame.checkpoint.playOverlapping();
                    CrossyAntGame.respawn = (int) sp1.getY();
                    CrossyAntGame.checkpointActive = true;
                }
            }
        });
    }

    public static void stopAllSprites() {
        for (Sprite sprite : SpawnTask.EnemiesSpawnable1) {
            sprite.setVel(0, 0);
        }
        for (Sprite sprite : SpawnTaskFlipped.EnemiesSpawnable2) {
            sprite.setVel(0, 0);
        }
        try {
            for (Sprite sprite : SpawnTaskBuff.p) {
                sprite.setVel(0, 0);
            }
        } catch (NullPointerException n) {
            System.out.println("No Powerups to Stop!");
        }
    }

    public static void resumeSprites() {
        for (Sprite sprite : SpawnTask.EnemiesSpawnable1) {
            sprite.setVel(rand.nextDouble(3, 4), 0);
        }
        for (Sprite sprite : SpawnTaskFlipped.EnemiesSpawnable2) {
            sprite.setVel(rand.nextDouble(-4, -3), 0);
        }
        try {
            for (Sprite sprite : SpawnTaskBuff.p) {
                sprite.setVel(0, rand.nextDouble(2, 3));
            }
        } catch (NullPointerException n) {
            System.out.println("No Powerups to Reset!");
        }

    }
    
 

}
