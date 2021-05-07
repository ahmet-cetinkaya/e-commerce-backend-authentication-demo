package dataAccess.concretes;

import java.util.List;

import core.entities.concretes.User;
import dataAccess.abstracts.UserDao;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(final User user) {
		System.out.println("User was added with Hibernate.");
	}

	@Override
	public void delete(final User user) {
		System.out.println("User was deleted with Hibernate.");
	}

	@Override
	public User get(final int id) {
		System.out.println("User was returned with Hibernate.");
		return null;
	}

	@Override
	public List<User> getAll() {
		System.out.println("Users were returned with Hibernate.");
		return null;
	}

	@Override
	public void update(final User user) {
		System.out.println("User was updated with Hibernate.");
	}

}
