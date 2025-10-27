package HapVrouw.entities.tileMap;

import com.github.hanyaeger.api.scenes.TileMap;

public class MuurTileMap extends TileMap {
    @Override
    public void setupEntities() {
        addEntity(1, Muur.class, "Sprites/tiles/1MuurHorizontal.png");
        addEntity(2, Muur.class, "Sprites/tiles/2MuurVertical.png");
        addEntity(3, Muur.class, "Sprites/tiles/3MuurLeftDown.png");
        addEntity(4, Muur.class, "Sprites/tiles/4MuurLeftUp.png");
        addEntity(5, Muur.class, "Sprites/tiles/5MuurRightDown.png");
        addEntity(6, Muur.class, "Sprites/tiles/6MuurRightUp.png");
        addEntity(7, Muur.class, "Sprites/tiles/7MuurLRU.png");
        addEntity(8, Muur.class, "Sprites/tiles/8MuurRUD.png");
        addEntity(9, Muur.class, "Sprites/tiles/9MuurLRD.png");
        addEntity(10, Muur.class, "Sprites/tiles/10MuurLUD.png");
        addEntity(11, Muur.class, "Sprites/tiles/11MuurU.png");
        addEntity(12, Muur.class, "Sprites/tiles/12MuurD.png");
    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
                {  4,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  6 },
                {  2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  2 },
                {  2, 0,  4,  1,  8, 0, 10,  1,  8, 0, 10,  1,  8, 0, 10,  1,  6, 0,  2 },
                {  2, 0,  2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  2, 0,  2 },
                {  2, 0,  9, 0, 10,  1,  8, 0, 10,  1,  8, 0, 10,  1,  8, 0,  9, 0,  2 },
                {  2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  2 },
                {  5, 0, 10,  1,  8, 0, 10,  6,  0,  0,  0,  4,  8, 0, 10,  1,  8, 0,  3 },
                { 0, 0, 0, 0, 0, 0, 0,  2,  0,  0,  0,  2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0,  2,  0,  0,  0,  2, 0, 0, 0, 0, 0, 0, 0 },
                {  6, 0, 10,  1,  8, 0, 10, 12,  1,  1,  1, 12,  8, 0, 10,  1,  8, 0,  4 },
                {  2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  2 },
                {  2, 0,  7, 0, 10,  1,  8, 0, 10,  1,  8, 0, 10,  1,  8, 0,  7, 0,  2 },
                {  2, 0,  2, 0, 0, 0, 0, 0,  0,  0,  0, 0, 0, 0, 0, 0,  2, 0,  2 },
                {  2, 0,  3,  1,  8, 0, 10,  1,  8, 0, 10,  1,  8, 0, 10,  1,  5, 0,  2 },
                {  2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  2 },
                {  3,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  5 }
        };

    }
}
