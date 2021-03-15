package com.example.patternrecognition.service;

import com.example.patternrecognition.model.Line;
import com.example.patternrecognition.model.LineResult;
import com.example.patternrecognition.model.Point;

import java.util.Set;

/**
 * Given a set of N feature points in the plane, determine every line that contains N or more of the points, and
 * return all points involved.
 * */
public interface PatternRecognitionService {

    /**
     * Add a point to the space
     * */
    Set<Point> addPoint( Point point );

    /**
     * Get all points in the space
     * */
    Set<Point> getSpace();

    /**
     * Get all line segments passing through at least N points. Note that a line segment should be a set of
     * points.
     */
    LineResult getLines( Integer n);

    /**
     * Remove all points from the space
     * */
    void deleteSpace();
}
