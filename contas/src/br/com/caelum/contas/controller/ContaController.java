package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	
	@RequestMapping("/form")
	public String formulario() { //action do controller
		return "formulario";
	}
	
	@RequestMapping("/adicionaConta") //"/adicionaConta" ==> tem que ser o mesmo nome que esta na action do formulario
	public String adiciona(@Valid Conta conta, BindingResult result) {//action do controller //o Spring atraves do requestMapping verifica o atributo do metodo no caso Conta e pega os valores a partir do atributo "name" e seta no atributo correspondeente da entidade Conta, automaticamente.
		                                        //@Valid ==> faz com que o Spring use as anotaçoes de validacao na entidade Conta
												//BindingResult result ==> parametro do Spring que verifica se ha erros a partir da validacao
		                                        //BindingResult é nesse parâmetro que o Spring nos avisará se houve um erro de validação.
		
		if(result.hasErrors()) {
			return "formulario";
		}
		
		ContaDAO dao = new ContaDAO();
		
		dao.adiciona(conta);
		return "conta/conta-adicionada";
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView lista() {//action do controller
		System.out.println("==================> 1");
		ContaDAO dao = new ContaDAO();
		List<Conta> list = dao.lista();
		ModelAndView mv = new ModelAndView("conta/lista");//acessando a pagina lista.jsp
		mv.addObject("todasContas", list); //associa o nosso objeto list com a chave contas que esta na pagina lista.jsp
		
		return mv;
	}
	
	// OUTRA FORMA DE LISTAR
	//@RequestMapping("/listaContas")
	public String lista(Model mv) {
	  ContaDAO dao = new ContaDAO();
	  List<Conta> contas = dao.lista();
    
	  mv.addAttribute("todasContas", contas);
	  return "conta/lista";
	}
	
	//@RequestMapping("/removeConta")
	//public String remove(Conta conta) {
	//	ContaDAO dao = new ContaDAO();
	//	dao.remove(conta);
	//	return "conta/delecao-ok";
	//}
	
	@RequestMapping("/removeConta")//Veja o href="removeConta?id${cnt.id}"
	public String remove(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.remove(conta);
		
        //Redirecionar para ações já existentes é bem comum, e prático. Nos ajuda a escrever menos código!		
		return "redirect:listaContas"; //2 requisicoes redirecionamento no lado do cliente - o servidor pede ao browser para rediriecionar para "listaContas"
		//return "forward:listaContas";//1 requsicao apenas redirecionamento no lado do servidor
	}
	
	@RequestMapping("/exibeConta")
	public ModelAndView exibe(Conta conta) {
	  ContaDAO dao = new ContaDAO();
	  
	  ModelAndView mv = new ModelAndView("conta/exibe-ok");
	  mv.addObject("conta", dao.buscaPorId(conta.getId()));
	  return mv;
	}
	
	//@RequestMapping("/alteraConta")
	//public String mostra(Long id, Model model) {
	//  ContaDAO dao = new ContaDAO();
	//  model.addAttribute("conta", dao.buscaPorId(id));
	//  return "conta/altera";
	//}
	
	@RequestMapping("/alteraConta")
	public ModelAndView mostra(Conta conta) {
	  ContaDAO dao = new ContaDAO();
	  ModelAndView mv = new ModelAndView("conta/altera");
	  mv.addObject("conta", dao.buscaPorId(conta.getId()));
	  
	  return mv;
	}
	
	@RequestMapping("/atualizaConta")
	public String altera(Conta conta) {
	  ContaDAO dao = new ContaDAO();
	  dao.altera(conta);
	  return "redirect:listaContas";//redirecionamento no lado do cliente (browser) a pedido do servidor
	}
	
	//@RequestMapping("/pagaConta")
	public void paga(Long id, HttpServletResponse response) {
	  System.out.println("==================> 2");
	  ContaDAO dao = new ContaDAO();
	  dao.paga(id);
	  response.setStatus(200);
	}
	
	@RequestMapping(value="/pagaConta")
	public String paga(Conta conta) {
	  System.out.println("==================> 2");
	  ContaDAO dao = new ContaDAO();
	  dao.paga(conta.getId());
	  return "redirect:listaContas";//redirecionamento no lado do cliente (browser) a pedido do servidor
	}
	
	//@RequestMapping("/pagaConta")
	public void paga(Conta conta, HttpServletResponse resp) {
	  System.out.println("==================> 2");
	  ContaDAO dao = new ContaDAO();
	  dao.paga(conta.getId());
	  resp.setStatus(200);
	 // return "redirect:listaContas";//redirecionamento no lado do cliente (browser) a pedido do servidor
	}
	

}
