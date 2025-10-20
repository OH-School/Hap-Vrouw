package HapVrouw.scenes;

import HapVrouw.Game;
import HapVrouw.entities.effectTiles.EffectTileSpawner;
import HapVrouw.entities.ghosts.GhostOranje;
import HapVrouw.entities.ghosts.GhostPaars;
import HapVrouw.entities.ghosts.GhostRood;
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
        GhostPaars ghostPaars = new GhostPaars(new Coordinate2D(getWidth() / 2 , getHeight() / 2 -40 ));
        addEntity(ghostPaars);
        GhostRood ghostrood = new GhostRood(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostrood);
        GhostOranje ghostOranje = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostOranje);
        GhostOranje ghostOranj = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostOranj);
        GhostOranje ghostOran = new GhostOranje(new Coordinate2D(getWidth() / 2 -20 , getHeight() / 2 -40 ));
        addEntity(ghostOran);
        GhostOranje ghostOra = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostOra);
        GhostOranje ghostOr = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostOr);
        GhostOranje ghostOrss = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostOrss);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new MuurTileMap());
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new EffectTileSpawner(50000, x, y));
    }
}
