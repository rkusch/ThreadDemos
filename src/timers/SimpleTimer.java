package timers;

import java.util.Timer;

/**
 *
 * @author jlombardo
 */
public class SimpleTimer {
    private static final long DELAY = 100;
    private static final long PERIOD = 2000;

    public static void main(String[] args) {
        Timer t = new Timer("DemoTimer");
        RandomTask rt = new RandomTask(t);
        t.schedule(rt, DELAY, PERIOD);
    }
}
