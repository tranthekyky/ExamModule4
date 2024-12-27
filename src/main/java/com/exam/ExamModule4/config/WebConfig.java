package com.exam.ExamModule4.config;

import com.exam.ExamModule4.converter.StringToLocalDateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        StringToLocalDateConverter stringToLocalDateConverter = new
                StringToLocalDateConverter("dd/MM/yyyy");
        registry.addConverter(stringToLocalDateConverter);
    }

}

