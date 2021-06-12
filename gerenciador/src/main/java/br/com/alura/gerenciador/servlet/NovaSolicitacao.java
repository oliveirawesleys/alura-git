package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
