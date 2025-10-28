package hapVrouw.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Size;
import hapVrouw.Game;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Button extends TextEntity implements MouseEnterListener, MouseExitListener {

    protected Game game;
    protected Color originalColor;

    public Button(Coordinate2D initialLocation, String text, Game game) {
        super(initialLocation, text);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
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
