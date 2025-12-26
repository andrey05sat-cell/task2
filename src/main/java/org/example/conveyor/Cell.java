package org.example.conveyor;

public final class Cell {
    private int value;

    public Cell(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
