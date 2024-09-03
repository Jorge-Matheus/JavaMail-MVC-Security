package projeto_email.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


	
	@GetMapping({"/home", "/"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/info")
	public String info() {
		return "info";
	}
	

	@GetMapping("/login")
	public String loginError() {
		return "login";
	}
	
	// login inválido
		@GetMapping("/login-error")
		public String loginError(ModelMap model) {
			model.addAttribute("error", "E-mail or password invalid or unauthorized user");
			return "login";
		}
	
}
