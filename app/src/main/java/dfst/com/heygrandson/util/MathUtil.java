package dfst.com.heygrandson.util;

/**
 * Created by yanfei on 2016-09-29.
 */
public class MathUtil {
    public static float distatnce(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
