
	package com.capg.otms.user.repository;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.capg.otms.user.model.User;
	import org.springframework.data.jpa.repository.Query;

	public interface IUserRepo extends JpaRepository<User, Long> {

		@Query(value = "from User where userName=:userName")
		public User getUserByName(String userName);

	}

