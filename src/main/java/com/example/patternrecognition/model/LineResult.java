package com.example.patternrecognition.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Accessors(chain = true)
public class LineResult {
    /**
     * every line that contains n or more points as determined by the PatternRecognitionService
     * */
    public Set<Line> lines = new HashSet<>();

    /**
     * every point involved
     * */
    public Set<Point> points = new HashSet<>();

    public LineResult addLine( Line line ) {
        this.lines.add( line );
        return this;
    }

    public LineResult addPoint( Point point ) {
        this.points.add( point );
        return this;
    }

    public LineResult addAllPoints( List<Point> points ) {
        this.points.addAll( points );
        return this;
    }
}
