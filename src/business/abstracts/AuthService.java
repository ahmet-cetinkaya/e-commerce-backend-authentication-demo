package business.abstracts;

import entities.dtos.UserForLoginDto;
import entities.dtos.UserForRegisterDto;

public interface AuthService {
	void login(UserForLoginDto userForLoginDto) throws Exception;

	void register(UserForRegisterDto userForRegisterDto) throws Exception;
}
