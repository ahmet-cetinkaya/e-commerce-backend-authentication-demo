package entities.dtos;

import core.entities.abstracts.Dto;

public class UserForVerificationEmailDto implements Dto {
	private String email;
	private String code;

	public UserForVerificationEmailDto(final String email, final String code) {
		this.email = email;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public String getEmail() {
		return email;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public void setEmail(final String email) {
		this.email = email;
	}
}
