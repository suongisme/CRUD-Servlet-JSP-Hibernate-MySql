package suongnguyen.learn.dao;

import java.util.List;

import suongnguyen.learn.model.User;

public interface UserDAO {
	public void submit(User data);
	public void delete(String id);
	public User getById(String id);
	public List<User> getAll();
}
