package HapVrouw.entities.effectTiles;

import HapVrouw.entities.hapVrouw.HapVrouw;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import java.util.Timer;
import java.util.TimerTask;

public abstract class EffectTile extends SpriteEntity implements Collider {

    protected EffectTile(String resource, Coordinate2D initialPosition, Size size) {
        super(resource, initialPosition, size);
        timedDespawn();
    }

    public void timedDespawn() {
        Timer timer = new Timer();

        TimerTask Task = new TimerTask() {
            @Override
            public void run() {
                remove();
                timer.cancel();
            }
        };

        timer.schedule(Task, 5000);
    }

    public abstract void action(HapVrouw hapVrouw);
}
