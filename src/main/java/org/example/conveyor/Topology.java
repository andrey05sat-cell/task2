package org.example.conveyor;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class Topology {
    private final Lane laneA;
    private final Lane laneB;

    public Topology(List<Integer> initialA,
                    List<Integer> initialB,
                    List<Intersection> intersections) {

        Objects.requireNonNull(initialA, "initialA");
        Objects.requireNonNull(initialB, "initialB");
        Objects.requireNonNull(intersections, "intersections");

        if (initialA.isEmpty() || initialB.isEmpty()) {
            throw new IllegalArgumentException("Initial lanes must not be empty");
        }

        Cell[] a = initialA.stream().map(Cell::new).toArray(Cell[]::new);
        Cell[] b = initialB.stream().map(Cell::new).toArray(Cell[]::new);

        Set<String> used = new HashSet<>();

        for (Intersection it : intersections) {
            int ia = it.indexA();
            int ib = it.indexB();

            if (ia < 0 || ia >= a.length || ib < 0 || ib >= b.length) {
                throw new IllegalArgumentException("Intersection out of range: " + it);
            }

            String keyA = "A:" + ia;
            String keyB = "B:" + ib;
            if (!used.add(keyA) || !used.add(keyB)) {
                throw new IllegalArgumentException("Intersection endpoint reused: " + it);
            }

            b[ib] = a[ia];
        }

        this.laneA = new Lane(List.of(a));
        this.laneB = new Lane(List.of(b));
    }

    public Lane laneA() {
        return laneA;
    }

    public Lane laneB() {
        return laneB;
    }
}
