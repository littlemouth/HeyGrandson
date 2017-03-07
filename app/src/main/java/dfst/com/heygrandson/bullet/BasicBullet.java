package dfst.com.heygrandson.bullet;

import dfst.com.heygrandson.basic.DrawElement;
import dfst.com.heygrandson.basic.Vector;
import dfst.com.heygrandson.enemy.Enemy;

/**
 * Created by yanfei on 2016-09-29.
 */
public abstract class BasicBullet extends DrawElement implements Bullet {
    protected Enemy enemy;
    protected int damage;
    protected boolean attacted;
    protected float speed;

    @Override
    public boolean isAttacted() {
        return attacted;
    }

    @Override
    public boolean isEffective() {
        return enemy.isAlive();
    }

    @Override
    public void tryAttact() {
        float d = enemy.getEffectiveDistance();
        if (Math.pow(vector.x - enemy.getVector().x, 2) + Math.pow(vector.y - enemy.getVector().y, 2) < d*d) {
            enemy.damage(damage);
            attacted = true;
        }
    }

    @Override
    public Vector getVector() {
        return vector;
    }
}
