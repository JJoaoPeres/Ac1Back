package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso inserir(Curso curso) {
        entityManager.persist(curso);
        return curso;
    }

    @Transactional
    public Curso editar(Curso curso) {
        entityManager.merge(curso);
        return curso;
    }

    @Transactional
    public void excluir(Long id) {
        Curso curso = entityManager.find(Curso.class, id);
        if (curso != null) {
            entityManager.remove(curso);
        }
    }

    public List<Curso> selecionarTodos() {
        return entityManager.createQuery("FROM Curso", Curso.class).getResultList();
    }

    public Curso buscarPorId(Long id) {
        return entityManager.find(Curso.class, id);
    }

    
}
