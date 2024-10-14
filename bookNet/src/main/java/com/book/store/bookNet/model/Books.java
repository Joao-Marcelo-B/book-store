package com.book.store.bookNet.model;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;

    public Books() { }

    public Books(DadosCadastroBook dados) {
        this.nome = dados.nome();
        this.genero = dados.genero();
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Books {" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\''+'}';
    }
}
