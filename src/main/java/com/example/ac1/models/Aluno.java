package com.example.ac1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String anoIngresso;

    @ManyToOne
    private Curso curso;

    public Aluno() {
    }

    public Aluno(Long id, String nome, String anoingresso, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.anoIngresso = anoingresso;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoingresso() {
        return anoIngresso;
    }

    public void setAnoingresso(String anoingresso) {
        this.anoIngresso = anoingresso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", anoingresso=" + anoIngresso + ", curso=" + curso + "]";
    }
}