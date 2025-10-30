package hapVrouw.entities.text;

import com.github.hanyaeger.api.Timer;

public class Time extends Timer {


    private TimerDisplay time;
    private int seconden;
    public Time(TimerDisplay timerDisplay, int seconden) {
        super(1000);
        this.time = timerDisplay;
        this.seconden = seconden;
    }

    public Time(int seconden) {
        super(1000);
        this.seconden = seconden;
        this.time = null;
    }

    @Override
    public void onAnimationUpdate(long l) {
        seconden--;
        if (time != null) {
        time.updateTimer(seconden);
        }
    }

    public int getSeconden() {
        return seconden;
    }

    public void setSeconden(int seconden) {
        this.seconden = seconden;
    }

}
