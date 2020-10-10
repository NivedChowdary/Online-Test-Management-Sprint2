package com.capg.otms.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.otms.question.model.Question;
import com.capg.otms.question.service.QuestionServiceImpl;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return service.getListOfQuestions();
	}
	
	@GetMapping("/id/{questionId}")	
	public ResponseEntity<Question> getQuestionById(@PathVariable long questionId){
		return service.getQuestionById(questionId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return service.addQuestion(question);
	}
	@PutMapping("/update/{questionId}")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question, @PathVariable long questionId){
		return service.updateQuestion(question,questionId);	
	}
	
	@PutMapping("/updateOption/{questionId}")
	public ResponseEntity<Question> updateOption(@RequestBody Question question, @PathVariable long questionId){
		return service.updateOption(question,questionId);	
	}
	
	@DeleteMapping("/delete/id/{questionId}")
	public ResponseEntity<Question> deleteQuestion(@PathVariable long questionId) {
		return service.deleteQuestion(questionId);
	}
}