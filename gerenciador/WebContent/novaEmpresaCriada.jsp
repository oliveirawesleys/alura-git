<%
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println(nomeEmpresa);
%>


<html>
<head>
<body>
	Empresa <%= nomeEmpresa %> cadastrada com sucesso!
</body>
</html>