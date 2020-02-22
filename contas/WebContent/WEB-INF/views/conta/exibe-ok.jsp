<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <body>
	<h3>Exibir Conta</h3>
	
	Id:<label>${conta.id}</label>
	</br>
	
    Valor:<label title="Valor">${conta.valor}</label>
    </br>
    
    Tipo:<label title="Tipo">${conta.tipo}</label>
    </br>
    
    Data:<label title="Data"><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/></label>
    </br>
    
    Data:<label title="UmaData">${conta.dataPagamento.time}</label>
    </br>

</body>
</html>