package com.capg.otms.user.service;


	import java.net.URISyntaxException;
	import java.util.List;
	import java.util.Set;

	import org.springframework.http.ResponseEntity;
	import org.springframework.web.client.RestClientException;

	import com.capg.otms.user.model.Question;
	import com.capg.otms.user.model.TestBean;
	import com.capg.otms.user.model.User;

	public interface IUserService {
		User addUser(User user);
		User deleteUser(long userId);
		User updateUser(User user);
		User getUser(long userId);
		List<User> getAllUsers();
		User getUserByName(String userName);
		TestBean deleteTest(long testId) throws RestClientException, URISyntaxException;
		TestBean updateTest(TestBean testBean,long testId) throws RestClientException, URISyntaxException;
		TestBean addTest(TestBean testBean);
		Question addQuestions(long testId, Question question) throws RestClientException, URISyntaxException;
		Question deleteQuestions(long testId, long QuestionId) throws RestClientException, URISyntaxException;
		Question updateQuestions(long testId, long questionId, Question question)
				throws RestClientException, URISyntaxException;
		boolean validateAdmin(String userName, String userPassword);
		boolean validateUser(String userName, String userPassword);
		double getResult(long testId);

		List<Question> getTestQuestions(long testId);
		double validateQuestion(long questionId, int chosenAnswer);
		boolean assignTest(long userId, long testId);
	}
