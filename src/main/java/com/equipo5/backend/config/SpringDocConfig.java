package com.equipo5.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "App PetCare",
                version = "1.0.0",
                description = "Aplicación donde puedes registrarte como Dueño para registrar tus mascotas y crear reservas" +
                        "para dar atención a tus mascotas usando los servicios del cuidador y Cuidador para ofrecer servicios para" +
                        "las mascotas de los dueños."
        )
)
public class SpringDocConfig {
}