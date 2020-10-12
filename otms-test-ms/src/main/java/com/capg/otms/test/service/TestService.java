package com.capg.otms.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.capg.otms.test.model.Question;
import com.capg.otms.test.model.TestBean;
import com.capg.otms.test.repository.ITestJpaRepo;

@Service
public class TestService implements ITestService{
	
	@Autowired(required = true)
	ITestJpaRepo testRepo;
	
	@Autowired
	RestTemplate resttemplate;
	
	Logger logger = LoggerFactory.getLogger(TestService.class);
	
	double score;
	
	@Override
	public ResponseEntity<List<TestBean>> fetchAllTests(){	
		
		return new ResponseEntity<>(testRepo.findAll(),HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<TestBean> getTest(long testId) {
		
		
		
		if(!testRepo.existsById(testId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(testRepo.getOne(testId),HttpStatus.OK);
	}

  @Override
 @Transactional
  public ResponseEntity<TestBean> addtest (TestBean testBean) {
	  
	  return new ResponseEntity<>(testRepo.save(testBean),HttpStatus.OK);
  }	
  
	@Override
	@Transactional
	public ResponseEntity deleteTest(long testId) {
		
		if(!testRepo.existsById(testId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		testRepo.deleteById(testId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@Override
	@Transactional
	public ResponseEntity<TestBean> updateTest(TestBean newTestData,long testId) {
		
		if(!testRepo.existsById(testId)) {
			logger.error("Test not found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		TestBean testBean=testRepo.getOne(testId);		
		testBean.setTestTitle(newTestData.getTestTitle());
		testBean.setTestDuration(newTestData.getTestDuration());
		testBean.setTestQuestions(newTestData.getTestQuestions());
		testBean.setTestTotalMarks(newTestData.getTestTotalMarks());
		testBean.setTestMarksScored(newTestData.getTestMarksScored());
		testBean.setCurrentQuestion(newTestData.getCurrentQuestion());
		testBean.setStartTime(newTestData.getStartTime());
		testBean.setEndTime(newTestData.getEndTime());
		return new ResponseEntity<>(testRepo.save(testBean),HttpStatus.OK);
}

	
	@Override
	public ResponseEntity<Question> fetchQuestion(long questionId) {
		
		try {
		Question question = resttemplate.getForObject("http://localhost:8030/question/id/"+questionId, Question.class);
		//System.out.println(question);
		if(question==null) {
			logger.info("Question is null");
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(question,HttpStatus.OK);
		}catch(Exception exception) {
			logger.error("Exception raised on test service"+exception.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	@Override
	public ResponseEntity<List<Question>> getTestQuestions(long testId) {
		logger.error("This is the  error for getTestQuestion "); 
		  logger.info("This is the info for getTestQuestion"); 
		  logger.warn("This is the warning for getTestQuestion");
		 // logger.trace("This is the trace for getTestQuestion");
		if(!testRepo.existsById(testId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		TestBean testBean = testRepo.getOne(testId);
		List<Long> questionIds = new ArrayList(testBean.getTestQuestions());
		List<Question> questions = new ArrayList<>();
		for(int index=0; index<questionIds.size();index++) {
			Question question = resttemplate.getForObject("http://localhost:8030/question/id/"+questionIds.get(index), Question.class);
			if(question==null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			else {
				questions.add(question);
			}
		}
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<TestBean> setTestQuestions(long testId, Set<Long> questionIds) {
		logger.error("This is the  error for setTestQuestion "); 
		  logger.info("This is the info for setTestQuestion"); 
		  logger.warn("This is the warning for setTestQuestion");
		  //logger.trace("This is the trace for setTestQuestion");
		if(!testRepo.existsById(testId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		try {
		TestBean testBean = testRepo.getOne(testId);
		List<Long> questionIds2 = new ArrayList(questionIds);
		for(int index=0; index<questionIds2.size();index++) {
			Question question = resttemplate.getForObject("http://localhost:8030/question/id/"+questionIds2.get(index), Question.class);
			if(question==null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
		}
		testBean.setTestQuestions(questionIds);
		
		return new ResponseEntity<>(testRepo.save(testBean),HttpStatus.OK);
		}catch(HttpClientErrorException e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Override
public ResponseEntity<TestBean> assignQuestion(long testId, long questionId) {
		logger.error("This is the  error for assignQuestion "); 
		  logger.info("This is the info for setTestQuestion"); 
		  logger.warn("This is the warning for setTestQuestion");
		  //logger.trace("This is the trace for setTestQuestion");
		if(!testRepo.existsById(testId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		TestBean testBean = testRepo.getOne(testId);
		testBean.getTestQuestions().add(questionId);
		 return new ResponseEntity<>(testRepo.save(testBean),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Double> calculateTotalMarks(long testId) {
		if(!testRepo.existsById(testId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		double score=0;
		TestBean testBean = testRepo.getOne(testId);
		List<Long> questionIds = new ArrayList(testBean.getTestQuestions());
		for(int i=0; i<questionIds.size();i++) {
			Question q = resttemplate.getForObject("http://localhost:8030/question/id/"+questionIds.get(i), Question.class);
			if(q==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
			score = score + q.getMarksScored();
		}}
		return new ResponseEntity<>(score,HttpStatus.OK);
	}
		
	
}