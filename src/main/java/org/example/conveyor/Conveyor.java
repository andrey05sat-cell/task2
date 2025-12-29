package org.example.conveyor;

import java.util.Objects;

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
