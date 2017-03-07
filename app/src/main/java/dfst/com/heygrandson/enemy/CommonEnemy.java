package dfst.com.heygrandson.enemy;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import dfst.com.heygrandson.basic.App;
import dfst.com.heygrandson.basic.Vector;

/**
 * Created by yanfei on 2016-09-29.
 */
public class CommonEnemy extends BasicEnemy {

    private float radius;

    public CommonEnemy() {
        health = 100;
        currentHealth = health;
        speed = App.UnitLength;
        radius = App.UnitLength * 10;
        vector = new Vector(App.UnitLength * 0, App.UnitLength * 100);
        direction = new Vector(1, 0);
    }

    public void draw(Canvas canvas, Paint paint) {
        if (isAlive()) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLUE);
            canvas.drawCircle(vector.x, vector.y, radius, paint);
            paint.setColor(Color.RED);
            canvas.drawRect(vector.x - radius, vector.y + radius + App.HealthMarginTop, vector.x + radius,
                    vector.y + radius + App.HealthMarginTop + App.HealthHeight, paint);
            paint.setColor(Color.GREEN);
            canvas.drawRect(vector.x - radius, vector.y + radius + App.HealthMarginTop, vector.x - radius + currentHealth * 1.0f / health * radius * 2,
                    vector.y + radius + App.HealthMarginTop + App.HealthHeight, paint);
            move();
        }
    }

    private void move() {
        vector.x += speed * direction.x;
        vector.y += speed * direction.y;
    }

    @Override
    public float getEffectiveDistance() {
        return radius;
    }
}
