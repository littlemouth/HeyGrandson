package dfst.com.heygrandson.bullet;

import dfst.com.heygrandson.basic.Element;

/**
 * Created by yanfei on 2016-09-26.
 */
public interface Bullet extends Element {
    void tryAttact();
    boolean isAttacted();
    boolean isEffective();
}
