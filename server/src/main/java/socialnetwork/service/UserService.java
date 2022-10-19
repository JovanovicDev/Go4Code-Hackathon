package socialnetwork.service;

import javax.swing.Renderer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import socialnetwork.model.User;

import socialnetwork.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public Page<User> findAll(Pageable page) {
		return userRepository.findAll(page);
	}

	public User findOne(Long id) {
		return userRepository.findById(id).get();
	}
	
	
	public User findByUsernameAndPassword(String userName, String password) {
		return userRepository.findByUsernameAndPassword(userName, password);
	}

	

	
}

