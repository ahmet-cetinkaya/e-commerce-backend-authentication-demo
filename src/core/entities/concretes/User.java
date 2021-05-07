package core.entities.concretes;

import core.entities.abstracts.Entity;

public class User implements Entity {
	private int id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;

	public User(final int id, final String email, final String password, final String firstName,
			final String lastName) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

}
