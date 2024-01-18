package holdings.indsys.iLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ILabelApplication {

	private static final Logger logger = LoggerFactory.getLogger(ILabelApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ILabelApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
//	@Bean
//	@Profile("!test")
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//			Quote quote = restTemplate.getForObject(
//					"http://localhost:8080/api/random", Quote.class);
//			logger.info(quote.toString());
//		};
//	}
}
