<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Cadastro Usuários</h1>

<form action="UsuarioServlet" method="post">
	Nome: <input type="text" name="nome"/><br/>
	E-mail: <input type="text" name="email"/><br/>
	Senha: <input type="password" name="senha"/><br/>
	Confirmar senha: <input type="password" name="senha2"/><br/>
	<input type="submit" name="criar" value="cadastrar"/>
	<input type="submit" name="pesquisar" value="pesquisar"/>
	<input type="submit" name="deletar" value="deletar"/>
</form>
		${mensagem}
</body>
</html>