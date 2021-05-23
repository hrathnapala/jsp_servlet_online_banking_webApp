package com.obs.model;

import java.io.Serializable;

public class AdminModel implements Serializable{
		private static final long serialVersionUID = 1L;
		private static String username;
		private static String password;

		public static String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public static String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
}
