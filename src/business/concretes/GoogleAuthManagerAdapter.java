package business.concretes;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import core.entities.concretes.User;
import entities.dtos.UserForLoginDto;
import entities.dtos.UserForRegisterDto;
import googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService {
	private final GoogleAuthManager googleAuthManager = new GoogleAuthManager();
	private final UserService userService;

	public GoogleAuthManagerAdapter(final UserService userService) {
		this.userService = userService;
	}

	@Override
	public void login(final UserForLoginDto userForLoginDto) throws Exception {
		final boolean result = googleAuthManager.auth();
		if (!result)
			throw new Exception("Google authorization failed.");
		System.out.println(userForLoginDto.getEmail() + " successfully logged.");
	}

	@Override
	public void register(final UserForRegisterDto userForRegisterDto) throws Exception {
		final boolean result = googleAuthManager.auth();
		if (!result)
			throw new Exception("Google authorization failed.");

		final User user = new User(1, userForRegisterDto.getEmail(), userForRegisterDto.getPassword(),
				userForRegisterDto.getFirstName(), userForRegisterDto.getLastName());
		userService.add(user);

		System.out.println(userForRegisterDto.getEmail() + " registered.");
	}

}
