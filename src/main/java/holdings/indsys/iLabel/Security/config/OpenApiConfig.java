package holdings.indsys.iLabel.Security.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
// import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Sainmarks",
                        email = "karan@indsys.holdings",
                        url = "https://sainmarks.com/"
                ),
                description = "OpenApi documentation for iLabel Live",
                title = "OpenApi specification - iLabel",
                version = "1.0",
//                license = @License(
//                        name = "Licence name",
//                        url = "https://some-url.com"
//                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local",
                        url = "http://localhost:9000"
                ),
                @Server(
                        description = "Testing",
                        url = "http://13.235.164.82:9000"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
