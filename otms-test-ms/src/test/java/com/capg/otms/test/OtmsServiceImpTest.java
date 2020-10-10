package com.capg.otms.test;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
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

import com.capg.otms.test.model.TestBean;
import com.capg.otms.test.service.TestService;


	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class OtmsServiceImpTest {
		@MockBean
		private TestService service;

		@Test
		void testAddTest() {
			
			TestBean test = new TestBean();
			test.setTestId(10);
			test.setTestTitle("python test");
			test.setCurrentQuestion(0);
			test.setStartTime(LocalDateTime.now());
			test.setEndTime(LocalDateTime.now());
			
			ResponseEntity<TestBean> t2 = new ResponseEntity<TestBean>(test, HttpStatus.OK);
			Mockito.when(service.addtest(test)).thenReturn(t2);
			assertThat(service.addtest(test)).isEqualTo(t2);

		}

		@Test
		void  testUpdateTest() {

			TestBean test = new TestBean();
			test.setTestId(10);
			test.setTestTitle("java test");
			test.setCurrentQuestion(0);
			
			ResponseEntity<TestBean> t2 = new ResponseEntity<TestBean>(test, HttpStatus.OK);
			Mockito.when(service.addtest(test)).thenReturn(t2);
			assertThat(service.addtest(test)).isEqualTo(t2);

		}
		@Test
		public void testdeleteTest(){
			TestBean test = new TestBean();
			
			service.deleteTest(10);
			verify(service,times(1)).deleteTest(10);
			
		}

}