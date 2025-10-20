package HapVrouw.scenes;

import HapVrouw.Game;
import HapVrouw.entities.effectTiles.EffectTileSpawner;
import HapVrouw.entities.hapVrouw.HapVrouw;
import HapVrouw.entities.tileMap.MuurTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;

public class GameLevel extends DynamicScene implements TileMapContainer, EntitySpawnerContainer {

    private Game game;
    private int x = 48;
    private int y = 45;

    public GameLevel(Game game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    /**
     * 48x45 groot is een tile,  doe x * aantal tiles.
     * begin met bij 0 tellen.
     */
    @Override
    public void setupEntities() {
        HapVrouw hapVrouw = new HapVrouw(new Coordinate2D(getWidth() / 2, getHeight() / 2  + 96));
        addEntity(hapVrouw);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new MuurTileMap());
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new EffectTileSpawner(5, x, y));
    }
}
