package br.com.casadocodigo.loja.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioDAO usuarioDao;
	
	@Autowired
	RoleDAO roleDao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation(usuarioDao));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {

		List<Usuario> usuarios = usuarioDao.listar();

		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}

	@RequestMapping("/form")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/form");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gravar(MultipartFile sumario, @Valid Usuario usuario, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return form(usuario);
		}

		usuarioDao.gravar(usuario);		

		redirectAttributes.addFlashAttribute("menssagem", "Produto cadastrado com sucesso!");

		return listar();
	}
	
	@RequestMapping("/roles")
	public ModelAndView roles(String email) {
		ModelAndView modelAndView = new ModelAndView("usuarios/roles");
		
		Usuario usuario = usuarioDao.loadUserByUsername(email);
		//List<String> roles = roleDao.list().stream().map(Role::getNome).collect(Collectors.toList());
		List<Role> roles = roleDao.list();

		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}	
	
	@RequestMapping(value="/gravarRoles", method=RequestMethod.POST)
	public ModelAndView gravarRoles(Usuario usuario,
			RedirectAttributes redirectAttributes) {

		Usuario usu = usuarioDao.loadUserByUsername(usuario.getEmail());
		usu.setRoles(usuario.getRoles());
		
		usuarioDao.gravar(usu);

		redirectAttributes.addFlashAttribute("menssagem", "Roles Alteradas com sucesso!");

		return listar();
	}

}
