package org.example.conveyor;

/**
 * intersection: A[indexA] and B[indexB] refer to the same physical Cell.
 */
public record Intersection(int indexA, int indexB) {}
