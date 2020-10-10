package com.capg.otms.test.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.capg.otms.test.model.Question;
import com.capg.otms.test.model.TestBean;
public interface ITestService{
	
		public ResponseEntity<TestBean> addtest(TestBean testBean);
		public ResponseEntity<TestBean> updateTest(TestBean testBean,long testId);
		public ResponseEntity deleteTest(long testId);
		public ResponseEntity<TestBean>  getTest(long testId);
		public ResponseEntity<List<TestBean>> fetchAllTests();
		ResponseEntity<Double> calculateTotalMarks(long testId);
		ResponseEntity<List<Question>> getTestQuestions(long testId);
		ResponseEntity<TestBean> setTestQuestions(long testId, Set<Long> qIds);
		ResponseEntity<Question> fetchQuestion(long questionId);
		public ResponseEntity<TestBean> assignQuestion(long testId, long questionId);
	}