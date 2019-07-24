package main;

public enum  Direction {
    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');

    private int value;
    private char shortNam;

    private Direction(int newValue, char shortNameValue) {
        value = newValue;
        shortNam = shortNameValue;
    }

    public int getValue() {
        return value;
    }

    public char getShortNam() {
        return shortNam;
    }

    public Direction getBackwardDirection() {
        return values()[(this.getValue() + 2) % 4];
    }
}
