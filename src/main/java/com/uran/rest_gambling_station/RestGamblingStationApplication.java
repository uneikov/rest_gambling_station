package com.uran.rest_gambling_station;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RestGamblingStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestGamblingStationApplication.class, args);
	}
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    /*@Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        return objectMapper;
    }*/
	
    /*@Bean
    ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder
                .json().dateFormat()
                .featuresToEnable(MapperFeature.DEFAULT_VIEW_INCLUSION)
                .build();
    }*/
}
