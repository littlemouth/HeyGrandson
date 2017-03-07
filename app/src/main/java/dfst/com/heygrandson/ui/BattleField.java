package dfst.com.heygrandson.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.math.BigDecimal;

import dfst.com.heygrandson.basic.App;
import dfst.com.heygrandson.basic.Vector;
import dfst.com.heygrandson.bullet.Bullet;
import dfst.com.heygrandson.core.Processor;
import dfst.com.heygrandson.defender.CommonDefender;
import dfst.com.heygrandson.defender.Defender;
import dfst.com.heygrandson.enemy.CommonEnemy;
import dfst.com.heygrandson.enemy.Enemy;
import dfst.com.heygrandson.util.DensityUtil;

/**
 * Created by yanfei on 2016-09-27.
 */
public class BattleField extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder holder;
    private DrawThread drawThread;
    private Context context;
    private int width, height;
    private volatile  boolean isDraw;

    public BattleField(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public BattleField(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        holder = getHolder();
        holder.addCallback(this);
    }

    public void play() {
        drawThread = new DrawThread(holder);
        drawThread.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDraw = true;

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDraw = false;
    }

    private class DrawThread extends Thread {

        private SurfaceHolder holder;
        private Paint paint;
        private float x1 = DensityUtil.dip2px(context, 250), y1 = DensityUtil.dip2px(context, 50),
                x2 = DensityUtil.dip2px(context, 50), y2 = DensityUtil.dip2px(context, 50);
        private float speed1 = DensityUtil.dip2px(context, 1), speed2 = DensityUtil.dip2px(context, 1.5f);
        private float radius1 = DensityUtil.dip2px(context, 10), radius2 = DensityUtil.dip2px(context, 4);

        private float bloodMargin = DensityUtil.dip2px(context, 5), bloodHeight = DensityUtil.dip2px(context, 5);

        public DrawThread(SurfaceHolder holder) {
            this.holder = holder;
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(DensityUtil.dip2px(context, 1));
        }

        @Override
        public void run() {
            new Thread() {
                @Override
                public void run() {
                    int i = 0;
                    while (i < 20) {
                        CommonEnemy enemy = new CommonEnemy();
                        synchronized (Processor.enemies) {
                            Processor.enemies.add(enemy);
                        }
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                }
            }.start();
            CommonDefender defender = new CommonDefender(new Vector(App.UnitLength * 100, App.UnitLength * 50));
            Processor.defenders.add(defender);
            CommonDefender defender1 = new CommonDefender(new Vector(App.UnitLength * 220, App.UnitLength * 50));
            Processor.defenders.add(defender1);
            CommonDefender defender2 = new CommonDefender(new Vector(App.UnitLength * 100, App.UnitLength * 150));
            Processor.defenders.add(defender2);
            CommonDefender defender3 = new CommonDefender(new Vector(App.UnitLength * 220, App.UnitLength * 150));
            Processor.defenders.add(defender3);

            //CommonBullet bullet = new CommonBullet(enemy, defender.getVector());
            Canvas canvas = null;
            float speed = 0;
            while (isDraw) {
                try {
                    synchronized (holder) {

                        canvas = holder.lockCanvas();
                        canvas.drawColor(Color.WHITE);

                        //enemy.draw(canvas, paint);
                        synchronized (Processor.enemies) {
                            for (Enemy enemy : Processor.enemies) {
                                enemy.draw(canvas, paint);
                            }
                        }

                        for (Defender d : Processor.defenders) {
                            d.draw(canvas, paint);
                        }
                        //defender.draw(canvas, paint);
                        for (Bullet bullet : Processor.bullets) {
                            bullet.draw(canvas, paint);
                        }

                        /*paint.setColor(Color.GRAY);
                        canvas.drawCircle(DensityUtil.dip2px(context, 50), DensityUtil.dip2px(context, 50), DensityUtil.dip2px(context, 6), paint);
                        float[] f = f(x1, y1, DensityUtil.dip2px(context, 50), DensityUtil.dip2px(context, 50), DensityUtil.dip2px(context, 15));
                        paint.setStrokeWidth(DensityUtil.dip2px(context, 2));
                        canvas.drawLine(DensityUtil.dip2px(context, 50), DensityUtil.dip2px(context, 50), f[0], f[1], paint);

                        paint.setColor(Color.BLUE);
                        canvas.drawCircle(x1, y1, radius1, paint);
                        paint.setColor(Color.GREEN);
                        paint.setStyle(Paint.Style.STROKE);
                        canvas.drawRect(x1 - radius1, y1 + radius1 + bloodMargin, x1 + radius1, y1 + radius1 + bloodMargin + bloodHeight, paint);
                        paint.setStyle(Paint.Style.FILL);
                        canvas.drawRect(x1 - radius1, y1 + radius1 + bloodMargin, x1 + radius1, y1 + radius1 + bloodMargin + bloodHeight, paint);
                        paint.setColor(Color.DKGRAY);
                        canvas.drawCircle(x2, y2, radius2, paint);
                        sleep(10);

                        float angle = angleHorizontal(x1, y1, x2, y2);

                        y1 += speed1;
                        x1 -= 0.5 * speed1;

                        if (x2 > x1) {
                            speed = -speed2;
                        } else if (x1 > x2) {
                            speed = speed2;
                        } else {
                            if (y2 > y1)
                                speed = -speed2;
                            else
                                speed = speed2;
                        }
                        float[] distance2 = distance(speed, angle);
                        x2 += distance2[0];
                        y2 += distance2[1];
                        if (isAttacked(x1, y1, x2, y2, radius1)) {
                            isDraw = false;
                        }*/
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (canvas != null)
                        holder.unlockCanvasAndPost(canvas);
                }
            }
        }

        private float angleHorizontal(float x1, float y1, float x2, float y2) {
            if (x1 == x2) {
                if (y2 > y1)
                    return (float) -Math.PI / 2;
                else
                    return  (float) Math.PI / 2;
            }
            return (float) Math.atan(new BigDecimal(y2 - y1).divide(new BigDecimal(x2 - x1), 5, BigDecimal.ROUND_HALF_UP).doubleValue());
        }

        private float[] distance(float speed, float angle) {
            float[] distance = new float[2];
            distance[0] = speed * (float) Math.cos(angle);
            distance[1] = speed * (float) Math.sin(angle);
            return distance;
        }

        private float[] f(float x1, float y1, float x2, float y2, float len) {
            float f[] = new float[2];
            double angle = Math.atan(new BigDecimal(y2 - y1).divide(new BigDecimal(x2 - x1), 5, BigDecimal.ROUND_HALF_UP).doubleValue());
            f[0] = x2 + len * (float)Math.cos(angle);
            f[1] = y2 + len * (float)Math.sin(angle);
            return f;
        }

        private boolean isAttacked(float x1, float y1, float x2, float y2, float distance) {
            return distance >= Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        }
    }
}
