package hapVrouw.entities.dots;

import hapVrouw.entities.dots.dots.BigDot;
import hapVrouw.entities.dots.dots.SmallDot;
import hapVrouw.entities.tileMap.MuurTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class DotsSpawner extends EntitySpawner {
    private final int tileWidth;
    private final int tileHeight;
    private final int[][] mapData;

    public DotsSpawner(long intervalInMs, int tileWidth, int tileHeight, MuurTileMap muurTileMap) {
        super(intervalInMs);
        Dots.nDots = 0;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.mapData = muurTileMap.defineMap();
        System.out.println("new DotsSpawner");
    }

    @Override
    protected void spawnEntities() {
        // Alleen dots spawnen als er nog geen zijn
        if (Dots.nDots < 0) {
            for (int row = 0; row < mapData.length; row++) {
                for (int col = 0; col < mapData[row].length; col++) {
                    if (mapData[row][col] == 0) {
                        int x = col * tileWidth;
                        int y = row * tileHeight;
                        if ((x == 48 && y ==45) || (x == 816 && y == 45) || (x == 816 && y == 630) || (x == 48 && y == 630)) {
                            spawn(new BigDot(new Coordinate2D(x, y), new Size(16 * 3)));
                        }
                        else {
                            spawn(new SmallDot(new Coordinate2D(x, y), new Size(16 * 3)));
                            System.out.println((x + " " + y));
                        }

                    }
                }
            }
        }
    }
}
