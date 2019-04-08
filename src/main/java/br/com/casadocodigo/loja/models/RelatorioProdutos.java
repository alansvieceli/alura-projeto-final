package br.com.casadocodigo.loja.models;

import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class RelatorioProdutos {

	@DateTimeFormat
	private Calendar dataGeracao;
	private Integer quantidade;
	List<Produto> produtos;

	public Calendar getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Calendar dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
