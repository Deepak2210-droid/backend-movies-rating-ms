package dev.deepak.movies_ms.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document("User")
@NoArgsConstructor
public class User {
	private String userName;
	private String password;
	private String email;

	public User(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
}
