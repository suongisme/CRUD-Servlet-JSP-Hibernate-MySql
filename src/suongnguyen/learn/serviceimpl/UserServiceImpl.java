package suongnguyen.learn.serviceimpl;

import java.util.List;

import suongnguyen.learn.dao.UserDAO;
import suongnguyen.learn.daoimpl.UserDaoImpl;
import suongnguyen.learn.model.User;
import suongnguyen.learn.service.UserService;

public class UserServiceImpl implements UserService{

	UserDAO userDao = new UserDaoImpl();
	
	@Override
	public void submit(User data) {
		if (data == null) return;
		userDao.submit(data);
	}

	@Override
	public void delete(String id) {
		if (id == null || id.isEmpty()) return;
		userDao.delete(id);
	}

	@Override
	public User getById(String id) {
		if (id == null || id.isEmpty()) return null;
		return userDao.getById(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

}
