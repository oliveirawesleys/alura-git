package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaSolicitacao
 */
@WebServlet("/novaSolicitacao")
public class NovaSolicitacao extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String nome = req.getParameter("nome");
		PrintWriter writer = res.getWriter();
		writer.println("Empresa do " + nome + " cadastrada com sucesso!");
	}


}
