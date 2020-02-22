package br.com.caelum.contas.modelo;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Conta {
	
	private Long id;

	@NotNull(message="{conta.formulario.descricao.obrigatoria}")//Validacao do BeanValidation
	//@Size(min=5, message="A descricao deve ter no minimo 5 caracteres.")
	@Size(min=5, max=500, message="{conta.formulario.descricao.tamanho}")
	private String descricao;

	
	private boolean paga;
	
	private double valor;

	@DateTimeFormat(pattern="dd/MM/yyyy")//Para o Spring MVC saber converter automaticamente a data no formato brasileiro para um Calendar é preciso usar a anotação @DateTimeFormat. 
	private Calendar dataPagamento;
	
	@NotNull(message="{conta.formulario.tipo.obrigatoria}")//Validacao do BeanValidation
	//@NotBlank(message="{conta.formulario.descricao.obrigatoria}")//Hibernate Validation
	private TipoDaConta tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public TipoDaConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoDaConta tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}	
	
	public void setValor(double valor) {
		this.valor = valor;
	}

}
