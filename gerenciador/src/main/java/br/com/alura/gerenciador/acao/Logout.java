package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		//sessao.removeAttribute("usuarioLogado"); pode usar esse tbm, mas ele deixa o objeto na memorio
		sessao.invalidate(); //destroi o cookie
		return "redirect:entrada?acao=LoginForm";
	}

}
