package dataAccess.abstracts;

import java.util.List;

import core.entities.concretes.User;

public interface UserDao {
	void add(User user);

	void delete(User user);

	User get(int id);

	List<User> getAll();

	void update(User user);
}
