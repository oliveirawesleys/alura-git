package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/shopping-cart")
public class Aula2Atividade3 extends HttpServlet {
	
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String productId = req.getParameter("productId");
		String discount = req.getParameter("discount");
		PrintWriter out = res.getWriter();
		out.println("<html><body> O ID do produto e " + productId + " e o desconto foi " + discount + " </body></html>");
	}

}
