package dfst.com.heygrandson.bullet;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import dfst.com.heygrandson.basic.App;
import dfst.com.heygrandson.basic.Vector;
import dfst.com.heygrandson.enemy.Enemy;
import dfst.com.heygrandson.util.VectorUtil;

/**
 * Created by yanfei on 2016-09-29.
 */
public class CommonBullet extends BasicBullet {
    private float radius;
    public CommonBullet(Enemy enemy, Vector vector) {
        this.enemy = enemy;
        this.vector = new Vector(vector.x, vector.y);
        damage = 40;
        speed = App.UnitLength * 3;
        radius = App.UnitLength * 4;
    }

    public void draw(Canvas canvas, Paint paint) {
        if (isEffective() && !isAttacted()) {
            paint.setColor(Color.DKGRAY);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(vector.x, vector.y, radius, paint);
            tryAttact();
            move();
        }
    }

    public void move() {
        direction = VectorUtil.directionVector(vector, enemy.getVector());
        vector.x += speed * direction.x;
        vector.y += speed * direction.y;
    }

}
