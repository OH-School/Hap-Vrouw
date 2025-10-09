package HapVrouw;

import HapVrouw.scenes.GameLevel;
import HapVrouw.scenes.TitleScene;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

/**
 * Hello world!
 *
 */
public class Game extends YaegerGame {
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("HapVrouw");
        setSize(new Size(608, 544));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this));
    }
}
