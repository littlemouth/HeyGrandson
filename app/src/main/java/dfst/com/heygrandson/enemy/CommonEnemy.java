package dfst.com.heygrandson.enemy;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

import dfst.com.heygrandson.basic.App;
import dfst.com.heygrandson.basic.Vector;
import dfst.com.heygrandson.pass.Pass;

/**
 * Created by yanfei on 2016-09-29.
 */
public class CommonEnemy extends BasicEnemy {

    private float radius;
    private Random random = new Random();

    public CommonEnemy(Pass pass) {
        super(pass);
        health = 80 + random.nextInt(100);
        currentHealth = health;
        speed = App.UnitLength;
        radius = App.UnitLength * 8;
        vector = new Vector(App.UnitLength * 0, App.UnitLength * 150);
        refreshDirection(1, 0);
        pass.nextPosition(this);
    }

    public void draw(Canvas canvas, Paint paint) {
        if (isAlive()) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLUE);
            canvas.drawCircle(vector.x, vector.y, radius, paint);
            paint.setColor(Color.RED);
            canvas.drawRect(vector.x - radius, vector.y - radius - App.HealthMarginTop - App.HealthHeight, vector.x + radius,
                    vector.y - radius - App.HealthMarginTop, paint);
            paint.setColor(Color.GREEN);
            canvas.drawRect(vector.x - radius, vector.y - radius - App.HealthMarginTop - App.HealthHeight, vector.x - radius + currentHealth * 1.0f / health * radius * 2,
                    vector.y - radius - App.HealthMarginTop, paint);
            move();
        }
    }

    @Override
    public void move() {
        pass.nextPosition(this);
    }

    @Override
    public float getEffectiveDistance() {
        return radius;
    }
}
