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
	/******************************************
	  - Method Name         : getTest
	  - Input Parameters    : long testId
	  - Return Type         : Test
	  - End Point Url       : /id
	  - Request Method Type : GetMapping 
	  - Author              : Nived 
	  - Creation Date       : 28/09/2020
	  - Description         : Getting the Test detail from the database
	 ******************************************/
	@GetMapping("/id/{testId}")
	public ResponseEntity<TestBean> getTest(@PathVariable long testId){
	return service.getTest(testId);	
	}
	/******************************************
	  - Method Name         : getAllTest
	  - Input Parameters    : none
	  - Return Type         : Test
	  - End Point Url       : /all
	  - Request Method Type : GetMapping 
	  - Author              : Nived 
	  - Creation Date       : 28/09/2020
	  - Description         : Getting the Test details from the database
	 ******************************************/
	@GetMapping("/all")
	public ResponseEntity<List<TestBean>> getAllTests(){
	return service.fetchAllTests();	
	}
	/******************************************
	  - Method Name         : addTest
	  - Input Parameters    : Test testBean
	  - Return Type         : Test
	  - End Point Url       : /add
	  - Request Method Type : PostMapping 
	  - Author              : Nived 
	  - Creation Date       : 28/09/2020
	  - Description         : Adding the Test details in to the database
	 ******************************************/
	@PostMapping("/add")
	public ResponseEntity<TestBean> addTest(@RequestBody TestBean testBean){
		return service.addtest(testBean);
	}
	/******************************************
	  - Method Name         : updateTest
	  - Input Parameters    : Test newTestData, long testId
	  - Return Type         : Test
	  - End Point Url       : /update
	  - Request Method Type : PutMapping 
	  - Author              : Nived 
	  - Creation Date       : 28/09/2020
	  - Description         : Updating the Test details in to the database
	 ******************************************/
	@PutMapping("/update/{testId}")
	public ResponseEntity<TestBean> updateTest(@RequestBody TestBean testBean,@PathVariable long testId){
		return service.updateTest(testBean ,testId);
	}	
	/******************************************
	  - Method Name         : assignQuestion
	  - Input Parameters    : long testId, long QuestionId
	  - Return Type         : Test
	  - End Point Url       : /assign
	  - Request Method Type : PutMapping 
	  - Author              : Nived 
	  - Creation Date       : 28/09/2020
	  - Description         : assigning test to user
	 ******************************************/
	@PutMapping("/assign/{testId}/question/{questionId}")
	public ResponseEntity<TestBean> assignQuestion(@PathVariable long testId, @PathVariable long questionId) {
		return service.assignQuestion(testId, questionId);
	}
	/******************************************
	  - Method Name         : deleteTest
	  - Input Parameters    : long testId
	  - Return Type         : Test
	  - End Point Url       : /delete
	  - Request Method Type : DeleteMapping 
	  - Author              : Nived 
	  - Creation Date       : 28/09/2020
	  - Description         : deleting the Test details from the database
	 ******************************************/
	@DeleteMapping("delete/id/{testId}")
	public ResponseEntity<TestBean> deleteTest(@PathVariable long testId){
	return service.deleteTest(testId);
	}
	
	
	/******************************************
	  - Method Name         : fetchQuestion
	  - Input Parameters    : long testId
	  - Return Type         : Question
	  - End Point Url       : /question
	  - Request Method Type : PutMapping 
	  - Author              : Nived 
	  - Creation Date       : 28/09/2020
	  - Description         : fetching questions
	 ******************************************/
	@GetMapping("/question/{questionId}")
	public ResponseEntity<Question> fetchQuestion(@PathVariable long questionId){
		return service.fetchQuestion(questionId);
	}
	/******************************************
	  - Method Name         : setTestQuestions
	  - Input Parameters    : long testId, long questionIds
	  - Return Type         : Test
	  - End Point Url       : /setTestQuestions
	  - Request Method Type : PutMapping 
	  - Author              : Nived 
	  - Creation Date       : 28/09/2020
	  - Description         : assigning questions to test
	 ******************************************/
	@PutMapping("/setTestQuestions/testId/{testId}")
	public ResponseEntity<TestBean> setTestQuestions(@PathVariable long testId, @RequestBody Set<Long> questionIds){
		return service.setTestQuestions(testId, questionIds);
	}
	/******************************************
	  - Method Name         : getTestQuestions
	  - Input Parameters    : long testId
	  - Return Type         : Question
	  - End Point Url       : /setTestQuestions
	  - Request Method Type : PutMapping 
	  - Author              : Nived 
	  - Creation Date       : 28/09/2020
	  - Description         : assigning questions to test
	 ******************************************/
	@GetMapping("/questions/{testId}")
	public ResponseEntity<List<Question>> getTestQuestions(@PathVariable long testId){
		return service.getTestQuestions(testId);
	}
}