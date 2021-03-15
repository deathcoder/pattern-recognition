package com.example.patternrecognition.controller;

import com.example.patternrecognition.model.Line;
import com.example.patternrecognition.model.LineResult;
import com.example.patternrecognition.model.Point;
import com.example.patternrecognition.service.PatternRecognitionService;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Data
@Accessors(chain = true)
@RestController
public class PatternRecognitionController implements PatternRecognitionService {

    private PatternRecognitionService patternRecognitionService;

    @Override
    @PostMapping( "/point" )
    public Set<Point> addPoint( @RequestBody Point point ) {
        return patternRecognitionService.addPoint( point );
    }

    @Override
    @GetMapping("/space")
    public Set<Point> getSpace() {
        return patternRecognitionService.getSpace();
    }

    @Override
    @GetMapping("/lines/{n}")
    public LineResult getLines( @PathVariable Integer n ) {
        return patternRecognitionService.getLines(n);
    }

    @Override
    @DeleteMapping("/space")
    public void deleteSpace() {
        patternRecognitionService.deleteSpace();
    }

}
