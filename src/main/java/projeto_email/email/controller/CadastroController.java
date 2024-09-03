package projeto_email.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.mail.MessagingException;
import projeto_email.email.controller.dto.RegisterDto;
import projeto_email.email.model.PerfilTipo;
import projeto_email.email.model.Usuario;
import projeto_email.email.repositories.PerfilRepository;
import projeto_email.email.service.UsuarioService;

@Controller
public class CadastroController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@GetMapping("/cadastro")
	public String cadastro(Model model) {
		RegisterDto registerDto = new RegisterDto();
		model.addAttribute(registerDto);
		model.addAttribute("success", false);
		return "cadastro";
	}
	
	
	@GetMapping("/cadastro/realizado")
	public String cadastroRealizado() {
		return "mensagem";
	}
	
	@PostMapping("/cadastro")
	public String cadastro(Model model,
			@Validated @ModelAttribute 
			RegisterDto registerDto, 
			BindingResult result) throws MessagingException {

		var perfilUsuario = perfilRepository.findByDesc(PerfilTipo.USUARIO.getDesc())	;
		var emailFromDb = service.buscarPorEmail(registerDto.getEmail());
		
		
		
		if(!registerDto.getPassword().equals(registerDto.getPassword2())) {
			result.addError(new FieldError("registerDto", "password2", "Password do not match"));
		}
		
		if(emailFromDb != null) {
			result.addError(new FieldError("registerDto", "email", "E-mail address is already used"));
		}
		
		if(result.hasErrors()) {
			return "cadastro";
		}
		
		try {
			var crypt = new BCryptPasswordEncoder();
			
			
			var usuario = new Usuario();
			usuario.setEmail(registerDto.getEmail());
			usuario.setSenha(crypt.encode(registerDto.getPassword()));
			usuario.setPerfis(perfilUsuario);
			service.salvarUsuario(usuario);
		}
		catch(DataIntegrityViolationException e) {
			result.addError(new FieldError("registerDto", "email", e.getMessage()));
		}
		
		return "redirect:/cadastro/realizado";
	}
	
	@GetMapping("/confirmacao/cadastro")
	public String respostaConfirmacaoCadastro(@RequestParam("codigo") String codigo
			,RedirectAttributes attr) throws Exception {
		
		service.ativarCadastroPaciente(codigo);
		attr.addFlashAttribute("alerta", "sucesso");
		attr.addFlashAttribute("titulo", "Registration activated!");
		attr.addFlashAttribute("texto", "Congratulations, your registration is active.");
		attr.addFlashAttribute("subtexto", "Follow with your login/password");
		return "redirect:/login";
	}	
}
