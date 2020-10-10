package com.capg.otms.test.controller;

import java.time.LocalDateTime;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

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
import org.springframework.web.server.ResponseStatusException;

import com.capg.otms.test.model.Question;
import com.capg.otms.test.model.TestBean;
import com.capg.otms.test.service.TestService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/test")
public class TestController {

	@Autowired
	 TestService service;
	
	@PostConstruct
	public void init() {
	Set<Long> questions=new HashSet<>();
	//questions.addAll(Arrays.asList(109L,101L,102L));
	TestBean testBean=new TestBean( "spring Test", LocalTime.of(1, 30), questions, 100, 0, 1L, LocalDateTime.of(2020, 05,2, 14, 0), LocalDateTime.of(2020, 05,2, 15, 30));
	service.addtest(testBean);
	}
	
	@GetMapping("/id/{testId}")
	public ResponseEntity<TestBean> getTest(@PathVariable long testId){
	return service.getTest(testId);	
	}
	@GetMapping("/all")
	public ResponseEntity<List<TestBean>> getAllTests(){
	return service.fetchAllTests();	
	}
	@PostMapping("/add")
	public ResponseEntity<TestBean> addTest(@RequestBody TestBean testBean){
		return service.addtest(testBean);
	}
	@PutMapping("/update/{testId}")
	public ResponseEntity<TestBean> updateTest(@RequestBody TestBean testBean,@PathVariable long testId){
		return service.updateTest(testBean ,testId);
	}	
	@PutMapping("/assign/{testId}/question/{questionId}")
	public ResponseEntity<TestBean> assignQuestion(@PathVariable long testId, @PathVariable long questionId) {
		return service.assignQuestion(testId, questionId);
	}
	
	@DeleteMapping("delete/id/{testId}")
	public ResponseEntity<TestBean> deleteTest(@PathVariable long testId){
	return service.deleteTest(testId);
	}
	@GetMapping("/calculate/{testId}")
	public ResponseEntity<Double> calculateTotalMarks(@PathVariable long testId){
		return service.calculateTotalMarks(testId);
	}
	@GetMapping("/question/{questionId}")
	public ResponseEntity<Question> fetchQuestion(@PathVariable long questionId){
		return service.fetchQuestion(questionId);
	}
	@PutMapping("/setTestQuestions/testId/{testId}")
	public ResponseEntity<TestBean> setTestQuestions(@PathVariable long testId, @RequestBody Set<Long> qIds){
		return service.setTestQuestions(testId, qIds);
	}
	@GetMapping("/questions/{testId}")
	public ResponseEntity<List<Question>> getTestQuestions(@PathVariable long testId){
		return service.getTestQuestions(testId);
	}
}