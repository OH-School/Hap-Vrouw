package hapVrouw.entities.buttons;

import hapVrouw.Game;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;

public class Button extends TextEntity implements MouseEnterListener, MouseExitListener {

    protected Game game;
    protected Color originalColor;

    public Button(Coordinate2D initialLocation, String text, Game game) {
        super(initialLocation, text);
        this.game = game;
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
        setFill(Color.DARKBLUE);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
        setFill(originalColor);
    }
}
