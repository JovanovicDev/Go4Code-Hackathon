package socialnetwork.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import socialnetwork.dto.UserDTO;

import socialnetwork.model.User;
import socialnetwork.service.UserService;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<UserDTO>> getAllUsers(Pageable page) {
		Page<User> users = userService.findAll(page);
		
		List<UserDTO> retVal = new ArrayList<>();
	
		for(User U : users) {
			retVal.add(new UserDTO(U));
		}
		

		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getPost(@PathVariable Long id) {
		User item = userService.findOne(id);
		UserDTO dto = new UserDTO(item);

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<User> findByUserNameAndPassword(@RequestParam(required = true, value = "username") String username,
			@RequestParam(required = true, value = "password") String password){
		
		User user = userService.findByUsernameAndPassword(username, password);
		if(user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		
	}
	
	
	

}
