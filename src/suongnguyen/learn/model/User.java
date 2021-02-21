package suongnguyen.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@Column(name = "username", nullable = false, length = 100)
	private String username;
	
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	
	public User() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) return false;
		if (!(obj instanceof User)) return false;
		
		User user = (User) obj;
		
		if (!( user.getUsername().equals( this.username ) ) ) return false;
		
		if (!( user.getPassword().equals( this.password ) ) ) return false;
		
		return true;
	}
}
