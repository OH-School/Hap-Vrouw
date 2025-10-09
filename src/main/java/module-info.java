module Hap.Vrouw {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;
    requires java.desktop;

    exports HapVrouw;

    //opens audio;
    opens backgrounds;
    //opens sprites;
    //exports HapVrouw.entities.buttons;
    exports HapVrouw.scenes;
}