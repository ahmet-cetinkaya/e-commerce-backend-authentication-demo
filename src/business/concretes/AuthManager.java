package business.concretes;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import core.entities.concretes.User;
import core.utils.Validation;
import entities.dtos.UserForLoginDto;
import entities.dtos.UserForRegisterDto;
import entities.dtos.UserForVerificationEmailDto;
import utils.Email;

public class AuthManager implements AuthService {

	private final UserService userService;

	public AuthManager(final UserService userService) {
		this.userService = userService;
	}

	public void checkFirstNameAndLastName(final String firstName, final String lastName) throws Exception {
		final boolean result = firstName.length() >= 2 && lastName.length() >= 2;
		if (!result)
			throw new Exception("Name and surname must be more than 2 letters.");
	}

	public void checkPasswordStrong(final String password) throws Exception {
		final boolean result = password.length() >= 6;
		if (!result)
			throw new Exception("Your password must contain at least 6 characters.");
	}

	public void checkUserExists(final String email) throws Exception {
		final boolean result = false;
		if (result)
			throw new Exception("The user with the email is already registered.");
	}

	@Override
	public void login(final UserForLoginDto userForLoginDto) throws Exception {
		Validation.validateFieldsEmpty(userForLoginDto.getEmail(), userForLoginDto.getPassword());

		System.out.println(userForLoginDto.getEmail() + " successfully logged.");
	}

	@Override
	public void register(final UserForRegisterDto userForRegisterDto) throws Exception {
		checkFirstNameAndLastName(userForRegisterDto.getFirstName(), userForRegisterDto.getLastName());
		Validation.validateEmail(userForRegisterDto.getEmail());
		checkUserExists(userForRegisterDto.getEmail());
		checkPasswordStrong(userForRegisterDto.getPassword());

		sendVerificationEmail(userForRegisterDto.getEmail());

		final User user = new User(1, userForRegisterDto.getEmail(), userForRegisterDto.getPassword(),
				userForRegisterDto.getFirstName(), userForRegisterDto.getLastName());
		userService.add(user);

		System.out.println(userForRegisterDto.getEmail() + " registered.");
	}

	public void sendVerificationEmail(final String email) {
		Email.send(email, "Verification Code : 123");
		System.out.println("Verification email has been sent to " + email + ".");
	}

	public void verifyVerificationEmail(final UserForVerificationEmailDto userForVerificationEmailDto) {
		System.out.println(userForVerificationEmailDto.getEmail() + " email successfully verified with "
				+ userForVerificationEmailDto.getCode() + " code.");
	}

}
