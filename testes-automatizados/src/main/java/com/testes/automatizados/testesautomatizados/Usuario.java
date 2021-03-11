package com.testes.automatizados.testesautomatizados;

import java.util.Objects;

public class Usuario {
    private int id;
    private String nome;

    public Usuario(String nome) {
        this(0, nome);
    }

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                nome.equals(usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}