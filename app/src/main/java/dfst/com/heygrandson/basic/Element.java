package dfst.com.heygrandson.basic;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by yanfei on 2016-09-29.
 */
public interface Element {
    Vector getVector();
    void draw(Canvas canvas, Paint paint);
}
