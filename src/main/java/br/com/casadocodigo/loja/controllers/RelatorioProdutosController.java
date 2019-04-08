package br.com.casadocodigo.loja.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.RelatorioProdutos;

@Controller
@RequestMapping("/relatorio-produtos")
public class RelatorioProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public RelatorioProdutos relatorio(@RequestParam(value="data", required=false) String data) throws ParseException {
		RelatorioProdutos relatorioProdutos = new RelatorioProdutos();

		List<Produto> lista = null;

		if ((data == null) || (data.isEmpty())) {
			lista = produtoDAO.listar();
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(data));
			lista = produtoDAO.listarPorData(c);
		}

		relatorioProdutos.setDataGeracao(Calendar.getInstance());
		relatorioProdutos.setQuantidade(lista.size());
		relatorioProdutos.setProdutos(lista);

		return relatorioProdutos;
	}
	
	

}
