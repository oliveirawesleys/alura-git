package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

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
