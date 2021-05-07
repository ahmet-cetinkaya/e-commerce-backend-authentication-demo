package business.abstracts;

import java.util.List;

import core.entities.concretes.User;

public interface UserService {
	void add(User user);

	void delete(User user);

	User get(int id);

	List<User> getAll();

	void update(User user);
}
