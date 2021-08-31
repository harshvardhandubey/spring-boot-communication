package controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
@Controller
@EnableAutoConfiguration
public class HelloWorldController {
	@RequestMapping("/")
	@ResponseBody
	public String sayHello() {
		String ret1, ret2;
		final RestTemplate restTemplate = new RestTemplate();
		ret1 = restTemplate.getForObject("http://localhost:8080", String.class);
		ret2 = restTemplate.getForObject("http://localhost:9090", String.class);
		System.out.println(ret1);
		final String op = ret1+ret2;
		return op;
	}
}
