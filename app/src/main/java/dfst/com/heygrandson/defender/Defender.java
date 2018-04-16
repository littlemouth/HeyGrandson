package dfst.com.heygrandson.defender;

import dfst.com.heygrandson.basic.Element;

/**
 * Created by yanfei on 2016-09-29.
 */
public interface Defender extends Element{
    void captureEnemy();
    void fire();
    float getEffectiveDistance();
}
