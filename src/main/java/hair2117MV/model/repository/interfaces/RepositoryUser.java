package hair2117MV.model.repository.interfaces;

import hair2117MV.model.base.User;

import java.util.List;

public interface RepositoryUser {

	User getByUsername(String username);
	User getByName(String name);
	
	boolean changePasswd(User user, String oldPasswd, String newPasswd);
	
	boolean save();
	
	List<User> getUsers();
	int getCount();
	
}
