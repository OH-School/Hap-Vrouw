package hapVrouw.entities.effectTiles;

import hapVrouw.entities.effectTiles.effectTilesChildren.SlowTile;
import hapVrouw.entities.effectTiles.effectTilesChildren.SpeedTile;
import hapVrouw.entities.tileMap.MuurTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

public class EffectTileSpawner extends EntitySpawner {

    private final int x;
    private final int y;
    private final int[][] mapData;
    private final Random random = new Random();

    public EffectTileSpawner(long intervalInMs, int x, int y, MuurTileMap muurTileMap) {
        super(intervalInMs);
        this.x = x;
        this.y = y;
        this.mapData = muurTileMap.defineMap();
    }

    @Override
    protected void spawnEntities() {
        int randomEffectTile = random.nextInt(10);

        int randomX, randomY;
        do {
            randomX = random.nextInt(1, 18);
            randomY = random.nextInt(1, 15);
        } while (mapData[randomY][randomX] != 0);

        // Spawn de juiste tile
        if (randomEffectTile < 5) {
            spawn(new SpeedTile(new Coordinate2D(x * randomX, y * randomY), new Size(16 * 3)));
        } else {
            spawn(new SlowTile(new Coordinate2D(x * randomX, y * randomY), new Size(16 * 3)));
        }
    }
}
