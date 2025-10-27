package hapVrouw.entities.effectTiles;

import hapVrouw.entities.effectTiles.effectTiles.HeartTile;
import hapVrouw.entities.effectTiles.effectTiles.SlowTile;
import hapVrouw.entities.effectTiles.effectTiles.SpeedTile;
import hapVrouw.entities.effectTiles.effectTiles.TimeTile;
import hapVrouw.entities.text.Time;
import hapVrouw.entities.tileMap.MuurTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

public class EffectTileSpawner extends EntitySpawner {

    private final int x;
    private final int y;
    private final int[][] mapData;
    private final Time time;
    private final Random random = new Random();

    public EffectTileSpawner(long intervalInMs, int x, int y, MuurTileMap muurTileMap, Time gameTime) {
        super(intervalInMs);
        this.x = x;
        this.y = y;
        this.mapData = muurTileMap.defineMap();
        this.time = gameTime;
    }

    @Override
    protected void spawnEntities() {
        int randomEffectTile = random.nextInt(100); // 0=Speed, 1=Slow, 2=Time

        int randomX, randomY;
        do {
            randomX = random.nextInt(1, 18);
            randomY = random.nextInt(1, 15);
        } while (mapData[randomY][randomX] != 0);

        if (randomEffectTile == 0) {
            spawn(new SpeedTile(new Coordinate2D(x * randomX, y * randomY), new Size(16 * 3)));
        } else if (randomEffectTile == 1) {
            spawn(new SlowTile(new Coordinate2D(x * randomX, y * randomY), new Size(16 * 3)));
        } else if (randomEffectTile == 2) {
            spawn(new TimeTile(new Coordinate2D(x * randomX, y * randomY), new Size(16 * 3), time));
        } else {
            spawn(new HeartTile(new Coordinate2D(x * randomX, y * randomY), new Size(16 * 3)));
        }
    }
}
