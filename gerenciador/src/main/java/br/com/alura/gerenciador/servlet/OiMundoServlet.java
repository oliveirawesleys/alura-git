package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {
	
	public OiMundoServlet() {
		System.out.println("Criando Oi mundo servlet.");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Oi mundo, parabens voce escreveu o primeiro Servlet.");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O Servlet OiMundoServlet foi chamado.");
	}
}
