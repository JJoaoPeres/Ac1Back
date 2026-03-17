package com.example.ac1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.Curso;
import com.example.ac1.repositories.CursoRepository;


@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/cursos")
    public List<Curso> mostrarTodos() {
        return cursoRepository.selecionarTodos();
    }

    @PostMapping
    public Curso inserir(@RequestBody Curso curso) {
        return cursoRepository.inserir(curso);
    }
}
