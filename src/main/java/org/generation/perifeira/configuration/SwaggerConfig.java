package org.generation.perifeira.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
    OpenAPI springBlogPessoalOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("PeriFeira")
                .description("PeriFeira é uma loja online de alimentos orgânicos voltada para comunidades periféricas que prioriza alimentos sazonais e que seriam descartados por não serem considerados 'bonitos', visando oferecer um custo mais acessível aos consumidores.\nNosso objetivo é apoiar pequenos agricultores e promover um estilo de vida saudável e sustentável, e além disso, acessível.")
                .version("v0.0.1")
                .license(new License()
                    .name("PeriFeira")
                    .url("https://github.com/Projeto-Integrador-Generation/projeto-integrador"))
                .contact(new Contact()
                    .name("PeriFeira")
                    .url("https://github.com/Projeto-Integrador-Generation/projeto-integrador")
                    .email("perifeiraprojeto@gmail.com")))
            .externalDocs(new ExternalDocumentation()
                .description("Github")
                .url("https://github.com/Projeto-Integrador-Generation/projeto-integrador"));
    }


	@Bean
	public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

			}));
		};
	}

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}
}