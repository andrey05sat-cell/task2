package org.example.conveyor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var initialA = List.of(2, 3, 5, 7, 11);
        var initialB = List.of(13, 17, 19, 23, 29);

        var intersections = List.of(
                new Intersection(2, 1),
                new Intersection(3, 3)
        );

        var topology = new Topology(initialA, initialB, intersections);
        var conveyor = new Conveyor(topology);

        System.out.println("Initial A = " + topology.laneA().snapshot());
        System.out.println("Initial B = " + topology.laneB().snapshot());

        System.out.println("pushA(31) -> out=" + conveyor.pushA(31));
        System.out.println("After  A = " + topology.laneA().snapshot());
        System.out.println("After  B = " + topology.laneB().snapshot());

        System.out.println("pushB(37) -> out=" + conveyor.pushB(37));
        System.out.println("After2 A = " + topology.laneA().snapshot());
        System.out.println("After2 B = " + topology.laneB().snapshot());
    }
}
