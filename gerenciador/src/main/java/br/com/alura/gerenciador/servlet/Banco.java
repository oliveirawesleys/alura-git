package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("PizzaHut");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("PizzaPan");
		lista.add(empresa1);
		lista.add(empresa2);

	}
	
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}

	public static List<Empresa> getLista() {
		return Banco.lista;
	}
}
