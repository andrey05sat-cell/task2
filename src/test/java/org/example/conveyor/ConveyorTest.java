package org.example.conveyor;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConveyorTest {

    @Test
    void push_shifts_lane_and_returns_tail() {
        var topology = new Topology(
                List.of(2, 3, 5),
                List.of(7, 11, 13),
                List.of()
        );
        var conveyor = new Conveyor(topology);

        int outA = conveyor.pushA(17);

        assertEquals(5, outA);
        assertEquals(List.of(17, 2, 3), topology.laneA().snapshot());
        assertEquals(List.of(7, 11, 13), topology.laneB().snapshot());
    }

    @Test
    void intersection_is_shared_cell_between_lanes() {
        var topology = new Topology(
                List.of(2, 3, 5),
                List.of(7, 11, 13),
                List.of(new Intersection(1, 2))
        );
        var conveyor = new Conveyor(topology);

        conveyor.pushA(17);

        assertEquals(List.of(17, 2, 3), topology.laneA().snapshot());

        assertEquals(2, topology.laneB().snapshot().get(2));
    }
}
