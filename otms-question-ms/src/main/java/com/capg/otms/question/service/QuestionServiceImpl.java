package com.capg.otms.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.otms.question.exception.QuestionNotFoundException;
import com.capg.otms.question.model.Question;
import com.capg.otms.question.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired(required = true)
	QuestionRepository questionRepo;
	
	@Override
	public ResponseEntity<List<Question>> getListOfQuestions() {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(questionRepo.findAll(),HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Question> getQuestionById(long questionId) {
		if(!questionRepo.existsById(questionId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<>(questionRepo.getOne(questionId),HttpStatus.OK);
	}
	
	@Override
	@Transactional
	public ResponseEntity<Question> addQuestion(Question question) {
		return new ResponseEntity<>(questionRepo.save(question),HttpStatus.OK);	
	}
	
	@Override
	@Transactional
	public ResponseEntity deleteQuestion(long questionId) {
		if(!questionRepo.existsById(questionId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		questionRepo.deleteById(questionId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@Override
	@Transactional
	public ResponseEntity<Question> updateOption(Question newQuestion,long questionId) {
		if(!questionRepo.existsById(questionId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		Question question=questionRepo.getOne(questionId);
		if(question!=null) {
			question.setChosenAnswer(newQuestion.getChosenAnswer());
		}
		return new ResponseEntity<>(questionRepo.save(question),HttpStatus.OK);
	}
	@Override
	@Transactional
	public ResponseEntity<Question> updateQuestion(Question newQuestion,long questionId) {
		if(!questionRepo.existsById(questionId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		Question question=questionRepo.getOne(questionId);
		if(question!=null) {
			question.setQuestionTitle(newQuestion.getQuestionTitle());
			question.setQuestionOptions(newQuestion.getQuestionOptions());
			question.setQuestionMarks(newQuestion.getQuestionMarks());
			question.setQuestionAnswer(newQuestion.getQuestionAnswer());
		}
		return new ResponseEntity<>(questionRepo.save(question),HttpStatus.OK);
	}
}