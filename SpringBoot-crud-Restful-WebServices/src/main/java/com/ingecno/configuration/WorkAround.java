package com.ingecno.configuration;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.oas.web.OpenApiTransformationContext;
import springfox.documentation.oas.web.WebMvcOpenApiTransformationFilter;

@Component
public class WorkAround implements WebMvcOpenApiTransformationFilter{

	@Override
	public OpenAPI transform(OpenApiTransformationContext<HttpServletRequest> context) {
	    OpenAPI openApi = context.getSpecification();
        Server localServer = new Server();
        localServer.setDescription("local");
        localServer.setUrl("http://localhost:8089");

        openApi.setServers(Arrays.asList(localServer));
        return openApi;
		
	}

	@Override
	public boolean supports(DocumentationType documentationType) {
		return documentationType.equals(DocumentationType.OAS_30);
	}

}
