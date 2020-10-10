package com.capg.otms.question.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capg.otms.question.model.Question;

public interface IQuestionService {
	 
	ResponseEntity<List<Question>> getListOfQuestions();
	 
	 ResponseEntity<Question> getQuestionById(long QuestionId);
	 
	 ResponseEntity<Question> addQuestion(Question question);
	 
	 ResponseEntity deleteQuestion(long questionId);

	 ResponseEntity<Question> updateQuestion(Question newQuestion, long questionId);

	 ResponseEntity<Question> updateOption(Question newQuestion, long questionId);

}