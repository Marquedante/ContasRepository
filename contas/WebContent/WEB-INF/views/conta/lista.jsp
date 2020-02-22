<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Contas</title>


<script src="resources/js/jquery.js"></script> <!-- chamando a biblioteca JQUERY -->

<script type="text/javascript">

	function deuCerto(dadosDaResposta){ 
	//  alert("Conta paga com sucesso!!!");
	}
	
	function pagaAgora(id){
	 // alert("1");
	 //$.get("pagaConta?id="+id);  /* fazendo uma requisicao AJAX */
	 $.get("pagaConta?id="+id, deuCerto);  /* fazendo uma requisicao AJAX */
	 // alert("2");
	 // deuCerto ==> eh uma funcao de callback
	}
	
</script>
</head>

<body>
   <h3>Lista Contas</h3>
   <table>
   		<tr>
   			<th>Codigo</th>
   			<th>Descricao</th>
   			<th>Valor</th>
   			<th>Tipo</th>
   			<th>Paga?</th>
   			<th>Data de Pagamento</th>
   			<th>Ações</th>
   		</tr>
   		
   		<c:forEach items="${todasContas}" var="cnt">
   		 <tr>
   			<td>${cnt.id}</td> <!-- cnt.getId() -->
   			<td>${cnt.descricao}</td>
   			<td>${cnt.valor}</td> <!-- cnt.getValor() -->
   			<td>${cnt.tipo}</td>
   			<td>
   			  <c:if test="${cnt.paga eq false}">Não paga!</c:if>
   			  <c:if test="${cnt.paga eq true}">Paga!</c:if>
   			</td>
   			<td><fmt:formatDate value="${cnt.dataPagamento.time}" pattern="dd/MM/yyyy"/></td>
   			<td>
   			<a href="removeConta?id=${cnt.id}">Deletar</a>
   			<a href="exibeConta?id=${cnt.id}">Exibir</a>
   			<a href="alteraConta?id=${cnt.id}">Alterar</a> | 
   			<a href="pagaConta?id=${cnt.id}">Pagar sem Ajax</a> |
   			<a href="#" onclick="pagaAgora(${cnt.id});">Pagar com Ajax</a>
   			</td>
   		 </tr>
   		</c:forEach>
   		<!-- fmt:formatDate trabalha apenas com Date por isso o time -->
   		
   </table>

</body>
</html>