package dfst.com.heygrandson.basic;

import dfst.com.heygrandson.util.VectorUtil;

/**
 * Created by yanfei on 2016-09-29.
 */
public class DrawElement {
    protected Vector vector;
    protected Vector direction = VectorUtil.randomDirection();

    public void refreshDirection(float x, float y) {
        direction.x = x;
        direction.y = y;
    }

    public Vector getDirection() {
        return  direction;
    }
}
