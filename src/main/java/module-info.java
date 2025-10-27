module Hap.Vrouw {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;
    requires java.desktop;

    exports HapVrouw;
    exports HapVrouw.entities.tileMap;
    exports HapVrouw.entities.tileMap.dots;

    //opens audio;
    opens backgrounds;
    opens sprites.hapvrouw;
    opens sprites.action;
    opens sprites.ghosts;
    opens sprites.dots;
    exports HapVrouw.entities.buttons;
    exports HapVrouw.scenes;
}