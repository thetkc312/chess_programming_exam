package chess;

public class Movement {

    private final int vertical;
    private final int horizontal;

    Movement(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    int getVertical() {
        return vertical;
    }

    int getHorizontal() {
        return horizontal;
    }
}
