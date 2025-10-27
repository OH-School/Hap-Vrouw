package hapVrouw.entities.buttons.startbutton;

import hapVrouw.Game;
import hapVrouw.entities.buttons.Button;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class StartButton extends Button implements MouseButtonPressedListener {

    public StartButton(Coordinate2D initialLocation, String text, Game game) {
        super(initialLocation, text, game);
        this.originalColor = Color.GREEN;
        setFill(originalColor);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        game.setActiveScene(1);
    }
}
