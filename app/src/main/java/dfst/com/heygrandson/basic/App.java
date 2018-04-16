package dfst.com.heygrandson.basic;

import android.app.Application;

import dfst.com.heygrandson.util.DensityUtil;

/**
 * Created by yanfei on 2016-09-29.
 */
public class App extends Application {
    public static float UnitLength;
    public static float HealthMarginTop;
    public static float HealthWidth, HealthHeight;
    @Override
    public void onCreate() {
        super.onCreate();
        UnitLength = DensityUtil.dip2px(this, 1);
        HealthMarginTop = UnitLength * 2.5f;
        HealthHeight = UnitLength * 4;
    }
}
