package socialnetwork.dto;

import socialnetwork.model.User;

public class UserDTO {
	
	
    private long id ;
	private String  name ;
	private String  lastName ;
	private String  username ;
	
	
	
	
	
	public UserDTO() {
		super();
	}





	public UserDTO(User U) {
		
		this.id = U.getId();
		this.name = U.getFirstName();
		this.lastName = U.getLastName();
		this.username = U.getUsername();
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}





	public String getLastName() {
		return lastName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
	
	
	
}
