package com.example.patternrecognition.service;

import com.example.patternrecognition.model.Line;
import com.example.patternrecognition.model.LineResult;
import com.example.patternrecognition.model.LineSegment;
import com.example.patternrecognition.model.Point;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class PatternRecognitionServiceImpl implements PatternRecognitionService {
    private Set<Point> space = new HashSet<>();

    /**
     * Add a point to the space
     * */
    @Override
    public Set<Point> addPoint( Point point ) {
        log.info( "Adding particle to the universe [{}]", point );
        space.add( point );
        return space;
    }

    /**
     * Get all points in the space
     * */
    @Override
    public Set<Point> getSpace() {
        return this.space;
    }

    /**
     * Get all line segments passing through at least N points. Note that a line segment should be a set of
     * points.
     *
     * https://github.com/mincong-h/algorithm-princeton/blob/master/collinear/Point.java
     */
    @Override
    public LineResult getLines( Integer n) {
        LineResult lineResult = new LineResult();

        List<Point> sortedPoints = space.stream().sorted().collect( Collectors.toList() );

        final int N = space.size();

        space.forEach( point -> {
            List<Point> pointsBySlope = space.stream().sorted( point.slopeOrder() ).collect( Collectors.toList() );

            // Notice the difference between "sortedPoints" & "pointsBySlope":
            // the below points are taken from "pointsBySlope".
            int x = 1;
            while (x < N) {
                LinkedList<Point> candidates = new LinkedList<>();
                final double SLOPE_REF = point.slopeTo(pointsBySlope.get(x));
                do {
                    candidates.add(pointsBySlope.get(x++));
                } while (x < N && point.slopeTo(pointsBySlope.get(x) ) == SLOPE_REF);

                // Candidates have a max line segment if ...
                // 1. Candidates are collinear: At least n points are located
                //    at the same line, so at least n-1 without "p".
                // 2. The max line segment is created by the point "p" and the
                //    last point in candidates: so "p" must be the smallest
                //    point having this slope comparing to all candidates.
                if (candidates.size() >= n - 1
                        && point.compareTo(candidates.peek()) < 0) {
                    Point max = candidates.removeLast();
                    lineResult.addLine( lineSegmentToLine( new LineSegment( point, max ) ) );
                    lineResult.addAllPoints( candidates );
                }
            }
        } );

        return lineResult;
    }

    /**
     * https://stackoverflow.com/a/13242831/4349619
     * a = y1-y2,
     * b = x2-x1,
     * c = (x1-x2)*y1 + (y2-y1)*x1
     * */
    private Line lineSegmentToLine( final LineSegment lineSegment) {
        int y1 = lineSegment.getP().getY();
        int y2 = lineSegment.getQ().getY();
        int x1 = lineSegment.getP().getX();
        int x2 = lineSegment.getQ().getX();

        int a = y1 - y2;
        int b = x1 - x2;
        int c = ( x1 - x2 ) * y1 + ( y2 - y1 ) * x1;

        return new Line()
                .setA( a )
                .setB( b )
                .setC( c );

    }

    /**
     * Remove all points from the space
     * */
    @Override
    public void deleteSpace(){
        log.info( "Heat death of the universe, Starting a new simulation!" );
        this.space = new HashSet<>();
    }
}
