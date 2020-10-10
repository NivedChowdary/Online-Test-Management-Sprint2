package com.capg.otms.user.model;


	
	import javax.persistence.*;

@Entity
	@Table(name = "user_info")
	public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long userId ;
		private String userName ;
		private long userTest ;
		private boolean isAdmin ;
		private String userPassword;
		
		public User() { }


		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public long getUserTest() {
			return userTest;
		}

		public void setUserTest(long userTest) {
			this.userTest = userTest;
		}

		public boolean isAdmin() {
			return isAdmin;
		}

		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		
		
	}
