package com.example.patternrecognition.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class LineSegment {
    /**
     * one endpoint of this line segment
     * */
    private Point p;

    /**
     * the other endpoint of this line segment
     * */
    private Point q;


}
