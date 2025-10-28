package hapVrouw.entities.text;

import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.Coordinate2D;
import hapVrouw.Game;
import hapVrouw.entities.dots.Dots;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TimerDisplay extends DynamicTextEntity {

    Game game;

    public TimerDisplay(Coordinate2D initialLocation, Game game) {
        super(initialLocation);
        this.game = game;
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.RED);
    }

    public void updateTimer(int seconds) {
        setText("Timer: " + seconds);
        if (seconds <= 0) {
            game.setActiveScene(2);
        }
    }
}