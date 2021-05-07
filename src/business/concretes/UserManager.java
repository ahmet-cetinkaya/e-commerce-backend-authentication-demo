package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import core.entities.concretes.User;
import dataAccess.abstracts.UserDao;

public class UserManager implements UserService {

	private final UserDao userDao;

	public UserManager(final dataAccess.abstracts.UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(final User user) {
		userDao.add(user);
	}

	@Override
	public void delete(final User user) {
		userDao.delete(user);
	}

	@Override
	public User get(final int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void update(final User user) {
		userDao.update(user);
	}

}
