package org.example.conveyor;

import java.util.Objects;

/**
 * Public API required by the task: push into A or B, return ejected value.
 * Not thread-safe by default (simple single-thread model).
 */
public final class Conveyor {
    private final Lane a;
    private final Lane b;

    public Conveyor(Topology topology) {
        Objects.requireNonNull(topology, "topology");
        this.a = topology.laneA();
        this.b = topology.laneB();
    }

    public int pushA(int prime) {
        return a.push(prime);
    }

    public int pushB(int prime) {
        return b.push(prime);
    }
}
