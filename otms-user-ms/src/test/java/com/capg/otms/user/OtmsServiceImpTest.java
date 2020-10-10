package com.capg.otms.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;

	import java.util.List;

	import org.junit.jupiter.api.Test;
	
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.test.context.junit4.SpringRunner;

	
	import com.capg.otms.user.model.User;
import com.capg.otms.user.service.UserServiceImpl;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class OtmsServiceImpTest {
		@MockBean
		private UserServiceImpl service;

		@Test
		void testAddUser() {

			User user = new User();
			user.setUserId(101);
			user.setUserName("chandu");
			user.setUserPassword("demo123");
			user.setAdmin(true);
			

			Mockito.when(service.addUser(user)).thenReturn(user);
			assertThat(service.addUser(user)).isEqualTo(user);

		}

		@Test
		void  testUpdateUser() {

			User user = new User();
			user.setUserId(101);
			user.setUserName("rajesh");
			user.setUserPassword("demo");
			user.setAdmin(false);
			

			Mockito.when(service.updateUser(user)).thenReturn(user);
			assertThat(service.updateUser(user)).isEqualTo(user);

		}
		@Test
		public void testdeleteUser(){
			User User=new User();
			
			service.deleteUser(101);
			verify(service,times(1)).deleteUser(101);
			
		}

}