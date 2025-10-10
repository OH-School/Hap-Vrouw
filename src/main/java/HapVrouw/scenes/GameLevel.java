package HapVrouw.scenes;

import HapVrouw.Game;
import HapVrouw.entities.effectTiles.EffectTile;
import HapVrouw.entities.effectTiles.EffectTiles.SlowTile;
import HapVrouw.entities.effectTiles.EffectTiles.SpeedTile;
import HapVrouw.entities.hapVrouw.HapVrouw;
import HapVrouw.entities.tileMap.MuurTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;

public class GameLevel extends DynamicScene implements TileMapContainer {

    private Game game;

    public GameLevel(Game game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        HapVrouw hapVrouw = new HapVrouw(new Coordinate2D(getWidth() / 2, getHeight() / 2  + 96));
        addEntity(hapVrouw);
        EffectTile speed = new SpeedTile(new Coordinate2D(64, 64), new Size(48));
        addEntity(speed);
        EffectTile slow = new SlowTile(new Coordinate2D(126, 128), new Size(48));
        addEntity(slow);

    }

    @Override
    public void setupTileMaps() {
        addTileMap(new MuurTileMap());
    }
}
