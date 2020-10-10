package com.capg.otms.question;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

	import org.junit.jupiter.api.Test;
	
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.otms.question.model.Question;
import com.capg.otms.question.service.QuestionServiceImpl;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class OtmsServiceImpTest {
		@MockBean
		private QuestionServiceImpl service;

		@Test
		void testAddQuestion() {
			
			Question question = new Question();
			question.setQuestionId(10);
			question.setQuestionTitle("JAVA is ____ years old");
			List<String> q = new ArrayList<>();
			q.add("48");
			q.add("30");
			q.add("36");
			q.add("29");
			question.setQuestionOptions(q);
			question.setQuestionAnswer(4);
			question.setQuestionMarks(2.0);
			
			ResponseEntity<Question> q2 = new ResponseEntity<Question>(question, HttpStatus.OK);
			Mockito.when(service.addQuestion(question)).thenReturn(q2);
			assertThat(service.addQuestion(question)).isEqualTo(q2);

		}

		@Test
		void  testUpdateQuestion() {

			Question question = new Question();
			question.setQuestionId(10);
			question.setQuestionTitle("JAVA is ____ years old");
			List<String> q = new ArrayList<>();
			q.add("48");
			q.add("30");
			q.add("36");
			q.add("29");
			question.setQuestionOptions(q);
			question.setQuestionAnswer(4);
			
			ResponseEntity<Question> q2 = new ResponseEntity<Question>(question, HttpStatus.OK);
			Mockito.when(service.addQuestion(question)).thenReturn(q2);
			assertThat(service.addQuestion(question)).isEqualTo(q2);

		}
		@Test
		public void testdeleteQuestion(){
			Question question = new Question();
			
			service.deleteQuestion(10);
			verify(service,times(1)).deleteQuestion(10);
			
		}

}