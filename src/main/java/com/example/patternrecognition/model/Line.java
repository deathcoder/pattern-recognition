package com.example.patternrecognition.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * two-dimension representation in the standard form.:
 *   ax + by - c = 0
 * */
@Data
@Accessors(chain = true)
public class Line {
    private int a;
    private int b;
    private int c;

    public String toStandardForm() {
        return String.format( "%sx + %sy - %s = 0", a, b, c );
    }
}
