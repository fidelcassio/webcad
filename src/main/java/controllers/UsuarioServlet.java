package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String confSenha = request.getParameter("senha2");
		String criar = request.getParameter("criar");
		String deletar = request.getParameter("deletar");
		String buscar = request.getParameter("buscar");
		
		if ( nome != null && !nome.isEmpty() && email != null && !email.isEmpty() && senha != null && !senha.isEmpty() &&  confSenha != null && !confSenha.isEmpty()){
			Usuario user= new Usuario(nome, email, senha);
			String msg ="";
			if(criar!=null && !criar.isEmpty()){
				UsuarioDAO dao = new UsuarioDAO();
				dao.insertUsuario(user);
				msg+= "Usuário inserido com sucesso!";
			}
			else if(deletar!=null && !deletar.isEmpty()){
				UsuarioDAO dao = new UsuarioDAO();
				dao.deleteUsuario(user);
				msg+= "Usuário deletado com sucesso!";
			}
			else if(buscar!=null && !buscar.isEmpty()){
				UsuarioDAO dao = new UsuarioDAO();
				dao.buscaUsuario(email);
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("mensagem", msg);
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("mensagem", "Deu erro!");
			rd.forward(request, response);
		}
	
	}

}
