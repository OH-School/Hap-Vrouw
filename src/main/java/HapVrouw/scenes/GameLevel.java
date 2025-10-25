package HapVrouw.scenes;

import HapVrouw.Game;
import HapVrouw.entities.Text.*;
import HapVrouw.entities.effectTiles.EffectTileSpawner;
import HapVrouw.entities.ghosts.GhostOranje;
import HapVrouw.entities.ghosts.GhostPaars;
import HapVrouw.entities.ghosts.GhostRood;
import HapVrouw.entities.ghosts.Ghosts;
import HapVrouw.entities.hapVrouw.HapVrouw;
import HapVrouw.entities.tileMap.MuurTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;

public class GameLevel extends DynamicScene implements TileMapContainer, EntitySpawnerContainer, TimerContainer {

    private Game game;
    private TimerDisplay timerDisplay;
    private int x = 48;
    private int y = 45;
    private MuurTileMap muurTileMap;

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
        Ghosts ghostPaars = new GhostPaars(new Coordinate2D(getWidth() / 2 , getHeight() / 2 -40 ));
        addEntity(ghostPaars);
        Ghosts ghostrood = new GhostRood(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostrood);
        Ghosts ghostOranje = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostOranje);
//        Ghosts ghostOranj = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
//        addEntity(ghostOranj);
//        Ghosts ghostOran = new GhostOranje(new Coordinate2D(getWidth() / 2 -20 , getHeight() / 2 -40 ));
//        addEntity(ghostOran);
//        Ghosts ghostOra = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
//        addEntity(ghostOra);
//        Ghosts ghostOr = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
//        addEntity(ghostOr);
//        Ghosts ghostOrss = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
//        addEntity(ghostOrss);
        ScoreText score = new ScoreText(new Coordinate2D(404,5));
        addEntity(score);
        HealthText health = new HealthText(new Coordinate2D(100,5));
        addEntity(health);
        timerDisplay = new TimerDisplay(new Coordinate2D(708, 5));
        addEntity(timerDisplay);
        HapVrouw hapVrouw = new HapVrouw(new Coordinate2D(getWidth() / 2, getHeight() / 2  + 110), health, score);
        addEntity(hapVrouw);
    }

    @Override
    public void setupTileMaps() {
        muurTileMap = new MuurTileMap();
        addTileMap(muurTileMap);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new EffectTileSpawner(5000, x, y, muurTileMap));
    }

    @Override
    public void setupTimers() {
        addTimer(new Time(timerDisplay));
    }
}
