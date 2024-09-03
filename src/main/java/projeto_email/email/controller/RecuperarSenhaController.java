package projeto_email.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.mail.MessagingException;
import projeto_email.email.model.Usuario;
import projeto_email.email.service.UsuarioService;

@Controller
@RequestMapping("u")
public class RecuperarSenhaController {

	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/p/redefinir/senha")
	public String pedidoRedefinirSenha() {
		return "usuario/pedido-recuperar-senha";
	}
	
	@GetMapping("/p/recuperar/senha")
	public String redefinirSenha(String email, ModelMap model) throws MessagingException {
		service.pedidoRedefinicaoDeSenha(email);
		model.addAttribute("sucesso", "You will shortly receive an email to " + "proceed with resetting your password.");
		model.addAttribute("usuario", new Usuario(email));
		return "usuario/recuperar-senha";
	}
	
	
	@PostMapping("/p/nova/senha")
	public String confirmacaoDeRedefinicaoDeSenha(Usuario usuario, ModelMap model) {
		Usuario u = service.buscarPorEmail(usuario.getEmail());
		if(!usuario.getCodigoVerificador().equals(u.getCodigoVerificador())) {
			model.addAttribute("falha", "Verifier code does not match.");
			return "usuario/recuperar-senha";
		}
		
		u.setCodigoVerificador(null);
		service.alterarSenha(u, usuario.getSenha());
		model.addAttribute("alerta", "sucesso");
		model.addAttribute("titulo", "Password reset!");
		model.addAttribute("texto", "You can now log into the system.");
		return "login";
	}
}
