package dfst.com.heygrandson.defender;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import dfst.com.heygrandson.basic.App;
import dfst.com.heygrandson.basic.Vector;
import dfst.com.heygrandson.bullet.Bullet;
import dfst.com.heygrandson.bullet.CommonBullet;

/**
 * Created by yanfei on 2016-09-29.
 */
public class CommonDefender extends BasicDefender {

    private float radius;
    private float gunLen;

    public CommonDefender(Vector vector) {
        this.vector = vector;
        radius = App.UnitLength * 6;
        gunLen = App.UnitLength * 15;
        effectiveDistance = App.UnitLength * 100;
        fire();
    }

    @Override
    protected Bullet createBullet() {
        return new CommonBullet(enemy, vector);
    }

    public void draw(Canvas canvas, Paint paint) {
        captureEnemy();
        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(vector.x, vector.y, radius, paint);
        paint.setStrokeWidth(App.UnitLength * 3);
        canvas.drawLine(vector.x, vector.y, vector.x + gunLen * direction.x, vector.y + gunLen * direction.y, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(Color.GRAY);
        //canvas.drawCircle(vector.x, vector.y, effectiveDistance, paint);
        reset();
    }
}
