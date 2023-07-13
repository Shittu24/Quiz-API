package com.shittu24.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shittu24.quiz.question.Quiz;


public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
