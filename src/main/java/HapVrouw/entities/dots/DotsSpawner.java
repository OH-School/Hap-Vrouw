package HapVrouw.entities.dots;

import HapVrouw.entities.dots.dots.SmallDot;
import HapVrouw.entities.tileMap.MuurTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class DotsSpawner extends EntitySpawner {
    private final int tileWidth;
    private final int tileHeight;
    private final int[][] mapData;

    public DotsSpawner(long intervalInMs, int tileWidth, int tileHeight, MuurTileMap muurTileMap) {
        super(intervalInMs);
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.mapData = muurTileMap.defineMap();
        System.out.println("new DotsSpawner");
    }

    @Override
    protected void spawnEntities() {
        // Alleen dots spawnen als er nog geen zijn
        if (Dots.nDots < 1) {
            for (int row = 0; row < mapData.length; row++) {
                for (int col = 0; col < mapData[row].length; col++) {
                    if (mapData[row][col] == 0) { // 0 = lege tegel
                        double x = col * tileWidth;
                        double y = row * tileHeight;
                        spawn(new SmallDot(new Coordinate2D(x, y), new Size(16 * 3)));
                    }
                }
            }
        }
    }
}
