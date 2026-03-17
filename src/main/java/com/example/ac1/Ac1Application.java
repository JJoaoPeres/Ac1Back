package com.example.ac1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Aluno;
import com.example.ac1.models.Curso;
import com.example.ac1.repositories.AlunoRepository;
import com.example.ac1.repositories.CursoRepository;

@SpringBootApplication
public class Ac1Application {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Bean
    public CommandLineRunner init() {
        return args -> {

            Curso c1 = cursoRepository.inserir(
                new Curso(null, "Engenharia da Computação"));
            Curso c2 = cursoRepository.inserir(
                new Curso(null, "Medicina"));

            alunoRepository.inserir(new Aluno(null, "Ana", "2022", c1));
            alunoRepository.inserir(new Aluno(null, "Carlos", "2021", c2));

            cursoRepository.selecionarTodos().forEach(System.out::println);
            alunoRepository.selecionarTodos().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Ac1Application.class, args);
    }
}
