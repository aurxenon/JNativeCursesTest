package net.aurxenon.JNativeCursesTest;

import net.aurxenon.JNativeCurses.Display.Color;
import net.aurxenon.JNativeCurses.TUI;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        tui.displayObject().displayInit();
        tui.displayObject().clearScreen();
        for (int x = 0; x <= tui.displayObject().getMaxTerminalWidth(); x++) {
            for (int y = 0; y <= tui.displayObject().getMaxTerminalHeight(); y++) {
                Random r = new Random();
                int low = 32;
                int high = 127;
                int result = r.nextInt(high-low) + low;
                tui.displayObject().drawCharacter((char)result, x, y, Color.valueOf(r.nextInt(7)), Color.valueOf(r.nextInt(7)));
            }
        }
        tui.displayObject().finishRender();
        tui.inputObject().inputInit();
        tui.inputObject().enableKeyDelay();
        tui.inputObject().readInput();
        tui.displayObject().exit();
        System.out.println("Test finished successfully");
    }
}