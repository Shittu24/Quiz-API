package com.shittu24.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shittu24.quiz.question.Question;
import com.shittu24.quiz.repository.QuestionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService {
	
	private final QuestionRepository questionRepository;

	public ResponseEntity<List<Question>> allQuestions() {
		try {
			return new ResponseEntity<>(questionRepository.findAll(), 
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), 
				HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionRepository.findByCategory(category),
					HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), 
				HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		questionRepository.save(question);
		try {
			return new ResponseEntity<>("Successful",
					HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Unsuccessful", 
				HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> deleteQuestion(int id) {
		questionRepository.deleteById(id);
		try {
			return new ResponseEntity<>("Successfully Deleted",
					HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Unsuccessful", 
				HttpStatus.BAD_REQUEST);
	}
}
