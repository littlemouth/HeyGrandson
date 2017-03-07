package dfst.com.heygrandson.core;

import android.graphics.Paint;
import android.view.SurfaceHolder;

import dfst.com.heygrandson.defender.Defender;

/**
 * Created by yanfei on 2016-09-29.
 */
public class DrawThread extends Thread {
    private SurfaceHolder holder;
    private Paint paint;

    public DrawThread(SurfaceHolder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {

    }

    private void drawDefender(Defender defender) {}
}
