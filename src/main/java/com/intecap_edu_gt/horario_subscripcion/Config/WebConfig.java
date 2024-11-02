package com.intecap_edu_gt.horario_subscripcion.Config;

import com.intecap_edu_gt.horario_subscripcion.Interceptor.HorarioAccesoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private HorarioAccesoInterceptor horarioAccesoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(horarioAccesoInterceptor).addPathPatterns("/api/horarios/**");
    }
}