package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Aluno inserir(Aluno aluno) {
        entityManager.persist(aluno);
        return aluno;
    }

    @Transactional
    public Aluno editar(Aluno aluno) {
        entityManager.merge(aluno);
        return aluno;
    }

    @Transactional
    public void excluir(Long id) {
        Aluno aluno = entityManager.find(Aluno.class, id);
        if (aluno != null) {
            entityManager.remove(aluno);
        }
    }

    public List<Aluno> selecionarTodos() {
        return entityManager.createQuery("FROM Aluno", Aluno.class).getResultList();
    }

    public Aluno buscarPorId(Long id) {
        return entityManager.find(Aluno.class, id);
    }
}

