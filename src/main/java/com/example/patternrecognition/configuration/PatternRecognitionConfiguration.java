package com.example.patternrecognition.configuration;

import com.example.patternrecognition.controller.PatternRecognitionController;
import com.example.patternrecognition.service.PatternRecognitionService;
import com.example.patternrecognition.service.PatternRecognitionServiceImpl;
import org.springframework.context.annotation.Bean;

public class PatternRecognitionConfiguration {

    @Bean
    public PatternRecognitionController patternRecognitionController( PatternRecognitionService patternRecognitionService ) {
        return new PatternRecognitionController()
                .setPatternRecognitionService( patternRecognitionService );
    }

    @Bean
    public PatternRecognitionService patternRecognitionService() {
        return new PatternRecognitionServiceImpl();
    }
}
