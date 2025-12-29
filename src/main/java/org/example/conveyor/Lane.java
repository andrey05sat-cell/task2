package org.example.conveyor;

import java.util.List;
import java.util.Objects;

public final class Lane {
    private final List<Cell> cells; // head = 0, tail = size-1

    public Lane(List<Cell> cells) {
        Objects.requireNonNull(cells, "cells");
        if (cells.isEmpty()) {
            throw new IllegalArgumentException("Lane must not be empty");
        }
        this.cells = List.copyOf(cells);
    }

    public int push(int incoming) {
        int last = cells.size() - 1;
        int out = cells.get(last).get();

        for (int i = last; i > 0; i--) {
            cells.get(i).set(cells.get(i - 1).get());
        }
        cells.get(0).set(incoming);

        return out;
    }

    public List<Integer> snapshot() {
        return cells.stream().map(Cell::get).toList();
    }

    List<Cell> rawCells() {
        return cells;
    }
}
