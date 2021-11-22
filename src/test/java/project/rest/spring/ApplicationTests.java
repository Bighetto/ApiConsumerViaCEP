package project.rest.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
class ApplicationTests {

	@Test
	void ConsumerAPI() {
		RestTemplate template = new RestTemplate();

//		viacep.com.br/ws/01001000/json/

		UriComponents uri  = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("viacep.com.br")
				.path("ws/01001000/json")
				.queryParam("fields", "all")
				.build();

		ResponseEntity<ViaCep> entity = template.getForEntity(uri.toUriString(), ViaCep.class);

		System.out.println(entity.getBody().getCep());

	}

}
