import business.abstracts.AuthService;
import business.abstracts.UserService;
import business.concretes.AuthManager;
import business.concretes.GoogleAuthManagerAdapter;
import business.concretes.UserManager;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.HibernateUserDao;
import entities.dtos.UserForLoginDto;
import entities.dtos.UserForRegisterDto;

public class Main {

	public static void main(final String[] args) throws Exception {
		final UserDao userDao = new HibernateUserDao();
		final UserService userService = new UserManager(userDao);
		final AuthService authService = new AuthManager(userService);
		// final AuthService authService = new GoogleAuthManagerAdapter(userService);

		// final UserForRegisterDto userForRegisterDto = new UserForRegisterDto("ahmet4cetinkayaoutlook.com", "123456", "Ahmet", "Çetinkaya");
		// authService.register(userForRegisterDto);
			// Exception in thread "main" java.lang.Exception: Invalid e-mail address.
			// at core.utils.Validation.validateEmail(Validation.java:12)
			// at business.concretes.AuthManager.register(AuthManager.java:48)
			// at Main.main(Main.java:19)

		//final UserForRegisterDto userForRegisterDto = new UserForRegisterDto("ahmet4cetinkaya@outlook.com", "123", "Ahmet", "Çetinkaya");
		// authService.register(userForRegisterDto);
			// Exception in thread "main" java.lang.Exception: Your password must contain at least 6 characters.
			// at business.concretes.AuthManager.checkPasswordStrong(AuthManager.java:29)
			// at business.concretes.AuthManager.register(AuthManager.java:50)
			// at Main.main(Main.java:35)

		// final UserForRegisterDto userForRegisterDto = new UserForRegisterDto("ahmet4cetinkaya@outlook.com", "123456", "A", "Ç");
		// authService.register(userForRegisterDto);
			// Exception in thread "main" java.lang.Exception: Name and surname must be more
			// than 2 letters
			// at business.concretes.AuthManager.checkFirstNameAndLastName(AuthManager.java:23)
			// at business.concretes.AuthManager.register(AuthManager.java:47)
			// at Main.main(Main.java:32)

		final UserForRegisterDto userForRegisterDto = new UserForRegisterDto("ahmet4cetinkaya@outlook.com", "123456", "Ahmet", "Çetinkaya");
		authService.register(userForRegisterDto);
			// E-mail has been sent to ahmet4cetinkaya@outlook.com.
			// Verification email has been sent to ahmet4cetinkaya@outlook.com.
			// User was added with Hibernate.
			// ahmet4cetinkaya@outlook.com registered.
		
		// final UserForLoginDto userForLoginDto = new UserForLoginDto("", "");
		// authService.login(userForLoginDto);
			// Exception in thread "main" java.lang.Exception: Fill in the required fields.
			// at core.utils.Validation.validateFieldsEmpty(Validation.java:18)
			// at business.concretes.AuthManager.login(AuthManager.java:40)
			// at Main.main(Main.java:51)
		
		final UserForLoginDto userForLoginDto = new UserForLoginDto("ahmet4cetinkaya@outlook.com", "123456");
		authService.login(userForLoginDto);
			// ahmet4cetinkaya@outlook.com successfully logged.
	}

}
