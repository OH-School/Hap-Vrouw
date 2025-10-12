package HapVrouw.entities.effectTiles;

import HapVrouw.entities.effectTiles.EffectTiles.SlowTile;
import HapVrouw.entities.effectTiles.EffectTiles.SpeedTile;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

import static javafx.scene.input.KeyCode.R;

public class EffectTileSpawner extends EntitySpawner {

    private int x;
    private int y;

    public EffectTileSpawner(long intervalInMs, int x, int y) {
        super(intervalInMs);
        this.x = x;
        this.y = y;
    }

    @Override
    protected void spawnEntities() {
        int randomEffectTile = new Random().nextInt(10);
        int randomX = new Random().nextInt(1, 18);
        int randomY = new Random().nextInt(1, 15);

        if(randomEffectTile < 5) {
            spawn(new SpeedTile(new Coordinate2D(x * randomX, y * randomY), new Size(16 * 3)));
        } else {
            spawn(new SlowTile(new Coordinate2D(x * randomX, y * randomY), new Size(16 * 3)));
        }

    }
}
