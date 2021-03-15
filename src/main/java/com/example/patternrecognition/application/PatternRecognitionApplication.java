package com.example.patternrecognition.application;

import com.example.patternrecognition.configuration.PatternRecognitionConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import( PatternRecognitionConfiguration.class )
public class PatternRecognitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternRecognitionApplication.class, args);
	}

}
