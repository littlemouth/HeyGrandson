package dfst.com.heygrandson.defender;

import java.util.Random;

import dfst.com.heygrandson.basic.DrawElement;
import dfst.com.heygrandson.basic.Vector;
import dfst.com.heygrandson.bullet.Bullet;
import dfst.com.heygrandson.core.Processor;
import dfst.com.heygrandson.enemy.Enemy;
import dfst.com.heygrandson.util.VectorUtil;

/**
 * Created by yanfei on 2016-09-29.
 */
public abstract class BasicDefender extends DrawElement implements Defender {
    protected Enemy enemy;
    protected float radius;
    protected float effectiveDistance;
    private Random random = new Random();

    @Override
    public float getEffectiveDistance() {
        return effectiveDistance;
    }

    @Override
    public void captureEnemy() {
        if (enemy == null) {
            float distance = 0;
            Enemy enemyTemp = null;
            synchronized (Processor.enemies) {
                for (Enemy e : Processor.enemies) {
                    if (!e.isAlive()) continue;
                    float len = VectorUtil.distance(vector, e.getVector());
                    if (len <= effectiveDistance) {
                        if (distance == 0) {
                            distance = len;
                            enemyTemp = e;
                        } else {
                            if (len < distance) {
                                enemyTemp = e;
                            }
                        }
                    }
                }

            }
            if (enemyTemp != null)
                enemy = enemyTemp;
        } else {
            if (VectorUtil.distance(vector, enemy.getVector()) > effectiveDistance || !enemy.isAlive()) {
                enemy = null;
            }
        }
    }

    @Override
    public void fire() {
        new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        if (enemy != null && enemy.isAlive()) {
                            Bullet bullet = createBullet();
                            synchronized (Processor.bullets) {
                                Processor.bullets.add(bullet);
                            }
                        }

                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    protected void reset() {
        if (enemy != null) {
            direction = VectorUtil.directionVector(vector, enemy.getVector());
        }
    }

    @Override
    public Vector getVector() {
        return vector;
    }

    protected abstract Bullet createBullet();
}
