package dfst.com.heygrandson.enemy;

import dfst.com.heygrandson.basic.Element;

/**
 * Created by yanfei on 2016-09-26.
 */
public interface Enemy extends Element {
    void damage(int damage);
    boolean isAlive();
    float getEffectiveDistance();
    double getDistance();
    void move();
    int getStep();
    void setStep(int step);
    float getSpeed();
}
