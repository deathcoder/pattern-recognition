package com.example.patternrecognition.comparator;

import com.example.patternrecognition.model.Point;

import java.util.Comparator;

public class SlopeComparator implements Comparator<Point> {
    private final Point point;

    public SlopeComparator(Point point) {
        this.point = point;
    }

    @Override
    public int compare(Point p1, Point p2) {
        double slope1 = p1.slopeTo( point );
        double slope2 = p2.slopeTo( point );
        return Double.compare( slope1, slope2 );
    }
}
