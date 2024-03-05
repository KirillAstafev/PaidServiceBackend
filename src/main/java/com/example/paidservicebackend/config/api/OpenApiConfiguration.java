package com.example.paidservicebackend.config.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Платные услуги",
                description = "API сервиса для управления платными услугами мед.клиники"
        )
)
public class OpenApiConfiguration {
}
