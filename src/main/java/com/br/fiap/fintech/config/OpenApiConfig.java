package com.br.fiap.fintech.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Fintech API")
                        .version("1.0")
                        .description("API RESTful para controle e gerenciamento financeiro pessoal.")
                        .contact(new Contact()
                                .name("Gustavo Moura")));
    }
}