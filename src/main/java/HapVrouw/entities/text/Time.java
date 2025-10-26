package HapVrouw.entities.text;

import com.github.hanyaeger.api.Timer;

public class Time extends Timer {


    private TimerDisplay time;
    private int seconden = 500;
    public Time( TimerDisplay timerDisplay) {
        super(1000);
        this.time = timerDisplay;
    }

    @Override
    public void onAnimationUpdate(long l) {
        seconden--;
        time.updateTimer(seconden);

    }
}
