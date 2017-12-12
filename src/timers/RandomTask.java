package timers;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jlombardo
 */
public class RandomTask extends TimerTask {
    private static int n = 0;
    private Timer t;

    public RandomTask(Timer t) {
        this.t = t;
    }

    @Override
    public void run() {
        Random r = new Random((new Date()).getTime());
        System.out.println("Random number " + ++n + ": " + r.nextInt());
        if(n > 4) t.cancel();
    }

}
