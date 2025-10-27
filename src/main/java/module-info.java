module Hap.Vrouw {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;
    requires java.desktop;

    exports hapVrouw;
    exports hapVrouw.entities.tileMap;

    //opens audio;
    opens backgrounds;
    opens sprites.hapvrouw;
    opens sprites.action;
    opens sprites.ghosts;
    opens sprites.dots;
    exports hapVrouw.entities.buttons;
    exports hapVrouw.scenes;
    exports hapVrouw.entities.dots;
    exports hapVrouw.entities.dots.dots;
}