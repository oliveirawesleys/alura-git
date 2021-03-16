package com.testes.automatizados.testesautomatizados;

import java.util.Objects;

public class Lance {
    private Usuario usuario;
    private double valor;

    public Lance(Usuario usuario, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Lance não pode ser menor ou igual a 0!");
        }
        this.usuario = usuario;
        this.valor = valor;
    }


    public Usuario getUsuario() {
        return this.usuario;
    }

    public double getValor() {
        return this.valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lance lance = (Lance) o;
        return Double.compare(lance.valor, valor) == 0 &&
                Objects.equals(usuario, lance.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, valor);
    }
}