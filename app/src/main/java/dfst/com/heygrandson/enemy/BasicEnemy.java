package dfst.com.heygrandson.enemy;

import dfst.com.heygrandson.basic.DrawElement;
import dfst.com.heygrandson.basic.Vector;
import dfst.com.heygrandson.pass.Pass;

/**
 * Created by yanfei on 2016-09-26.
 */
public abstract class BasicEnemy extends DrawElement implements Enemy{
    protected int health;
    protected int currentHealth;
    protected float speed;
    protected double distance;
    protected Pass pass;
    protected int step = 1;

    public BasicEnemy(Pass pass) {
        this.pass = pass;
    }

    @Override
    public boolean isAlive() {
        return currentHealth > 0;
    }

    @Override
    public void damage(int damage) {
        if (isAlive()) {
            currentHealth -= damage;
            if (currentHealth < 0) {
                currentHealth = 0;
            }
        }
    }

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public Vector getVector() {
        return vector;
    }

    public int getStep() {return step;}

    public float getSpeed() {return speed;}

    public void setStep(int step) {this.step = step;}
}
