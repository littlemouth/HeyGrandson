package dfst.com.heygrandson.util;

import java.util.LinkedList;

/**
 * Created by yanfei on 2016-09-29.
 */
public class MyList<E> extends LinkedList<E> {
    public boolean addOne(E e) {
        boolean result = false;
        synchronized (this) {
            result = super.add(e);
        }
        return result;
    }
}
