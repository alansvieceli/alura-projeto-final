package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
@RequestMapping("/pedidos")
public class PedidosServicoController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {

		String uri = "https://book-payment.herokuapp.com/orders";

		// PedidoLista response = restTemplate.getForObject(uri, PedidoLista.class);
		ResponseEntity<List<Pedido>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Pedido>>() {});

		List<Pedido> pedidos = response.getBody();

		ModelAndView modelAndView = new ModelAndView("pedidos/lista");
		modelAndView.addObject("pedidos", pedidos);
		return modelAndView;
	}

}
