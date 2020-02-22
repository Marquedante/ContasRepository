<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
    <h3>Alterar Conta</h3>
    <form action="atualizaConta" method="post">
        Descrição: <br/>
        <textarea name="descricao" rows="5" cols="100">${conta.descricao}</textarea>
        <br/>
        Valor: <br/>
        <input type="text" name="valor" value="${conta.valor}" /><br/>
        Tipo: <br/>
        <select name="tipo">
            <option value="ENTRADA" ${conta.tipo=='ENTRADA' ? 'selected' : ''}>Entrada</option>
            <option value="SAIDA" ${conta.tipo=='SAIDA' ? 'selected' : ''}>Saída</option>
        </select>
        <br/>
        Pago? <input type="checkbox" name="paga" ${conta.paga? 'checked' : ''} /><!-- tipo checkbox nao tem value -->
        <br/>
		Data de Pagamento: <input type="text" name="dataPagamento" value="<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy" />" />
        <br/>
        <!-- 
        Data de Pagamento: <input type="text" name="dataPagamento" value="${conta.dataPagamento.time}" />
        <br/>
         -->
        
        <input type="hidden" name="id" value="${conta.id}"/><!-- O id como hidden aqui, eh importante para que consigamos saber qual conta será alterada  -->
        <input type="submit" value="Alterar"/>
    </form>
</body>
</html>