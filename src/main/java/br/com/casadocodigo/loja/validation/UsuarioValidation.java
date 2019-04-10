package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;

public class UsuarioValidation implements Validator {
	
	private UsuarioDAO usuarioDao;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}
	
	public UsuarioValidation(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;		
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senha", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senharep", null, "Required field");
		

		Usuario usuario = (Usuario) target;
		
		if (usuarioDao.userExists(usuario.getEmail())) {
			errors.rejectValue("email", null, "User already registered");
		}


		if (usuario.getSenha().length() < 5) {
			errors.rejectValue("senha", "senha.length", "Password must be at least 5 characters");
		}

		if (!usuario.getSenha().equals(usuario.getSenharep())) {
			errors.rejectValue("senha", null, "'Repeat password' and 'password' must be the same");
		}

	}

}
