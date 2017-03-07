package dfst.com.heygrandson.util;

import java.util.Random;

import dfst.com.heygrandson.basic.Vector;

/**
 * Created by yanfei on 2016-09-29.
 */
public class VectorUtil {
    public static Vector directionVector(Vector v1, Vector v2) {
        Vector vector = new Vector();
        vector.x = v2.x - v1.x;
        vector.y = v2.y - v1.y;
        float d = (float) Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2));
        vector.x = vector.x / d;
        vector.y = vector.y / d;
        return vector;
    }

    public static Vector stepVector(Vector vector, Vector direction, float increment) {
        vector.x = direction.x * increment;
        vector.y = direction.y * increment;
        return vector;
    }

    public static float distance(Vector v1, Vector v2) {
        return (float) Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2));
    }

    public static Vector randomDirection() {
        Vector vector = new Vector();
        Random random = new Random();
        vector.x = random.nextFloat();
        vector.y = (float) Math.sqrt(1 - Math.pow(vector.x, 2));
        return vector;
    }
}
