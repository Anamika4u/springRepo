package Controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerApp {
	
	@GetMapping("/")
	public String main(OAuth2AuthenticationToken token) {
		System.out.println(token.getPrincipal());
		return "secure.html";
	}

}
